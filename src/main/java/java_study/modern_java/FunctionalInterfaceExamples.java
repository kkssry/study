package java_study.modern_java;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaceExamples {
    public static void main(String[] args) {
        final Product productA = new Product(1L, "A", new BigDecimal("10.00"));
        final Product productB = new Product(2L, "B", new BigDecimal("55.50"));
        final Product productC = new Product(3L, "C", new BigDecimal("17.45"));
        final Product productD = new Product(4L, "D", new BigDecimal("20.00"));
        final Product productE = new Product(5L, "E", new BigDecimal("110.99"));
        final List<Product> products = Arrays.asList(productA, productB, productC, productD, productE);

        final BigDecimal twenty = new BigDecimal("20");

        System.out.println("products >= $20 " +   // 가격이 $20 이상 되는 Proudct 찾기
                filter(products, product -> product.price.compareTo(twenty) >= 0)
                // [Product{id=2, name='B', price=55.50}, Product{id=4, name='D', price=20.00}, Product{id=5, name='E', price=110.99}]
        );

        System.out.println("products <= $10 " +   // 가격이 $10 이하 되는 Product 찾기
                filter(products, product -> product.price.compareTo(new BigDecimal(10)) <= 0)
                // [Product{id=1, name='A', price=10.00}]
        );

        final List<Product> expensiveProducts =
                filter(products, product -> product.price.compareTo(new BigDecimal(50)) > 0);

        final List<DiscountedProduct> discountedProduct =         // $ 50 달러 이상 품목을 찾은후, 50% 할인 가격 적용
                map(expensiveProducts, product ->
                        new DiscountedProduct(product.id, product.name, product.price.multiply(new BigDecimal("0.5"))));

        System.out.println("expensive products : " + expensiveProducts);
        // [Product{id=2, name='B', price=55.50}, Product{id=5, name='E', price=110.99}]

        System.out.println("discounted products : " + discountedProduct);
        //[Product{id=2, name='B', price=27.750}, Product{id=5, name='E', price=55.495}]

        final Predicate<Product> lessThanOrEqual30 = product -> product.price.compareTo(new BigDecimal(30)) <= 0;
        System.out.println("discounted products (<=$30) : " + filter(discountedProduct, lessThanOrEqual30));
        //[Product{id=2, name='B', price=27.750}]

        System.out.println("products(<=$30) : " + filter(products, lessThanOrEqual30));
        // [Product{id=1, name='A', price=10.00}, Product{id=3, name='C', price=17.45}, Product{id=4, name='D', price=20.00}]




        final BigDecimal total = total(products, product -> product.price);
        System.out.println("total : " + total);  // 213.94

        final BigDecimal discountedTotal = total(discountedProduct, Product::getPrice);
        System.out.println("discountedTotal : " + discountedTotal);  // 83.245

        final Order order = new Order(1L, "on-1234", Arrays.asList(
                new OrderedItem(1L, productA, 2),
                new OrderedItem(2L, productB, 1),
                new OrderedItem(3L, productC, 10)
        ));



        BigDecimal orderTotal = BigDecimal.ZERO;
        for (OrderedItem item : order.items) {
            orderTotal = orderTotal.add(item.saveItemPrice());
        }
        System.out.println("orderTotal : " + orderTotal);       // 250.00

    }

    private static <T> List<T> filter(final List<T> list, final Predicate<? super T> predicate) {       // T 타입의 자손 타입 허용
        final List<T> result = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }


    private static <T, R> List<R> map(final List<T> list, final Function<T, R> function) {
        final List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(function.apply(t));      /// 타입 변환
        }
        return result;
    }

    private static <T> BigDecimal total(final List<T> list, final Function<T, BigDecimal> mapper) {
        BigDecimal toal = BigDecimal.ZERO;
        for (T t : list) {
            toal = toal.add(mapper.apply(t));
        }
        return toal;
    }


    // 객체 (롬복 적용이 안된다)
    static class Product {
        private Long id;
        private String name;
        private BigDecimal price;

        Product(Long id, String name, BigDecimal price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        BigDecimal savePrice(int quantity) {
            return price.multiply(new BigDecimal(quantity));
        }

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }

        BigDecimal getPrice() {
            return price;
        }
    }

    static class DiscountedProduct extends Product {
        DiscountedProduct(final Long id, final String name, final BigDecimal price) {
            super(id, name, price);
        }
    }

    static class OrderedItem {
        private Long id;
        private Product product;
        private int quantity;

        OrderedItem(Long id, Product product, int quantity) {
            this.id = id;
            this.product = product;
            this.quantity = quantity;
        }

        BigDecimal saveItemPrice() {
            return product.savePrice(quantity);
        }
    }

    static class Order {
        private Long id;
        private String orderNumber;
        private List<OrderedItem> items;

        Order(Long id, String orderNumber, List<OrderedItem> items) {
            this.id = id;
            this.orderNumber = orderNumber;
            this.items = items;
        }

        public BigDecimal totalPrice() {
            return BigDecimal.ONE;
        }
    }
}

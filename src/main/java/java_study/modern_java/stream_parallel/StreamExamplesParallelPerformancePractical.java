package java_study.modern_java.stream_parallel;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamExamplesParallelPerformancePractical {
    private static final String[] priceStrings = {"1.0", "100.99", "35.75", "21.30", "88.00"};
    private static final BigDecimal[] targetPrices = {new BigDecimal("30"), new BigDecimal("20"), new BigDecimal("31")};
    private static final Random targetPriceRandom = new Random(111);
    private static final List<Product> products;

    static {
        final int length = 8_000_000;
        final Product[] productsContainer = new Product[length];

        for (int i = 1; i <= length; i++) {
            productsContainer[i - 1] = new Product((long) i, "Product" + i, new BigDecimal(priceStrings[new Random(123).nextInt(5)]));
        }
        products = Collections.unmodifiableList(Arrays.asList(productsContainer));
        // 리스트 꽉차면 1.5배가 늘어나므로 크기가 정해진 배열을 가지고 리스트로 바꿔줌.
        // 추가, 삭제, 교체를 시도할 경우 UnsupportedOperationException이 발생한다.
    }

    private static BigDecimal imperativeSum(final List<Product> products, final Predicate<Product> predicate) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Product product : products) {
            if (predicate.test(product)) {
                sum = sum.add(product.price);
            }
        }
        return sum;
    }

    private static BigDecimal streamSum(final Stream<Product> stream, final Predicate<Product> predicate) {
        return stream.filter(predicate).map(p -> p.price).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private static void imperativeTest(final BigDecimal targetPrice, final boolean isPrintResult) {
        /*
        (Stream 사용 이외의) 이런 코드 작성을 권장 하지 않는다.
        빌드등 여러가지 일을 해야 하므로 첫 테스트는 실행은 하되, 주목하진 않는다. (streamTest, parallelStreamTest 메서드도 동일하게 구성)
         */
        final long fakeStart = System.currentTimeMillis();
        final BigDecimal fakeResult = imperativeSum(products, product -> product.price.compareTo(targetPrice) >= 0);
        final long fakeHowLong = System.currentTimeMillis() - fakeStart;

        if (isPrintResult) {
            System.out.println("===================================");
            System.out.println("Imperative Sum-----------------------------------");

            final long start = System.currentTimeMillis();
            final BigDecimal result = imperativeSum(products, product -> product.price.compareTo(targetPrice) >= 0);
            final long howLong = System.currentTimeMillis() - start;

            System.out.println("Sum: " + result);
            System.out.println("It took " + howLong + " ms.");
            System.out.println("====================================");
        }
    }

    private static void streamTest(final BigDecimal targetPrice, final boolean isPrintResult) {
        final long fakeStart = System.currentTimeMillis();
        final BigDecimal fakeResult = imperativeSum(products, product -> product.price.compareTo(targetPrice) >= 0);
        final long fakeHowLong = System.currentTimeMillis() - fakeStart;

        if (isPrintResult) {
            System.out.println("===================================");
            System.out.println("Stream sum----------------------------------------");

            final long start = System.currentTimeMillis();
            final BigDecimal result = streamSum(products.stream(), product -> product.price.compareTo(targetPrice) >= 0);
            final long howLong = System.currentTimeMillis() - start;

            System.out.println("Sum: " + result);
            System.out.println("It took " + howLong + "ms.");
            System.out.println("========================================");
        }
    }

    private static void parallelStreamTest(final BigDecimal targetPrice, final boolean isPrintResult) {
        final long fakeStart = System.currentTimeMillis();
        final BigDecimal fakeResult = imperativeSum(products, product -> product.price.compareTo(targetPrice) >= 0);
        final long fakeHowLong = System.currentTimeMillis() - fakeStart;

        if (isPrintResult) {
            System.out.println("===================================");
            System.out.println("Parallel Stream sum----------------------------------------");

            final long start = System.currentTimeMillis();
            final BigDecimal result = streamSum(products.parallelStream(), product -> product.price.compareTo(targetPrice)>=0);
            final long howLong = System.currentTimeMillis() - start;

            System.out.println("Sum: " + result);
            System.out.println("It took " + howLong + " ms.");
            System.out.println("=============================================");
        }
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    private static void test1() {
        final BigDecimal targetPrice = new BigDecimal("40");

        imperativeTest(targetPrice, false);
        streamTest(targetPrice, false);
        parallelStreamTest(targetPrice, false);

        System.out.println("\n\n===============================================Test1 Starts!");
        for (int i = 0; i < 5; i++) {
            BigDecimal price = targetPrices[targetPriceRandom.nextInt(3)];

            imperativeTest(price,true);
            streamTest(price,true);
            parallelStreamTest(price,true);
        }
        System.out.println("\n\n===============================================Test1 End!");
    }

    private static void test2() {
        final BigDecimal targetPrice = new BigDecimal("40");

        parallelStreamTest(targetPrice, false);
        imperativeTest(targetPrice, false);
        streamTest(targetPrice, false);

        System.out.println("\n\n===============================================Test2 Starts!");
        for (int i = 0; i < 5; i++) {
            BigDecimal price = targetPrices[targetPriceRandom.nextInt(3)];

            imperativeTest(price,true);
            streamTest(price,true);
            parallelStreamTest(price,true);
        }
        System.out.println("\n\n===============================================Test2 End!");
    }

    private static void test3() {
        final BigDecimal targetPrice = new BigDecimal("40");

        streamTest(targetPrice, false);
        parallelStreamTest(targetPrice, false);
        imperativeTest(targetPrice, false);

        System.out.println("\n\n===============================================Test3 Starts!");
        for (int i = 0; i < 5; i++) {
            BigDecimal price = targetPrices[targetPriceRandom.nextInt(3)];

            imperativeTest(price,true);
            streamTest(price,true);
            parallelStreamTest(price,true);
        }
        System.out.println("\n\n===============================================Test3 End!");
    }


    static class Product {
        private long id;
        private String name;
        private BigDecimal price;

        Product(Long id, String name, BigDecimal price) {
            this.id = id;
            this.name = name;
            this.price = price;

        }
    }
}


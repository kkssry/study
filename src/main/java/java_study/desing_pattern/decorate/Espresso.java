package java_study.desing_pattern.decorate;

public class Espresso extends AbstAdding {
    static protected int espressoCount = 0;

    public Espresso(IBeverage base) {
        super(base);
    }

    @Override
    public int getTotalPrice() {
        int price = super.getTotalPrice() + getAddPrice();
        System.out.println(super.toString() + " " + super.getTotalPrice());
        return price;
    }

    private static int getAddPrice() {
        espressoCount += 1;
        int addPrice = 100;

        if (espressoCount > 1) {
            addPrice = 70;
        }
        return addPrice;
    }
}

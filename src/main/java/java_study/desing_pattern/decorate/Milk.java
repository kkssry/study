package java_study.desing_pattern.decorate;

public class Milk extends AbstAdding {

    public Milk(IBeverage base) {
        super(base);
    }

    @Override
    public int getTotalPrice() {
        return super.getTotalPrice() + 50;
    }

}

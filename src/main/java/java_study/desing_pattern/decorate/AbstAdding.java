package java_study.desing_pattern.decorate;

public abstract class AbstAdding implements IBeverage {
    private IBeverage base;

    public AbstAdding(IBeverage base) {
        this.base = base;
    }

    @Override
    public int getTotalPrice() {
        return base.getTotalPrice();
    }

    public IBeverage getBase() {
        return base;
    }
}

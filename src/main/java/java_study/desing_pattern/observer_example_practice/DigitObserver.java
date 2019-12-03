package java_study.desing_pattern.observer_example_practice;

public class DigitObserver implements Observer{
    @Override
    public void update(NumberGenerator generator) {
        System.out.println("NumberObserver : " + generator.getNum());
    }
}

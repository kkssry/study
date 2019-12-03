package java_study.desing_pattern.observer_example;

public class  DigitObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        System.out.println("DigitObserver: " + generator.getNum());
    }
}

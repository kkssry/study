package java_study.desing_pattern.observer_example;

public class Main {
    public static void main(String[] args) {
        NumberGenerator generator = new RandomNumberGenerator();
        Observer observer = new DigitObserver();
        Observer observer2 = new GraphObserver();

        generator.addObserver(observer);
        generator.addObserver(observer2);

        generator.execute();

    }
}

package java_study.desing_pattern.observer_example_practice;

public class GraphObserver implements Observer {
    @Override
    public void update(NumberGenerator generator) {
        int size = generator.getNum();
        System.out.print("GraphObserver : ");
        for (int i = 0; i < size; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}

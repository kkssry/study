package java_study.desing_pattern.observer_example_practice;

import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator {
    private int num;

    @Override
    public int getNum() {
        return num;
    }

    @Override
    public void execute() {
        for (int i = 0; i < 10; i++) {
            num = new Random().nextInt(30);
            super.notifyObserver();
            try {
                Thread.sleep(200);
            } catch (InterruptedException ignored) {}
        }
    }
}

package java_study.desing_pattern.observer_example;

import java.util.Random;

public class RandomNumberGenerator extends NumberGenerator {
    private Random rand = new Random();
    private int num;

    @Override
    public int getNum() {
        return num;
    }

    @Override
    public void execute() {
        for (int i = 0; i < 10; i++) {
            num = rand.nextInt(30);
            super.notifyObserver();
            try {
                Thread.sleep(200);
            } catch (InterruptedException ignored) {}
        }
    }
}

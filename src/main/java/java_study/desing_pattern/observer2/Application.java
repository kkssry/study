package java_study.desing_pattern.observer2;

public class Application {
    public static void main(String[] args) {
        Button button = new Button();
        button.addObserver((o, arg) -> System.out.println(o + " is Clicked"));
        button.onClick();
        button.onClick();
        button.onClick();

    }
}

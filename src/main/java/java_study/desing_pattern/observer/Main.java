package java_study.desing_pattern.observer;

public class Main {
    public static void main(String[] args) {
        Button button = new Button();

        button.setOnClickListener(button1 -> System.out.println(button + " is Clicked"));
        button.onClick();

        ButtonClick buttonClick = new ButtonClick();
        buttonClick.onClick(button);

    }
}
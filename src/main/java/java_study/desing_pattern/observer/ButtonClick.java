package java_study.desing_pattern.observer;

public class ButtonClick implements Button.OnClickListener {
    @Override
    public void onClick(Button button) {
        System.out.println(button + " is ButtonClicked");
    }
}

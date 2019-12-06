package java_study.desing_pattern.facade.System;

public class HelpSystem3 {

    public HelpSystem3() {
        System.out.println("Call Constructor : " + getClass().getSimpleName());
    }

    public void process() {
        System.out.println("Call Process : " + getClass().getSimpleName());
    }
}

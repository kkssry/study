package java_study.modern_java;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<String> consum = System.out::println;
        consum.accept("Hello");     // print Hello


        Consumer<String> cons = string -> System.out.println("Hello " + string);
        cons.accept("World!");   //print Hello World

    }
}

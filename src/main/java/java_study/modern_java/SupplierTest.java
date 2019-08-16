package java_study.modern_java;

import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {
        Supplier<String> helloSupplier = () -> "Hello ";
        System.out.println(helloSupplier.get() + "World");      //Hello World



        long start = System.currentTimeMillis();
        /*

        printIfValidIndex(0, getVeryExpensiveValues());
        printIfValidIndex(-1, getVeryExpensiveValues());
        printIfValidIndex(-2, getVeryExpensiveValues());
        System.out.println("it took " + (System.currentTimeMillis() - start) / 1000 + " seconds.");     // 9 seconds

         */

        printIfValidIndex(0, () -> getVeryExpensiveValues());
        printIfValidIndex(-1, () -> getVeryExpensiveValues());
        printIfValidIndex(-2, SupplierTest::getVeryExpensiveValues);
        System.out.println("it took " + (System.currentTimeMillis() - start) / 1000 + " seconds.");     // 3 seconds (lazy evaluation)
    }

    private static String getVeryExpensiveValues() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Let`s just say it has very expensive calculation here!
        return "Kevin";
    }

    /*

    private static void printIfValidIndex(int number, String value) {
        if (number >=0 ) {
            System.out.println("The value is " + value + " .");
        } else {
            System.out.println("Invalid");
        }
    }

     */

    private static void printIfValidIndex(int number, Supplier<String> valueSupplier) {
        if (number >= 0) {
            System.out.println("The value is " + valueSupplier.get() + " .");
        } else {
            System.out.println("Invalid");
        }
    }
}

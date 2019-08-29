package java_study.modern_java.closure;

/*
클로저(closure)는 내부함수(익명 메서드 -> 람다)가 외부함수의 변수에 접근할 수 있는 것을 가르킨다.
단, 변수는 변경되어선 안된다.
 */

public class ClosureExamples {
    private int number = 999;

    public static void main(String[] args) {
        ClosureExamples tests = new ClosureExamples();
        tests.test();
        tests.test1();
        tests.test2();
        tests.test3();
        tests.test4();
    }

    private void test() {
        System.out.println("=================test Starts!!!!=======================");
        int number = 100;

        testClosure("Anonymous Class", new Runnable() {
            @Override
            public void run() {
                System.out.println(number);
            }
        });

        testClosure("Lambda Expression", () -> System.out.println(number));
        System.out.println("=====================test End!!!============================\n");
    }

    private void test1() {
        System.out.println("=================test1 Starts!!!!=======================");
        int number = 100;

        testClosure("Anonymous  Class", new Runnable() {
            @Override
            public void run() {
                System.out.println(ClosureExamples.this.number);
            }
        });

        testClosure("Lambda Expression", () -> System.out.println(this.number));
        System.out.println("=================test1 End!!!!=======================\n");
    }

    private void test2() {
        System.out.println("=================test2 Starts!!!!=======================");
        testClosure("Anonymous Class", new Runnable() {
            @Override
            public void run() {
                System.out.println("this.toString(): " + this.toString());
            }
        });

        testClosure("Anonymous Class", new Runnable() {
            @Override
            public void run() {
                System.out.println("ClosureExamples.this.toString(): " + ClosureExamples.this.toString());
            }
        });

        testClosure("Lambda Expression", () -> System.out.println("this.toString(): " + this.toString()));
        System.out.println("=================test2 End!!!!=======================\n");
    }

    private void test3() {
        System.out.println("=================test3 Starts!!!!=======================");
        System.out.println("\"ClosureExamples calling toString()\": " + toString());
        System.out.println("\"ClosureExamples calling toString(int, String): " + toString(1, "Hello") + "\n");

        testClosure("Anonymous Class", new Runnable() {
            @Override
            public void run() {
//                System.out.println("toString(int, String): " + toString(1, "Test"));    -> toString(int, String) causes compile-time error
                System.out.println("toString(int, String) causes compile-time error");
                System.out.println("ClosureExamples.toString(int, String): " + ClosureExamples.toString(1, "Test"));
                System.out.println("ClosureExamples.this.toString(int): " + ClosureExamples.this.toString(1) + "\n");
            }
        });

        testClosure("Anonymous Class", new Runnable() {
            @Override
            public void run() {
//                System.out.println("toString(int): " + toString(1));    -> "toString(int) causes compile-time error
                System.out.println("toString(int) causes compile-time error");
                System.out.println("ClosureExamples.this.toString(int, String): " + ClosureExamples.this.toString(1) + "\n");
            }
        });

        testClosure("Lambda Expression", () -> System.out.println("this.toString(int, String): " + this.toString(1, "Test")));
        testClosure("Lambda Expression", () -> System.out.println("toString(int, String): " + toString(1, "Test")));
        testClosure("Lambda Expression", () -> System.out.println("this.toString(int): " + this.toString(1)));
        testClosure("Lambda Expression", () -> System.out.println("toString(int):" + toString(1)));
        System.out.println("=================test3 End!!!!=======================\n");
    }

    private void test4() {
        System.out.println("=================test4 Starts!!!!=======================");
        int number = 100;

        testClosure("Anonymous Class", new Runnable() {
            @Override
            public void run() {
                int number = 50;    //no compile-time error
                System.out.println(number);
            }
        });

        testClosure("Lambda Expression", () -> {
//            int number = 50;      // compile-time error
            System.out.println(number);
        });
        System.out.println("=================test4 End!!!!=======================");
    }

    @Override
    public String toString() {
        return new StringBuilder("ClosureExamples{")
                .append("number=")
                .append(number)
                .append('}')
                .toString();
    }

    private static void testClosure(final String name, final Runnable runnable) {
        System.out.println(name + " : ");
        runnable.run();
    }

    private String toString(int number) {
        return "#" + number;
    }

    private static <T> String toString(int number, T value) {
        return "[" + number + "] The value is " + value + ".";
    }
}

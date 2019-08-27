package java_study.modern_java;

import java.util.function.Function;

public class FunctionTest {
    public static void main(String[] args) {
        /*

        Function<String,Integer> toInt = new Function<String, Integer>() {
            @Override
            public Integer apply(String value) {
                return Integer.parseInt(value);
            }
        }

         */

        Function<String, Integer> toInt = Integer::parseInt;
        System.out.println(toInt.apply("10"));



        Function<Integer, Integer> identity = Function.identity();       //Function 클래스의 identity 메서드는 같은 타입의 값을 그대로 리턴하는 메서드다.
        Function<Integer, Integer> identity2 = i -> i;
        System.out.println(identity.apply(999));
        System.out.println(identity2.apply(999));

    }
}

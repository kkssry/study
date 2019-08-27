package java_study.modern_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class StreamPrelude {
    public static void main(String[] args) {
        /*

        System.out.println(Integer.MIN_VALUE);                          -2147483648
        System.out.println(Integer.MAX_VALUE);                          2147483647

        java는 signed int이기 때문에 -2^31 ~ 2^31 -1 의 범위이므로 표현하지 못함

        System.out.println(Math.abs(Integer.MIN_VALUE));                -2147483648
        System.out.println(Math.abs(Math.abs(Integer.MAX_VALUE)));      2147483647

         */

        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(
                map(numbers, i -> i * 2)        // 2, 4, 6, 8, 10
        );

        System.out.println(
                map(numbers, Function.identity())   // 1, 2, 3, 4, 5 (그대로 출력)
        );

        /*
        System.out.println(
                map(numbers, null)      // 1, 2, 3, 4, 5
        );
         */


    }

    private static <T, R> List<R> map(final List<T> list, final Function<T, R> mapper) {
        /*
        mapper가 null을 허용하면 조건문이 생기면서 강제 타입 변환도 해주므로 코드가
        깔끔하지 못하다.

        final Function<T, R> function;
        if (mapper != null) {
            function = mapper;
        } else {
            function =t -> (R) t;
        }
         */
        final List<R> result = new ArrayList<>();
        for (final T t : list) {
            result.add(mapper.apply(t));
        }

        return result;
    }
}

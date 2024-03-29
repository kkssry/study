package java_study.modern_java.higher_order_function;

import javafx.beans.property.IntegerProperty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
higher order function 이란 함수 매개변수에 함수가 있거나
함수 반환타임이 함수를 리턴하는 경우를 말한다.
 */

public class HigherOrderFunctionExamples {
    public static void main(String[] args) {
        final Function<Function<Integer, String>, String> f = g -> g.apply(10);
        System.out.println(
                f.apply(i -> "#" + i)             // "#10"
        );

        final Function<Function<Integer, String>, Integer> f1 = g -> Integer.valueOf(g.apply(10));
        System.out.println(
                f1.apply(i -> String.valueOf(123 + i))             // 133
        );

        final Function<Integer, Function<Integer, Integer>> f2 = i -> i2 -> i + i2;
        System.out.println(
                f2.apply(1).apply(9)        //10
        );

        final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        final List<String> mappedList = map(list, i -> "#" + i);
        System.out.println(
                mappedList
        );

        System.out.println(
                list.stream()
                        .filter(i -> i > 2)
                        .map(i -> "#" + i)
                        .collect(Collectors.toList())
        );

        Function<Integer, Function<Integer, Function<Integer, Integer>>> f3 =
                i1 -> i2 -> i3 -> i1 + i2 + i3;

        System.out.println(
                "f3.apply(1).apply(2).apply(3) = " + f3.apply(1).apply(2).apply(3)
        );

        final Function<Integer, Function<Integer, Integer>> plus10 = f3.apply(10);
        System.out.println(
                "plus10.apply(1).apply(1) = " + plus10.apply(1).apply(1)
        );

    }


    private static <T, R> List<R> map(List<T> list, Function<T, R> mapper) {
        final List<R> result = new ArrayList<>();
        for (T t : list) {
            result.add(mapper.apply(t));
        }
        return result;
    }
}

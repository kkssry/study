package java_study.modern_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-5, -4, -3, -2, 0, 1, 2, 3, 4, 5);

        /*
        List<Integer> positiveNumbers = new ArrayList<>();
        Predicate<Integer> zeroMoreThan = i -> i > 0;
        for (Integer number : numbers) {
            if (zeroMoreThan.test(number)) {
                positiveNumbers.add(number);
            }
        }

        List<Integer> lessThan3Numbers = new ArrayList<>();
        Predicate<Integer> lessThan3 = i -> i < 3;
        for (Integer number : numbers) {
            if (lessThan3.test(number)) {
                lessThan3Numbers.add(number);
            }
        }

        System.out.println("positiveNumbers: " + positiveNumbers);
        System.out.println("lessThan3Numbers: " + lessThan3Numbers);
        */


        Predicate<Integer> zeroMoreThan = i -> i > 0;
        Predicate<Integer> lessThan3 = i -> i < 3;

        System.out.println(filter(numbers, zeroMoreThan));
        System.out.println(filter(numbers, lessThan3));
    }

    private static <T> List<T> filter(List<T> list, Predicate<T> filter) {
        List<T> result = new ArrayList<>();
        for (T number : list) {
            if (filter.test(number)) {
                result.add(number);
            }
        }
        return result;
    }
}

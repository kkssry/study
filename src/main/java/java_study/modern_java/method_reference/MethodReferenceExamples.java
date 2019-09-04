package java_study.modern_java.method_reference;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MethodReferenceExamples {
    public static void main(String[] args) {
        Arrays.asList(1, 2, 3, 4, 5)
                .forEach(System.out::println);
        // .forEach(i-> System.out.println(i));

        System.out.println(
                Arrays.asList(new BigDecimal("10.0"), new BigDecimal("23"), new BigDecimal("5"))
                        .stream()
                        .sorted(BigDecimal::compareTo)
                        //.sorted((bd1, bd2) -> bd1.compareTo(bd2))
                        .collect(Collectors.toList())
        );

        System.out.println("\n The following three cases have the same result.");
        System.out.println("-------------------------------------------------");
        final List<String> abcdList = Arrays.asList("a", "b", "c", "d");
        final String targetString = "c";
        System.out.println("list: " + abcdList);

        System.out.println("targetString: \"c\"");
        System.out.println("\nanyMatch(targetString::equals)\n" +
                abcdList.stream().anyMatch(targetString::equals)
        );

        System.out.println("\nanyMatch(\"c\"::equals)\n" +
                abcdList.stream().anyMatch("c"::equals)
        );

        System.out.println("\nanyMatch(x -> x.equals(\"C\"))\n" +
                abcdList.stream().anyMatch(x -> x.equals("C"))
        );

        System.out.println("\n=====================================");
        System.out.println("methodReference03();");
        System.out.println("----------------------------------------");
        methodReference03();


    }

    private static void methodReference03() {
        /* First Class Function */

        /*
          A function can be passed  as a parameter to another function.
        */
        // 1. Using Lambda Expression
        System.out.println(testFirstClassFunction1(3, i -> String.valueOf(i * 2)));

        // 2. Using Method Reference
        System.out.println(testFirstClassFunction1(3, MethodReferenceExamples::doubleThenToString));

        /*
          A function can be returned as thre result of another function.
         */
        // 1. Using Lambda Expression
        final Function<Integer, String> f1 = getDoubleThenToStringUsingLambdaExpression();
        final String resultFromF1 = f1.apply(3);
        System.out.println(resultFromF1);

        // 2. Using Method Reference
        final Function<Integer, String> fmr = getDoubleThenToStringUsingMethodReference();
        final String resultFromFmr = fmr.apply(3);
        System.out.println(resultFromFmr);

        System.out.println("\n--------------------------------------------");

        // 3. Both Lambda Expression and Method Reference
        final List<Function<Integer, String>> fsBoth =
                Arrays.asList(
                        i -> String.valueOf(i * 2),
                        MethodReferenceExamples::doubleThenToString,
                        MethodReferenceExamples::addHashPrefix
                );

        for (final Function<Integer, String> f : fsBoth) {
            final String result = f.apply(7);
            System.out.println(result);
        }
    }

    private static String addHashPrefix(int number) {
        return "#" + number;
    }

    private static Function<Integer, String> getDoubleThenToStringUsingMethodReference() {
        return MethodReferenceExamples::doubleThenToString;
    }

    private static Function<Integer, String> getDoubleThenToStringUsingLambdaExpression() {
        return i -> String.valueOf(i * 2);

    }

    private static String testFirstClassFunction1(int n, Function<Integer, String> f) {
        return "The result is " + f.apply(n) + ".";

    }

    private static String doubleThenToString(int i) {
        return String.valueOf(i * 2);
    }
}

package java_study.modern_java.parallel_stream;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamExamplesParallel {
    public static void main(String[] args) {
        raceConditionTest();

        int numberOfCores = Runtime.getRuntime().availableProcessors();     //사용중인 컴퓨터의 코어 개수를 찾는 코드 입니다.

        streamTest(numberOfCores);

        parallelStreamTest(numberOfCores);
        parallelStreamTest(numberOfCores + 1);

    }

    private static void raceConditionTest() {
        System.out.println("=======================================");
        System.out.println("StreamExamplesParallel.raceConditionTest\n");


        final int[] sum = {0};
        IntStream.range(0, 100)
                .forEach(i -> sum[0] += i);
        System.out.println("stream sum (side-effect): " + sum[0]);


        final int[] sum2 = {0};
        IntStream.range(0, 100)
                .parallel()        // 다중 코어 일시 코어가 서로 자원에 접근하려고 한다.
                .forEach(i -> sum2[0] += i);
        System.out.println("parallel sum (side-effect): " + sum2[0]);


        System.out.println("stream sum (no side-effect): " +
                IntStream.range(0, 100)
                         .sum()
        );


        System.out.println("parallel stream sum (no side-effect): " +
                IntStream.range(0, 100)
                        .parallel()
                        .sum()
        );
    }

    private static void streamTest(int numberOfCores) {
        System.out.println("=================================");
        System.out.println("StreamExamplesParallel.streamTest\n");
        final List<Integer> numbers = getNumbers(numberOfCores);

        System.out.println("Stream (" + numbers.size() + " elements)");
        final long start = System.currentTimeMillis();
        numbers.stream()
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i;
                })
                .forEach(i-> System.out.println(i));
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void parallelStreamTest(int numberOfCores) {
        System.out.println("==================================");
        System.out.println("StreamExamplesParallel.parallelStreamTest\n");
        final List<Integer> numbers = getNumbers(numberOfCores);

        System.out.println("Parallel Stream (" + numbers.size() + " elements)");
        final long start = System.currentTimeMillis();
        numbers.parallelStream()
               .map(i-> {
                   try {
                        TimeUnit.SECONDS.sleep(1);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                   return i;
               })
               .forEach(i-> System.out.println(i));
        System.out.println(System.currentTimeMillis() - start);


    }

    private static List<Integer> getNumbers(final int howMany) {
        return IntStream.rangeClosed(1, howMany)
                .mapToObj(i->i)     // auto-boxing을 통해서 int가 Integer로 자동 변환 됩니다.
                .collect(Collectors.toList());
    }
}

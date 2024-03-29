package java_study.modern_java.stream_basic;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples1 {
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 10).forEach(i -> System.out.println(i + " "));     // include endIndex
        IntStream.iterate(1, i -> i + 1).forEach(i-> System.out.print(i+" "));  // infinite increase
        Stream.iterate(BigInteger.ONE , i-> i.add(BigInteger.ONE)).forEach(i-> System.out.print(i + " ")); // infinite increase
    }
}

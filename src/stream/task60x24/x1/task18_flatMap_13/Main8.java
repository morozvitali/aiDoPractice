package stream.task60x24.x1.task18_flatMap_13;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Stream;

public class Main8 {
    public List<String> practice1() {
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are cool",
                "Java makes sense"
        );
        return sentences.stream().flatMap(s -> Arrays.stream(s.split(" "))).map(String::toLowerCase).distinct().toList();
    }

    public int practice2() {
        int[][] data = {
                {3, 11},
                {6, 7},
                {10}
        };

        return Arrays.stream(data).flatMapToInt(Arrays::stream)
                .min().orElse(-1);
    }

    public int practice3() {
        int[][] data = {
                {-3, 5},
                {2},
                {-1, 4}
        };

        return Arrays.stream(data).flatMapToInt(Arrays::stream)
                .filter(a -> a % 2 == 0)
                .min()
                .orElse(-1);
    }

    public int practice4() {

        int[][] data = {
                {3, 9},
                {8, 12},
                {7}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream)
                .filter(a -> a % 3 == 0)
                .max()
                .orElse(-1);
    }

    public int practice5() {
        int[][] data = {
                {2, 3},
                {4}
        };

        return Arrays.stream(data).flatMapToInt(Arrays::stream)
                .filter(i -> i % 2 == 0)
                .map(a -> a * a)
                .sum();
    }

    public int practice6() {
        int[][] data = {
                {3, 5},
                {7}
        };

        IntSummaryStatistics stats = Arrays.stream(data).flatMapToInt(Arrays::stream)
                .filter(i -> i % 2 == 1)
                .summaryStatistics();


        return stats.getCount() == 0 ? -1 : (int) stats.getAverage();
    }

    public int practice7() {
        int[][] data = {
                {12},
                {24, 36}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream)
                .reduce(Main8::gcd).orElse(-1);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        Main8 m = new Main8();
        m.practice1();
    }

    public List <Integer> practice8 () {
        return Stream.of(10, "hello", true, 42, false, "42")
                .filter(value-> value instanceof Integer)
                .map(val->(Integer)val)
                .toList();
            }

    public List <String> practice9 () {
        return Stream.of("hello", 1, 2.5, true, "world")
                .filter(value -> value instanceof String)
                .map(value->(String)value)
                .toList();
    }

    public List <Integer> practice10 () {
        return Stream.of("a", 3, 15, 11, 9, "99")
                .filter(value->value instanceof Integer && (Integer) value > 10)
                .map(value -> (Integer)value)
                .toList();

    }

    public List <Boolean> practice11 () {
        return Stream.of("yes", true, false, true, 1)
                .filter(value->value instanceof Boolean && (Boolean) value)
                .map(value-> (Boolean)value)
                .toList();
    }

    public List <String> practice12 () {
        return Stream.of("hi", 123, "bye", false)
                .filter(value -> value instanceof String)
                .map(value->((String)value).toUpperCase())
                .toList();
    }
}

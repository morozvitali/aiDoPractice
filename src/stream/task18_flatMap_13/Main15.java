package stream.task18_flatMap_13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main15 {
    public List<String> practice1() {
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are cool",
                "Java makes sense"
        );
        return sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" "))).distinct().toList();
    }

    public Integer practice2() {
        int[][] data = {
                {3, 11},
                {6, 7},
                {10}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream)
                .filter(a -> a % 2 == 0)
                .min()
                .orElse(-1);
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
                {-3, 5},
                {2},
                {-1, 4}
        };

        return Arrays.stream(data).flatMapToInt(Arrays::stream)
                .filter(a -> a > 0)
                .reduce((a, b) -> a * b).orElse(-1);
    }

    public int practice5() {
        int[][] data = {
                {2, 3},
                {4}};

        return Arrays.stream(data).flatMapToInt(Arrays::stream)
                .filter(a -> a % 2 == 0).map(a -> a * a)
                .sum();
    }

    public Double practice6() {
        int[][] data = {
                {2, 3},
                {4}};

        return Arrays.stream(data).flatMapToInt(Arrays::stream)
                .filter(a -> a % 2 == 1)
                .summaryStatistics()
                .getAverage();
    }

    public int practice7 () {
        int[][] data = {
                {12},
                {24, 36}
        };

        return Arrays.stream(data).flatMapToInt(Arrays::stream).reduce(Main15::gcd).orElse(-1);
    }

    public static int gcd (int a, int b) {
        return b==0 ? a : gcd (b, a%b);
    }

    public List <Integer> practice8 () {
        return Stream.of(10, 42).filter(a->a instanceof Integer).map(i->(Integer)i)
                .toList();
    }

    public List <String> practice9 () {
        return Stream.of("hello", 1, 2.5, true, "world").filter(s->s instanceof String).map(s->(String)s).toList();
    }

    public List<Integer> practice10 () {
        return Stream.of("a", 3, 15, 11, 9, "99")
                .filter(a->a instanceof Integer && (Integer)a >10).map(a->(Integer)a).toList();
    }

    public List<Boolean> practice11 () {
        return Stream.of ("yes", true, false, true, 1)
                .filter(b->b instanceof Boolean && (Boolean)b==true).map(b->(Boolean)b).toList();
    }

    public List <String> practice12 () {
        return Stream.of("hi", 123, "bye", false).filter(w->w instanceof String).map(w->(String)w).map(String::toUpperCase).toList();
    }

}
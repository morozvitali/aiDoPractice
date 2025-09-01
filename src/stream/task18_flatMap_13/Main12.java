package stream.task18_flatMap_13;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main12 {
    public List<String> practice1(List<String> sentences) {

        return sentences.stream().flatMap(w -> Arrays.stream(w.split(" ")))
                .map(String::toLowerCase).distinct().collect(Collectors.toList());
    }

    public int practice2() {
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
                .filter(a -> a > 0)
                .reduce((a, b) -> a * b)
                .orElse(-1);
    }

    public int practice4 () {
        int[][] data = {
                {3, 9},
                {8, 12},
                {7}
        };

        return Arrays.stream(data).flatMapToInt(Arrays::stream)
                .filter(a->a%3==0)
                .max()
                .orElse(-1);
    }

    public int practice5 () {
        int[][] data = {
                {2, 3},
                {4}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream)
                .filter(a->a%2==0)
                .map(a->a*a)
                .sum();
    }

    public Double practice6 () {
        int[][] data = {
                {3, 5},
                {7}
        };
        IntSummaryStatistics stats = Arrays.stream(data).flatMapToInt(Arrays::stream)
                .summaryStatistics();
        return stats.getCount() == 0? -1 : stats.getAverage();
    }

    public int practice7 () {
        int[][] data = {
                {12},
                {24, 36}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).reduce(Main12::gcd).orElse(-1);
    }

    public static int gcd (int a, int b) {
        return b==0? a : gcd(b, a%b);
    }

    public void practice8 () {
        Stream.of(10, "hello", true, 42, false, "42").filter(v-> v instanceof Integer).map(i->(Integer)i).toList();
    }

    public void practice9 () {
        Stream.of("hello", 1, 2.5, true, "world").filter(val->val instanceof String).map(v->(String)v).toList();
    }



}

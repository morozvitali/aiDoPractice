package stream.task18_flatMap_13;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class Main25 {

    public List<String> practice1(List<String> sentences) {
        return sentences.stream()
                .flatMap(s -> Arrays.stream(s.split(" ")))
                .map(String::toLowerCase)
                .distinct()
                .toList();
    }

    public int practice2() {
        int[][] data = {
                {3, 11},
                {6, 7},
                {10}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a -> a % 2 == 0).min().orElse(-1);
    }

    public int practice3() {
        int[][] data = {
                {-3, 5},
                {2},
                {-1, 4}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a -> a > 0).reduce((a, b) -> a * b).orElse(-1);
    }

    public int practice4() {
        int[][] data = {
                {3, 11},
                {6, 7},
                {10}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a -> a % 3 == 0).max().orElse(-1);
    }

    public int practice5() {
        int[][] data = {
                {2, 3},
                {4}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a -> a % 2 == 0).map(a -> a * a).sum();
    }

    public IntSummaryStatistics practice6() {
        int[][] data = {
                {2, 3},
                {4}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a -> a % 2 == 0).summaryStatistics();
    }

    public int practice7 () {
        int[][] data = {
                {12},
                {24, 36}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).reduce(Main25::gcd).orElse(-1);
    }

    public static int gcd (int a, int b) {
        return b==0 ? a : gcd (b, a%b);
    }

    public List <Integer> practice8 (List <Object> input) {
        return input.stream().filter(x-> x instanceof Integer).map(i->(Integer)i).toList();
    }

    public List <String> practice9 (List <Object> input) {
        return input.stream().filter(x-> x instanceof String).map(i-> (String) i).toList();
    }


}
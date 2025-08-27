package stream.task18_flatMap_13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main9 {
    public List<String> practice1() {
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are cool",
                "Java makes sense"
        );

        return sentences.stream().flatMap(s -> Arrays.stream(s.split(" ")))
                .distinct().toList();
    }

    public int practice2() {
        int[][] data = {
                {3, 11},
                {6, 7},
                {10}
        };

        return Arrays.stream(data).flatMapToInt(Arrays::stream).min().orElse(-1);
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

        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a -> a % 2 == 0)
                .map(a -> a * a).sum();
    }

    public int practice6() {
        int[][] data = {
                {2, 3},
                {4}
        };

        return Arrays.stream(data).flatMapToInt(Arrays::stream)
                .filter(a -> a % 2 == 0)
                .map(a -> a * a)
                .sum();
    }

    public int practice7() {
        int[][] data = {
                {12},
                {24, 36}
        };

        return Arrays.stream(data).flatMapToInt(Arrays::stream)
                .reduce(Main9::gcd)
                .orElse(-1);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public List <Integer> practice8 () {
        return Stream.of(10, "hello", true, 42, false, "42").filter(v->v instanceof Integer).map(i->(Integer)i).toList();
    }


}

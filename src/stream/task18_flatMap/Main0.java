package stream.task18_flatMap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Main0 {
    public void practice1() {
        List<List<Integer>> weeklyData = List.of(
                List.of(40, 55, 60),
                List.of(30, 70),
                List.of(65, 10, 90)
        );

        weeklyData.stream().flatMap(list -> list.stream())
                .filter(value -> value > 50)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    public void practice2() {
        int[][] data = {
                {3, 11},
                {6, 7},
                {10}
        };

        Arrays.stream(data).flatMapToInt(arr -> Arrays.stream(arr))
                .filter(a -> a % 2 == 0)
                .min()
                .orElse(-1);
    }

    public void practice3() {
        int[][] data = {
                {-3, 5},
                {2},
                {-1, 4}
        };

        Arrays.stream(data).flatMapToInt(arr -> Arrays.stream(arr)).filter(a -> a > 0).reduce((a, b) -> a * b).orElse(-1);
    }

    public void practice4() {
        int[][] data = {
                {3, 9},
                {8, 12},
                {7}
        };
        Arrays.stream(data).flatMapToInt(arr -> Arrays.stream(arr)).filter(a -> a % 3 == 0).max().orElse(-1);
    }

    public void practice5() {
        int[][] data = {
                {2, 3},
                {4}
        };

        Arrays.stream(data).flatMapToInt(arr -> Arrays.stream(arr)).filter(a -> a % 2 == 0).map(n -> n * n).sum();
    }

    public void practice6() {
        int[][] data = {
                {3, 5},
                {7}
        };

        IntSummaryStatistics stats = Arrays.stream(data).flatMapToInt(arr -> Arrays.stream(arr)).filter(a -> a % 2 != 0).summaryStatistics();
        int result = stats.getCount() == 0 ? -1 : (int) stats.getAverage();
        System.out.println(result);
    }

    public void practice7() {
        int[][] data = {
                {12},
                {24, 36}
        };
        Arrays.stream(data).flatMapToInt(arr -> Arrays.stream(arr)).reduce(Main0::gcd).orElse(-1);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public void practice8() {
        List.of(10, "hello", true, 42, false, "42").stream().filter(value -> value instanceof Integer).collect(Collectors.toList());
    }

    public void practice9() {
        List.of("hello", 1, 2.5, true, "world").stream().filter(value -> value instanceof String).collect(Collectors.toList());
    }

    public void practice10() {
        List.of("a", 3, 15, 11, 9, "99").stream().filter(value -> value instanceof Integer && (Integer) value > 10).collect(Collectors.toList());
    }

    public void practice11 () {
        List.of("yes", true, false, true, 1).stream().filter(value -> value instanceof Boolean && (Boolean) value == true).collect(Collectors.toList());
    }


}

package stream1.task5_peek_mapping_chartoint_8;

import java.util.stream.IntStream;

public class Main7 {
    public int practice1(int n) {
        return String.valueOf(n).chars()
                .map(c -> c - '0')
                .map(d -> d * d)
                .sum();
    }

    public Boolean practice2(int n) {
        return String.valueOf(n).chars()
                .map(c -> c - '0')
                .allMatch(d -> d % 2 == 0);
    }

    public int practice3(int n) {
        return String.valueOf(n).chars()
                .map(c -> c - '0')
                .max()
                .orElse(-1);
    }

    public long practice4(int n) {
        return String.valueOf(n).chars()
                .map(c -> c - '0')
                .filter(a -> a <= 5)
                .count();
    }

    public int practice5(int n) {
        int[] arr = String.valueOf(n).chars().map(c -> c - '0')
                .toArray();
        return IntStream.range(0, arr.length).filter(i -> i % 2 == 1)
                .map(i -> arr[i])
                .reduce((a, b) -> a * b)
                .orElse(-1);
    }
}

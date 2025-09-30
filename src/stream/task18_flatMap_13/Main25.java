package stream.task18_flatMap_13;

import java.util.Arrays;
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

    public int practice5 () {
        int[][] data = {
                {2, 3},
                {4}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a->a%2==0).map(a->a*a).sum();
    }



}

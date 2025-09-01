package stream.task18_flatMap_13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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




}

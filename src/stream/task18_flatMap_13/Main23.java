package stream.task18_flatMap_13;

import java.util.Arrays;
import java.util.List;

public class Main23 {
    public List<String> practice1() {
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are cool",
                "Java makes sense"
        );
        return sentences.stream().flatMap(s -> Arrays.stream(s.split(" "))).distinct().toList();
    }

    public Integer practice2() {
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
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a -> a % 3 == 0).max().orElse(-1);
    }

    public int practice5() {

        int[][] data = {
                {3, 9},
                {8, 12},
                {7}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a -> a % 3 == 0).map(a -> a * a).sum();
    }

    public Double practice6() {
        int[][] data = {
                {3, 9},
                {8, 12},
                {7}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a -> a % 2 == 1).summaryStatistics().getAverage();
    }

    public int practice7() {
        int[][] data = {
                {3, 9},
                {8, 12},
                {7}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).reduce(Main23::gcd).orElse(-1);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public List<Integer> practice8(List<Object> list) {
        return list.stream().filter(i -> i instanceof Integer).map(i -> (Integer) i).toList();
    }

    public List<String> practice9(List<Object> list) {
        return list.stream().filter(s -> s instanceof String).map(s -> (String) s).toList();
    }

    public List<Integer> practice10(List<Object> list) {
        return list.stream().filter(i -> i instanceof Integer && (Integer) i > 10).map(i -> (Integer) i).toList();
    }

    public List <Boolean> practice11 (List <Object> list) {
        return list.stream().filter(b->b instanceof Boolean && (Boolean)b == true).map(b->(Boolean)b).toList();
    }

    public List <String> practice12 (List <Object> list) {
        return list.stream().filter(s->s instanceof String).map(w->((String) w).toUpperCase()).toList();
    }


}

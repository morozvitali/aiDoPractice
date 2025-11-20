package stream1.task18_flatMap_13;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main29 {
    public void task1() {
        List<String> sentences = List.of(
                "Java is powerful",
                "Streams are cool",
                "Java makes sense"
        );

        sentences.stream().flatMap(sentence -> Arrays.stream(sentence.split(" "))).distinct().collect(Collectors.toList());
    }


    public int task2() {
        int[][] data = {
                {3, 11},
                {6, 7},
                {10}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a -> a % 2 == 0).min().orElse(-1);
    }

    public int task3() {
        int[][] data = {
                {-3, 5},
                {2},
                {-1, 4}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a -> a > 0).reduce((a, b) -> a * b).orElse(-1);
    }


    public int task4() {
        int[][] data = {
                {3, 9},
                {8, 12},
                {7}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a -> a % 3 == 0).max().orElse(-1);
    }


    public int task5() {
        int[][] data = {{2, 3}, {4}};
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a -> a % 2 == 0).map(a -> a * a).sum();
    }

    public double task6() {
        int[][] data = {
                {3, 5},
                {7}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).filter(a -> a % 2 == 1).average().orElse(-1);
    }

    public int task7() {
        int[][] data = {
                {12},
                {24, 36}
        };
        return Arrays.stream(data).flatMapToInt(Arrays::stream).reduce(Main29::gcd).orElse(-1);
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public List<Integer> task8(List<Object> list) {
        return list.stream().filter(a -> a instanceof Integer).map(a -> (Integer) a).toList();
    }

    public List<String> task9(List<Object> list) {
        return list.stream().filter(s -> s instanceof String).map(s -> (String) s).toList();
    }

    public List<Integer> task10(List<Object> list) {
        return list.stream().filter(a -> a instanceof Integer && (Integer) a > 10).map(a -> (Integer) a).toList();
    }

    public List<Boolean> task11(List<Object> list) {
        return list.stream().filter(b -> b instanceof Boolean && (Boolean) b == true).map(b -> (Boolean) b).toList();
    }

    public List<String> task12 (List <Object> list) {
        return list.stream().filter(a->a instanceof String).map(s->((String)s).toUpperCase()).toList();
    }


}

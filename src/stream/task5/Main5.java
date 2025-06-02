package stream.task5;

import java.util.Arrays;
import java.util.List;

public class Main5 {
    public int practice1() {
        int[] numbers = {15, 3, 8, 22, 1, 10};
        return Arrays.stream(numbers)
                .reduce((a, b) -> a < b ? a : b).orElse(0);
    }

    public String practice2() {
        String[] words = {"Java", "Python", "C++"};
        return Arrays.stream(words)
                .reduce((a,b) -> a + " " + b).orElse("");
    }

    public int practice3 () {
        int[] numbers = {123, 91, 77, 456, 18};
        return Arrays.stream(numbers)
                .reduce(0, (a,b) -> calc(a) > calc(b) ? a : b);
    }

    public int calc (int value) {
        int sum = 0;
        while (true) {
            sum = sum + value % 10;
            value = value / 10;
        }
    }

    public void practice4 () {
        List<Integer> list = List.of(10, 20, 30, 40, 50);
        list.stream().limit(3).forEach(System.out::println);
    }

    public void practice5 () {
        List<Integer> list = List.of(5, 6, 7, 8, 9);
        list.stream().skip(3).forEach(System.out::println);
    }



}

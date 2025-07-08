package stream.task99skip.task8star_IntStream;

import java.util.Arrays;

public class Main3 {

    public int myFilter0 () {
        return Arrays.stream(new int [] {2, 8, 15, 21, 4, 9})
                .filter(a-> a%2 != 0)
                .reduce(-1, (a,b) -> a > b ? a : b);
    }

    public int myFilter1() {
        return Arrays.stream(new int[] {-5, 3, 0, -2, 10, 1})
                .filter(a -> a > 0)
                .reduce((a,b) -> a>=b ? a:b)
                .orElse(-1);
    }

    public int myFilter2() {
        return Arrays.stream (new int[] {4, 9, 6, 14, 21, 5})
                .filter (a->a%3 == 0)
                .reduce((a,b) -> a <= b ? a : b)
                .orElse(-1);
    }

    public int myFilter3() {
        return Arrays.stream (new int[] {7, 13, 4, 6, 9})
                .filter (a->a%2 == 0)
                .reduce((a,b) -> a <= b ? a : b)
                .orElse(-100);
    }

    public int myFilter4() {
        return Arrays.stream (new int[] {710, 40, 55, 49, 60, 30})
                .filter (a->a < 50)
                .reduce((a,b) -> a >= b ? a : b)
                .orElse(-1);
    }

    public int myFilter5 () {
        return Arrays.stream (new int[] {3, 5, 2, 6})
                .filter (a->a % 2 != 0)
                .map(a-> a*a)
                .reduce((a,b) -> a >= b ? a : b)
                .orElse(-1);
    }
}

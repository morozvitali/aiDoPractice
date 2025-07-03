package stream.task8star_IntStream;

import java.util.Arrays;

public class Main6 {
    public int practice0() {
        int[] numbers = {2, 8, 15, 21, 4, 9};
        return Arrays.stream(numbers).filter(a -> a % 2 == 1)
                .reduce((a, b) -> a > b ? a : b).orElse(-1);
    }

    public void practice1() {
        int[] numbers = {-5, 3, 0, -2, 10, 1};
        Arrays.stream(numbers)
                .filter(a -> a > 0)
                .reduce((a, b) -> a < b ? a : b)
                .orElse(-1);
    }

    public int practice2() {
        int[] numbers = {4, 9, 6, 14, 21, 5};
        return Arrays.stream(numbers).filter(a -> a % 3 == 0).reduce((a, b) -> a > b ? a : b).orElse(-1);
    }

    public int practice3 () {
        int[] numbers = {7, 13, 4, 6, 9};
        return Arrays.stream(numbers)
                .filter(a->a%2==0)
                .reduce ((a,b)-> a>b? a:b).orElse(-100);
    }

    public int practice4 () {
        int[] numbers = {10, 40, 55, 49, 60, 30};
        return Arrays.stream(numbers).filter(a->a<50)
                .reduce((a,b)-> a>b?a:b).orElse(-1);
    }



}

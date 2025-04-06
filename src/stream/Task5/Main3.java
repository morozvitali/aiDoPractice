package stream.Task5;

import java.util.Arrays;

public class Main3 {
    public int myReduce1() {
        return Arrays.stream(new int[]{15, 3, 8, 22, 1, 10})
                .reduce(Integer.MIN_VALUE, Math::max);
    }

    public String myReduce2() {
        return Arrays.stream(new String[]{"Java", "Python", "C++" })
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
    }

    public int myReduce3() {
        return Arrays.stream(new int []{23, 91, 77, 456, 18})
        .reduce(0, (a,b) -> calc(a) < calc(b) ? a : b);
    }

    public int calc (int number) {
        int sum = 0;
            while (number > 0) {
                sum += number = number%10;}
            return sum;
    }
}

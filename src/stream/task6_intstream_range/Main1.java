package stream.task6_intstream_range;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main1 {
    public int practice1 () {
        return IntStream.range(1, 100).sum();
    }
    public long practice2 () {
        return IntStream.rangeClosed(10, 20)
                .filter(a -> a % 2 == 0)
                .count();
    }

    public int practice3 () {
        return IntStream.rangeClosed(21,40)
                .filter(a->a%2 !=0)
                .min()
                .orElse(-1);
    }

    public int practice4 () {
        return IntStream.range(1,6)
                .reduce((a,b) -> a*b )
                .orElse(-1);
    }

    public void practice5 () {
        IntStream.rangeClosed (1,30).filter(a->a%4==0).forEach(System.out::println);
    }

    public int practice6 () {
        return IntStream.range(1,31).filter(a->a%2 != 0)
                .sum();
    }

    public String practice7 () {
        int[] numbers = {10, 20, 30};
        return  Arrays.stream(numbers).mapToObj(a->String.valueOf(a)).reduce((a,b) -> a + "|" + b).orElse("-1");

    }
}

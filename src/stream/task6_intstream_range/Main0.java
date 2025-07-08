package stream.task6_intstream_range;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main0 {
    public int practice1() {
        return IntStream.range(1, 100).sum();
    }

    public long practice2() {
        return IntStream.rangeClosed(10, 20).filter(a -> a % 2 == 0).count();
    }

    public int practice3() {
        return IntStream.rangeClosed(21, 40).filter(a -> a % 2 == 1).min().orElse(-1);
    }

    public int practice4() {
        return IntStream.range(1, 6).reduce((a, b) -> a * b).orElse(-1);
    }

    public void practice5() {
        IntStream.rangeClosed(1, 30).filter(a -> a % 4 == 0).forEach(System.out::println);
    }

    public void practice6() {
        IntStream.rangeClosed(1, 31).filter(a -> a % 2 == 1)
                .mapToObj(a -> BigInteger.valueOf(a))
                .reduce(BigInteger.ONE, (a, b) -> a.multiply(b));
    }

    public String practice7() {
        int[] numbers = {10, 20, 30};
        return Arrays.stream(numbers).mapToObj(a -> String.valueOf(a)).reduce("", (a, b) -> a + "|" + b);
    }

    public int practice8() {
        return IntStream.rangeClosed(2, 9).filter(a -> a % 2 == 1).reduce((a, b) -> a * b).orElse(-1);
    }

    public int practice9() {
        return IntStream.rangeClosed(1, 5).map(a -> a * a).sum();
    }

    public List<Integer> practice10() {
        return IntStream.rangeClosed(10, 50).filter(a -> a % 7 == 0).boxed().toList();
    }

    public long practice11() {
        return IntStream.rangeClosed(1, 100).filter(a -> a % 3 == 0 || a % 5 == 0).count();
    }
}

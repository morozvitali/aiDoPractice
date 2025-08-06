package stream.task6_intstream_range_10;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main9 {
    public void practice1 () {
        IntStream.range(1, 100).sum();
    }

    public void practice2 () {
        IntStream.rangeClosed(10,20).filter(i->i%2==0).count();
    }

    public void practice3 () {
        IntStream.range(1,5).reduce((a,b) -> a*b).orElse(-1);
    }

    public void practice4 () {
        IntStream.rangeClosed(1,30).filter(a->a%4==0).forEach(System.out::println);
    }

    public void practice5 () {
        IntStream.rangeClosed(1,31).filter(a->a%2==1)
                .mapToObj(a-> BigInteger.valueOf(a))
                .reduce(BigInteger.ONE, (a,b) -> a.multiply(b));
    }

    public void practice6 () {
        int[] numbers = {10, 20, 30};
        Arrays.stream(numbers).mapToObj(a->String.valueOf(a)).reduce((a,b)->a + "|" + b).orElse("");
    }

    public void practice7 () {
        IntStream.rangeClosed(2,8).filter(a->a%2==1).reduce((a,b)-> a*b).orElse(-1);
    }

    public void practice8 () {
        IntStream.rangeClosed(1,5).map(a->a*a).sum();
    }
}

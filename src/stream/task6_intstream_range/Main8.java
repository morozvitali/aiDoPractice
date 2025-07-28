package stream.task6_intstream_range;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main8 {

    public int practice(int n) {
        return IntStream.range(1, n).sum();
    }

    public long practice2 (int n, int m) {
        return IntStream.rangeClosed(n,m).filter(i->i%2==0).count();
    }

    public int practice3 (int n, int m) {
        return IntStream.rangeClosed(n,m).filter(a->a%2==0).min().orElse(-1);
    }

    public void practice4 () {
        IntStream
                .rangeClosed(1,5)
                .reduce((a,b)-> a*b)
                .orElse(-1);
    }

    public void practice5 () {
        IntStream.range(1,31).filter(a->a%4==0).forEach(System.out::println);
    }

    public void practice6 () {
        IntStream.range(1,30).mapToObj(a-> BigInteger.valueOf(a)).reduce(BigInteger.ONE, (a,b) -> a.multiply(b));
    }

    public void practice7 () {
        int[] numbers = {10, 20, 30};
        Arrays.stream(numbers).mapToObj(a->String.valueOf(a)).collect(Collectors.joining("|"));
    }

    public void practice8 () {
        IntStream.rangeClosed(2,8)
                .filter(a->a%2==1)
                .reduce((a,b)-> a*b).orElse(-1);
    }

    public void practice9 () {
        IntStream.rangeClosed(1,5).map(i->i*i).sum();
    }

    public void practice10 () {
        IntStream.rangeClosed(10,51).filter(i->i%7==0).boxed().toList();
    }

    public void practice11 () {
        IntStream.rangeClosed(1,100).filter(a-> a%3==0&& a%5 ==0).count();
    }
}
package stream.task6_intstream_range;

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

}


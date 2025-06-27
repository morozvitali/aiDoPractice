package stream.task13__Instream_range_limit;

import java.util.List;
import java.util.stream.IntStream;

public class Main1 {
    public int practice1 () {
        return IntStream.rangeClosed(2,8).filter(a->a%2!=0).reduce((a,b) -> a*b).orElse(-1);
    }

    public int practice2 () {
        return IntStream.rangeClosed(1,5).map(a->a*a).sum();
    }

    public List<Integer> practice3 () {
        return IntStream.rangeClosed(10,50).filter(a->a%7==0).boxed().toList();
    }

    public long practice4 () {
        return IntStream.rangeClosed(1,100).filter(a->(a%3 ==0 || a%5==0)).count();
    }

    public void practice5 () {
        IntStream.iterate(10, i -> i-1).limit(10).forEach(System.out::println);
    }
}

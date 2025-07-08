package stream.task6_intstream_range;

import java.util.stream.IntStream;

public class Main0 {
    public int practice1 () {
        return IntStream.range(1,100).sum();
    }

    public long practice2 () {
        return IntStream.rangeClosed(10,20).filter(a->a%2==0).count();
    }



}

package stream.task6_intstream_range;

import java.util.stream.IntStream;

public class Main7 {

    public int practice1 () {
        return IntStream.range(1,101).sum();
    }

    public long practice2 () {
        return IntStream.rangeClosed(10,20).filter(i->i%2==0).count();
    }

    public
}

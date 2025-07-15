package stream.task6_intstream_range;

import java.beans.Introspector;
import java.util.stream.IntStream;

public class Main7 {

    public int practice1 () {
        return IntStream.range(1,101).sum();
    }

    public long practice2 () {
        return IntStream.rangeClosed(10,20).filter(i->i%2==0).count();
    }

    public int practice3 () {
        return IntStream.rangeClosed(21,40)
                .filter(a->a%2==0)
                .findFirst()
                .orElse(-1);
    }

    public int practice4 () {
        return IntStream.rangeClosed(1,5)
                .reduce((a,b)->a*b)
                .orElse(-1);
    }
}

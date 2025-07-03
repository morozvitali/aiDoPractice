package stream.task6_intstream_range;

import java.util.stream.IntStream;

public class Main6 {
    public int practice1 () {
        return IntStream
                .rangeClosed(1,99)
                .sum();
    }

public long practice2 () {
        return IntStream.rangeClosed(10,20)
                .filter(a->a%2==0)
                .count();
}

}

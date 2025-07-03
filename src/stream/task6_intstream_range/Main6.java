package stream.task6_intstream_range;

import java.util.stream.IntStream;

public class Main6 {
    public int practice1 () {
        return IntStream
                .rangeClosed(1,99)
                .sum();
    }



}

package stream.task6_intstream_range;

import java.util.stream.IntStream;

public class Main8 {

    public int practice(int n) {
        return IntStream.range(1, n).sum();
    }

    public long practice2 (int n, int m) {
        return IntStream.rangeClosed(n,m).filter(i->i%2==0).count();
    }


}

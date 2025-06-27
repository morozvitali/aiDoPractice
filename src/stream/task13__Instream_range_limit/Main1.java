package stream.task13__Instream_range_limit;

import java.util.stream.IntStream;

public class Main1 {
    public int practice1 () {
        return IntStream.rangeClosed(2,8).filter(a->a%2!=0).reduce((a,b) -> a*b).orElse(-1);
    }


}

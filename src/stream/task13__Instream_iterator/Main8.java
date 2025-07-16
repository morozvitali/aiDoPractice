package stream.task13__Instream_iterator;

import java.util.stream.IntStream;

public class Main8 {
    public void practice1 () {
        IntStream.iterate(10, i ->i -1).limit(10);
    }

}

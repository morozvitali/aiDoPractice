package stream.task13__valueOf_15;

import java.util.List;
import java.util.stream.Stream;

public class Main10 {
    public List<String> practice1 () {
        return Stream.of(97, 98, 99, 100, 101).map(a->(char)(int)a).map(String::valueOf).toList();
    }

}

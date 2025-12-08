package stream2.task7_;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main3 {

    public void practice1 () {
        List<String> names = Stream.of("Bob", "Alice", "Tom")
                .collect(Collectors.toUnmodifiableList());
    }



}

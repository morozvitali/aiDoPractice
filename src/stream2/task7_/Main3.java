package stream2.task7_;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main3 {

    public void practice1 () {
        List<String> names = Stream.of("Bob", "Alice", "Tom")
                .collect(Collectors
                        .toUnmodifiableList());
        System.out.println(names);
    }

    public void practice2 () {
        Set <Integer> set = Stream.of(1,2,3,2)
                .collect(Collectors.toUnmodifiableSet());
        System.out.println(set);
    }

    public void practice3 () {

    }

}

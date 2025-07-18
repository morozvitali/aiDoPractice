package stream.task17_collectors;

import java.util.List;
import java.util.stream.Collectors;

public class Main1 {
    public void practice1 () {
        List<String> names = List.of("Alice", "Bob", "Charlie");
    names.stream().collect(Collectors.joining(", "));



    }
}

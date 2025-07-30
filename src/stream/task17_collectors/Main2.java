package stream.task17_collectors;

import java.util.List;
import java.util.stream.Collectors;

public class Main2 {

    public String practice1() {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        return names.stream().collect(Collectors.joining(", "));
    }



}

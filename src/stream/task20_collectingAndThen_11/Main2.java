package stream.task20_collectingAndThen_11;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {
    public List<String> practice() {
        return Stream.of("apple", "car",
                "banana", "hi", "cherry").filter(value -> value.length() >4)
                .collect(Collectors.collectingAndThen(Collectors.toList(), a-> Collections.unmodifiableList(a)));

    }
}

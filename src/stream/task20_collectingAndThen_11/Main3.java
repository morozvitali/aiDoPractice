package stream.task20_collectingAndThen_11;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main3 {
    public List<String> practice1 () {
        return Stream.of("apple", "car", "banana", "hi", "cherry").filter(value -> value.length() > 4).collect(Collectors.collectingAndThen(Collectors.toList(), list -> Collections.unmodifiableList(list)));
    }



}

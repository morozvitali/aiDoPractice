package stream.task20_collectingAndThen_11;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main13 {
    public List<String> practice1() {
        return Stream.of("apple", "car", "banana", "hi", "cherry")
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

public int practice2 () {
        return Stream.of(3, 9, 2, 4, 6, 7, 12)
                .collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
}

public String practice3() {
    List<String> data = List.of("apple", "car", "banana", "hi", "cherry");
        return data.stream().sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.collectingAndThen(Collectors.toList(), list->list.get(0)));
    }


}

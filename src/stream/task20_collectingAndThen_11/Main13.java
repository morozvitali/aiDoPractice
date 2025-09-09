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
public int practice4 () {
        return Stream.of(5, 3, 4, 4, 3, 6)
                .distinct().collect(Collectors.collectingAndThen(Collectors.toList(), list->list.getFirst()));
}

public List<Integer> practice5 () {
        return Stream.of(2, 4, 10, 12, 14, 12, 4)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
}

public Double practice6 () {
        return Stream.of("code", "stream", "java")
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().mapToInt(String::length).average().orElse(-1)));
}


}

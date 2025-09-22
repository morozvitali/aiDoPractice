package stream.task20_collectingAndThen_11;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main17 {
    public List<String> practice1 () {
        return Stream.of("apple", "car", "banana",
                "hi", "cherry").collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public Integer practice2 () {
        return Stream.of(3, 9, 2, 4, 6, 7, 12).filter(n->n%3==0).collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
    }

    public String practice3 () {
        return Stream.of("sun", "supernova", "star").collect(Collectors.collectingAndThen(Collectors.toList(), list->list.stream().sorted(Comparator.comparing(String::length).reversed()).toList().getFirst()));
    }


}

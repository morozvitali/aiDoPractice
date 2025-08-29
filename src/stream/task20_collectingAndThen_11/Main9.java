package stream.task20_collectingAndThen_11;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main9 {
    public List<String> practice1() {
        return Stream.of("apple", "car", "banana", "hi", "cherry")
                .filter(w->w.length() > 4)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public Integer practice2 () {
        return Stream.of(3, 9, 2, 4, 6, 7, 12)
                .filter(v->v%3==0)
                .collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
    }

    public String practice3 () {
        return Stream.of("sun", "supernova", "star")
                .sorted(Comparator.comparing(String::length).reversed())
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        List::getFirst));
    }
}

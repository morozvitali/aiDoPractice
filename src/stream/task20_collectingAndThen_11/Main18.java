package stream.task20_collectingAndThen_11;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main18 {
    public List<String> practice1 () {
        return Stream.of("apple", "car", "banana",
                "hi", "cherry").filter(w->w.length()>4).collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public Integer practice2 () {
        return Stream.of(3, 9, 2, 4, 6, 7, 12).filter(a->a%3==0).collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
    }

    public String practice3 () {
        return Stream.of("sun", "supernova", "star").collect(Collectors.collectingAndThen(Collectors.toList(), list->list.stream().sorted(Comparator.comparing(String::length).reversed()).toList().getFirst()));
    }

    public Integer practice4 () {
        return Stream.of(5, 3, 4, 4, 3, 6).distinct().collect(Collectors.collectingAndThen(Collectors.toList(), List::getFirst));
    }

    public Set<Integer> practice5 () {
        return Stream.of(2, 4, 10, 12, 14, 12, 4).filter(a->a>10).collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
    }

    public Double practice6 () {
        return Stream.of("code", "stream", "java").collect(Collectors.collectingAndThen(Collectors.toList(), list->list.stream().mapToInt(String::length).summaryStatistics().getAverage()));
    }

}

package stream.task20_collectingAndThen_11;

import java.util.*;
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

    public Integer practice4 () {
        return Stream.of(5, 3, 4, 4, 3, 6).distinct()
                .collect(Collectors.collectingAndThen(Collectors.toList(), List::getFirst));
    }

    public Set<Integer> practice5 () {
        return Stream.of(2, 4, 10, 12, 14, 12, 4)
                .collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
    }

    public Double practice6 () {
        return Stream.of("code", "stream", "java").collect(Collectors.collectingAndThen(Collectors.toList(), list->list.stream().mapToInt(String::length).average().orElse(-1)));
    }

    public Map<Character, List <String>> practice7 () {
        return Stream.of("apple", "ant", "banana",
                "bat", "car").collect(Collectors.collectingAndThen(Collectors.groupingBy(w->w.charAt(0)), Collections::unmodifiableMap));
    }


}

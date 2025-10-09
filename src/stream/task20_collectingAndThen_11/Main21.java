package stream.task20_collectingAndThen_11;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main21 {
    public String practice1 () {
        List<String> list = Stream.of("java", "code", "loop", "sky")
                .filter(w -> w.chars().filter(c -> "aeiou".indexOf(c) >= 0).count() == 2).toList();
        if (list.size() > 1) {
            throw new IllegalStateException(" ");
        }
        return list.get(0);
    }

    public String practice2 () {
        return List.of(1, 2, 3, 4, 5).stream().filter(n->n%2==0).map(n->n*n+"").collect(Collectors.collectingAndThen(Collectors.toList(), list-> String.join(" : ", list)));
    }

    public Integer practice3 () {
        return Stream.of("hi", "hello", "mango", "go", "halo", "yo").collect(Collectors.collectingAndThen(Collectors.groupingBy( w->w.charAt(w.length()-1)), Map::size));
    }

    public List <String> practice4 () {
        return Stream.of("apple", "car", "banana",
                "hi", "cherry").filter(w->w.length() >4).collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public Integer practice5 () {
        return Stream.of(3, 9, 2, 4, 6, 7, 12).collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
    }

    public String practice6 () {
        List<String> data = List.of("apple", "car", "banana", "hi", "cherry");
        return data.stream().collect(Collectors.collectingAndThen(Collectors.toList(), list->list.stream().sorted(Comparator.comparing(String::length).thenComparing(Comparator.reverseOrder())))).toList().getFirst();
    }

    public Integer practice7 () {
        return Stream.of(5, 3, 4, 4, 3, 6).distinct().collect(Collectors.collectingAndThen(Collectors.toList(), List::getFirst));
    }

    public Set<Integer> practice8 () {
        return Stream.of(2, 4, 10, 12, 14, 12, 4).collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
    }



}

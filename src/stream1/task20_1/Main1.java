package stream1.task20_1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main1 {
    public List<String> practice1 () {
        return  Stream.of("cooperation", "stream1", "banana", "supernova", "moon", "queueing", "idealism")
                .filter(w->w.chars().filter(c->"aeiou".indexOf(c)>=0).count() > 3)
                .map(w->w.toLowerCase())
                .sorted(Comparator.comparingLong((String w)->w.chars().filter(c->"aeiou".indexOf(c)>=0).count()).reversed())
                .limit(3).collect(Collectors.toUnmodifiableList());
    }

    public Map<Integer, Double> practice2 () {
        return Stream.of("hi", "code", "moon", "room", "idea", "sky")
                .collect(Collectors
                        .collectingAndThen(Collectors
                                .groupingBy(String::length, Collectors.averagingLong(w->w.chars().filter(c->"aeiou".indexOf(c)>=0).count())),
                                        Collections::unmodifiableMap));
    }


}



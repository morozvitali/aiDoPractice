package stream3.task5_;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main1 {

    public List<String> practice1 () {
        return Stream.of("cooperation", "stream", "banana",
                "supernova", "moon", "queueing", "idealism")
                .sorted(Comparator.comparing(Main1::count).thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

    public static Long count (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }








}

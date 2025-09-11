package stream.task16_comparator_8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main5 {
    public List <String> practice1 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
        return words.stream().sorted(Comparator.comparing(w->w.chars().filter(c->"aeiou".indexOf(c)>=0).count())).toList();
    }

    public String practice2 () {
        return Stream.of("alpha", "arena", "java", "banana", "lava").collect(Collectors.toMap(Function.identity(), Main5::counter)).entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey).orElse("");
    }

    public static long counter (String s) {
        return s.chars().filter (c->c=='a').count();
    }

    public Integer practice3 () {
        return Stream.of(111, 123, 444, 1212)
                .collect(Collectors.toMap(Function.identity(), Main4::getIntCount))
                .entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey).orElse(-1);
    }

    public static long intCounter (String s) {
        return String.valueOf(s).chars().distinct().count();
    }
}

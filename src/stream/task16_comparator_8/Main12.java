package stream.task16_comparator_8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main12 {
public List<String> practice1 () {
    List<String> words = List.of("sky", "banana",
            "apple", "grape", "orange", "plum");
    return words.stream().sorted().toList();
}

public String practice2 () {
    //return Stream.of("alpha", "arena", "java", "banana", "lava").max(Comparator.comparing(w->w.chars().filter(c->c=='a').count())).orElse("");
    return Stream.of("alpha", "arena", "java", "banana", "lava").collect(Collectors.toMap(Function.identity(), w->w.chars().filter(c->c=='a').count()))
            .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey).orElse("-1");
}

public int practice3 () {
    return Stream.of(111, 123, 444, 1212).collect(Collectors.toMap(w->w, w->String.valueOf(w).chars().distinct().count()))
            .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(-1);
}

}


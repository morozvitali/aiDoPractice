package stream.task16_comparator_8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main7 {

    public List <String> practice1 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
    return words.stream().sorted(Comparator.comparing(Main7::getCount)).toList();
    }

    public static long getCount(String s) {
        return s.chars().filter(c-> "aeiuo".indexOf(c)>=0).count();
    }

    public String practice2 () {
        return Stream.of("alpha", "arena", "java", "banana", "lava")
                .collect(Collectors.toMap(Function.identity(), Main7::getLetter)).entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey).orElse("");
    }

    public static long getLetter (String s) {
        return s.chars().filter(c->c=='a').count();
    }

    public Integer practice3 () {
        return Stream.of(111, 123, 444, 1212).collect(Collectors.toMap(Function.identity(), v->String.valueOf(v).chars().distinct().count())).entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey).orElse(-1);
    }

    public String practice4 () {
        return Stream.of("abc", "aaa", "zzz").collect(Collectors.toMap(Function.identity(), v->v.chars().sum())).entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry::getValue)).map(Map.Entry::getKey).orElse("");
    }



}

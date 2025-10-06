package stream.task16_comparator_8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main13 {

    public List <String> practice1 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
        return words.stream().sorted(Comparator.comparing(Main13::getCount)).sorted(Comparator.naturalOrder())
                .toList();
    }

    public static long getCount (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }


    public String practice2 () {
        Map<String, Long> map = List.of("alpha", "arena", "java", "banana", "lava")
                .stream()
                .collect(Collectors.toMap(Function.identity(), Main13::countLetter));
                return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();

    }

    public static long countLetter (String s) {
        return s.chars().filter(c->c=='a').count();
    }

}

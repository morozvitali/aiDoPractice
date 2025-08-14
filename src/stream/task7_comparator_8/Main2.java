package stream.task7_comparator_8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {
    public List<String> practice1 () {
        return Stream.of("sky", "banana",
                "apple", "grape", "orange", "plum").sorted(Comparator.comparing(w->countVowels(w))).collect(Collectors.toList());
    }
    public long countVowels (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c) >= 0).count();
    }

    public String practice2 () {
        return Stream.of("alpha", "arena",
       "java", "banana", "lava").map(w-> Map.entry(w, countletter(w, 'a'))).max(Comparator.comparing(Map.Entry::getValue))
                        .map(Map.Entry::getKey)
                                .orElse("empty");
    }

    public long countletter (String s, char c) {
        return s.chars().filter(ch->ch==c).count();
    }

    public int practice3 () {
        return Stream.of(111, 123, 444, 1212).map(n->Map.entry(n, String.valueOf(n).chars().distinct().count())).max(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey).orElse(-1);
    }

    public String practice4 () {
        return Stream.of("abc", "aaa", "zzz").map(w->Map.entry(w, w.chars().sum()))
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("empty");
    }


}

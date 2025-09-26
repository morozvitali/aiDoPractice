package stream.task60x24.x1.task16_comparator_8;

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

    public String practice5 () {
        return Stream.of("sun", "star",
                "supernova", "apple").filter(w->w.charAt(0)=='s')
                .max(Comparator.comparing(String::length))
                .orElse("empty");
    }

    public List <String> practice6 () {
        return Stream.of("abc", "def", "gka", "lol")
                .sorted(Comparator.comparing(w->w.charAt(w.length()-1)))
                .collect(Collectors.toList());
    }

    public String practice7 () {
        return Stream.of("java", "hello", "me", "zebra")
                .filter(w->w.contains("e"))
                .min(Comparator.comparing(String::length))
                .orElse("empty list");
    }

    public List <Integer> practice8 () {
        return Stream.of(100, 1010, 5, 2000, 10)
                .sorted(Comparator.comparing(n->String.valueOf(n)
                        .chars().filter(c->c=='0').count()))
                        .collect(Collectors.toList());
    }
}

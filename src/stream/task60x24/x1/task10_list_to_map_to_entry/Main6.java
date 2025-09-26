package stream.task60x24.x1.task10_list_to_map_to_entry;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main6 {

    public String practice1() {
        return Stream.of("stream", "code",
                "developer", "Engineer")
                .collect(Collectors.toMap(Function.identity(), String::length))
                .entrySet().stream().max(Comparator.comparing(e->e.getValue())).map(Map.Entry::getKey).orElse("-1");
    }

    public String practice2 () {
        return Stream.of("Java", "C",
                "Python", "Go", "Kotlin")
                .collect(Collectors.toMap(Function.identity(), String::length))
                .entrySet().stream().min(Comparator.comparing(e->e.getValue())).map(Map.Entry::getKey).orElse("-1");
    }

    public String practice3 () {
        return Stream.of("apple", "banana",
                "orange", "blueberry").collect(Collectors.toMap(Function.identity(), Main6::getCount))
                .entrySet().stream().max(Comparator.comparing(e->e.getValue())).map(Map.Entry::getKey).orElse("");
    }

    public static long getCount (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }

    public String practice4 () {
        return Stream.of("apple", "pear",
                "banana", "kiwi")
                .collect(Collectors.toMap(Function.identity(), Main6::getCountLetters))
                .entrySet().stream().max(Comparator.comparing(e->e.getValue())).map(Map.Entry::getKey).orElse("");
    }
    public static long getCountLetters(String s) {
        return s.length() - s.chars().distinct().count();
    }

    public String practice5() {
        return Stream.of("apple",
                "committee", "banana", "success")
                .collect(Collectors.toMap(Function.identity(), Main6::getCountLetters))
                .entrySet().stream().max(Comparator.comparing(e->e.getValue())).map(Map.Entry::getKey).orElse("");
    }

    public static long getUnicCount (String s) {
        return s.chars().distinct().count();
    }

    public String practice6 () {
        return Stream.of("abc", "aaa", "zzz")
                .collect(Collectors.toMap(Function.identity(), w->w.chars().sum()))
                .entrySet().stream().max(Comparator.comparing(e->e.getValue())).map(Map.Entry::getKey).orElse("");
    }

    public String practice7 () {
        return List.of("alpha", "arena",
                "java", "banana", "lava").stream().collect(Collectors.toMap(Function.identity(), Main6::letterCounter))
                .entrySet().stream().max(Comparator.comparing(e->e.getValue())).map(Map.Entry::getKey).orElse("");
    }

    public static int letterCounter (String s) {
        return (int)s.chars().filter(c->c=='a').count();
    }

    public String practice8 () {
        return List.of("apple", "Tree",
                "Java", "stream", "Engineer").stream().filter(w->Character.isUpperCase(w.charAt(0))).collect(Collectors.toMap(Function.identity(), String::length))
                .entrySet().stream().max(Comparator.comparing(e->e.getValue())).map(Map.Entry::getKey).orElse("");
    }

}

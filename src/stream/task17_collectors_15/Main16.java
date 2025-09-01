package stream.task17_collectors_15;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main16 {
    public Map<Character, List <String>> practice1 () {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(word->word.charAt(0), Collectors.mapping(word->word.toUpperCase(), Collectors.toList())));
    }

    public Map <Character, List <Integer>> practice2 () {
        List<String> words = List.of("apple", "ant",
                "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.mapping(String::length, Collectors.toList())));
    }

    public Map <Boolean, Long> practice3 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        return numbers.stream().collect(Collectors.groupingBy(a->a%2==0, Collectors.counting()));
    }

    public Map <Integer, Set<String>> practice4 () {
        List<String> words = List.of("hi", "hi",
                "book", "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.groupingBy(String::length, Collectors.toSet()));
    }

    public String practice5 (String s) {
        return s.chars().filter(Character::isDigit).mapToObj(a->(int)a).collect(Collectors.collectingAndThen(Collectors.counting(), count->"Count = " + count));
    }

    public Map <Character, String> practice6 () {
        List<String> words = List.of("apple",
                "ant", "banana", "bat", "car");
        return words.stream().collect(Collectors.groupingBy(w->w.charAt(0), Collectors.joining(" ")));
    }

    public Map<Integer, Integer> practice7 () {
        List<Integer> numbers = List.of(1, 2, 3, 4,
                5, 6, 7, 8, 9);
        return numbers.stream().collect(Collectors.groupingBy(a->a%3, Collectors.summingInt(n->n)));
    }

    public String practice8 () {
        List<String> words = List.of("hi", "book",
                "sun", "day", "Java", "sky");
        return words.stream().collect(Collectors.reducing("",(a,b)-> a.length() > b.length() ? a : b));
    }


}

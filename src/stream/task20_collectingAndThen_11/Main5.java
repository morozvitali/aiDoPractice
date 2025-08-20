package stream.task20_collectingAndThen_11;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main5 {
    public List<String> practice1() {
        return Stream.of("apple", "car", "banana", "hi", "cherry")
                .filter(w -> w.length() > 4)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public Integer practice2() {
        return Stream.of(3, 9, 2, 4, 6, 7, 12)
                .filter(a -> a % 3 == 0)
                .collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
    }

    public String practice3() {
        return Stream.of("sun", "supernova", "star")
                .sorted(Comparator.comparing(String::length).reversed()).collect(Collectors.collectingAndThen(Collectors.toList(), List::getFirst));
    }

    public Integer practice4() {
        return Stream.of(5, 3, 4, 4, 3, 6).distinct().collect(Collectors.collectingAndThen(Collectors.toList(), List::getFirst));
    }

    public List <Integer> practice5 () {
        return Stream.of(2, 4, 10, 12, 14, 12, 4)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public Double practice6 () {
        return Stream.of("apple", "car",
                "banana", "hi", "cherry")
                .map(String::length)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        (List <Integer> list) -> list.stream().mapToInt(Integer::intValue).average().orElse(0.0)));
    }

    public Map<Character, List <String>> practice7 () {
        return Stream.of("apple", "ant", "banana", "bat", "car")
                .collect(Collectors.collectingAndThen(Collectors.groupingBy(word->word.charAt(0)), Collections::unmodifiableMap));
    }

    public String practice8 () {
        return Stream.of("java", "zip", "jazz")
                .filter(w->w.contains("z"))
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        list -> {if (list.size() !=1) {
                    throw new IllegalStateException("except one z");}
        return list.get(0);
        }));
    }

    public String practice9 () {
        return Stream.of(1, 2, 3, 4, 5)
                .filter(a->a%2 ==0)
                .map(String::valueOf)
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> String.join(", ", list)));
    }
}

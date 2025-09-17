package stream.task20_collectingAndThen_11;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main15 {
    public List<String> practice1() {
        return Stream.of("apple", "car", "banana", "hi", "cherry")
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public Integer practice2() {
        return Stream.of(3, 9, 2, 4, 6, 7, 12).collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
    }


    public String practice3() {
        return Stream.of("apple", "car", "banana", "hi", "cherry")
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.get(0)));
    }

    public Integer practice4() {
        return Stream.of(5, 3, 4, 4, 3, 6).distinct().collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.get(0)));
    }

    public Set<Integer> practice5() {
        return Stream.of(2, 4, 10, 12, 14, 12, 4).collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
    }

    public Double practice6() {
        return Stream.of("code", "stream", "java").collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().mapToInt(String::length).average().orElse(-1)));
    }

    public Map<Character, List<String>> practice7() {
        return Stream.of("apple", "ant", "banana",
                "bat", "car").collect(Collectors.collectingAndThen(Collectors.groupingBy(w -> w.charAt(0)), Collections::unmodifiableMap
        ));
    }

    public String practice8 () {
        return Stream.of("java", "zip", "jazz").filter(w->w.contains("z"))
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        list-> {
                    if (list.size() != 1) {
                    throw new IllegalStateException("Except one z");
                            }
                            return list.get(0);
                        }
                        ));
    }


}

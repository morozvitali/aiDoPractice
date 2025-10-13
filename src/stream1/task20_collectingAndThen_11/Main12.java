package stream1.task20_collectingAndThen_11;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main12 {
    public List<String> practice1() {
        return Stream.of("apple", "car", "banana", "hi", "cherry")
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public Integer practice2() {
        return Stream.of(3, 9, 2, 4, 6, 7, 12)
                .filter(a -> a % 3 == 0)
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.size()));
    }

    public String practice3() {
        return Stream.of("sun", "supernova", "star")
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().sorted(Comparator.comparing(String::length).thenComparing(Comparator.reverseOrder())).toList().getFirst()));
    }

    public Integer practice4() {
        return Stream.of(5, 3, 4, 4, 3, 6)
                .distinct().collect(Collectors.collectingAndThen(Collectors.toList(), List::getFirst));
    }

    public Set<Integer> practice5() {
        return Stream.of(2, 4, 10, 12, 14, 12, 4)
                .collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
    }

    public Double practice6() {
        return Stream.of("code", "stream1", "java")
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().mapToInt(String::length)
                        .average().orElse(-1)));
    }

    public Map<Character, List<String>> practice7() {
        return Stream.of("apple", "ant", "banana",
                "bat", "car").collect(Collectors.collectingAndThen(Collectors.groupingBy(w -> w.charAt(0)), Collections::unmodifiableMap));
    }

    public void practice8() {
        Stream.of("java", "zip", "jazz")
                .filter(w -> w.contains("z"))
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> {
                            if (list.size() != 1) {
                                throw new IllegalStateException("очікували 1 літеру z");
                            }
                            return list.get(0);
                        }
                ));
    }

    public String practice9 () {
        return Stream.of(1, 2, 3, 4, 5)
                .filter(a->a%2==1)
                .map(String::valueOf)
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(),
                        list-> String.join(", ", list)
                ));
    }

    public Integer practice10 () {
        List<String> data = List.of("hi", "hello",
                "world", "no", "yes");
        return data.stream().collect(Collectors.collectingAndThen(Collectors.groupingBy(String::length), Map::size));
    }


}

package stream.task20_collectingAndThen;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main0 {
    public void practice0() {
        List<Integer> numbers = List.of(10, 70, 20, 90, 55, 30);
        numbers.stream().filter(a -> a > 50).sorted(Comparator.reverseOrder()).collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public void practice1() {
        List<String> data = List.of("apple", "car",
                "banana", "hi", "cherry");
        data.stream().filter(a -> a.length() > 4).collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public void practice2() {
        List<Integer> numbers = List.of(10, 70, 20, 90, 55, 30);
        numbers.stream().collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
    }

    public void practice3() {
        List<String> data = List.of("apple", "car",
                "banana", "hi", "cherry");
        data.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors
                        .collectingAndThen(Collectors
                                        .toList(),
                                list -> list.get(0)));
    }

    public Integer practice4() {
        List<Integer> numbers = List.of(5, 3, 4, 4, 3, 6);
        return numbers.stream().distinct().collect(Collectors.toList()).get(0);
    }

    public void practice5() {
        List<Integer> numbers = List.of(2, 4, 10, 12, 14, 12, 4);
        numbers.stream().filter(value -> value > 10).collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
    }

    public void practice6() {
        List<String> data = List.of("apple", "car",
                "banana", "hi", "cherry");
        data.stream().map(a -> a.length())
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        list -> list.stream()
                                .mapToInt(Integer::intValue)
                                .average()
                                .orElse(0.0)));
    }

    public void practice7() {
        List<String> data = List.of("apple", "ant",
                "banana", "bat", "car");
        Map<Character, List<String>> map = data.stream().collect(Collectors.collectingAndThen(Collectors.groupingBy(value -> value.charAt(0)), Collections::unmodifiableMap));
    }

    public void practice8() {
        List<String> data = List.of("java", "zip", "jazz");
        data.stream().filter(w -> w.contains("z"))
                .collect(Collectors.collectingAndThen(
                        Collectors.toList(), list -> {
                            if (list.size() != 1) {
                                throw new IllegalStateException("error, list.size() != 0");
                            }
                            return list.get(0);
                        }
                ));
    }

    public void practice9 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        String result = numbers.stream().filter(a->a%2 !=0)
                .map(String::valueOf)
                .collect(Collectors.collectingAndThen(Collectors
                                    .toList(), list -> String
                                    .join(", ", list)));
    }




}

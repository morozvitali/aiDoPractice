package stream1.task20_collectingAndThen_11;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main22 {
    public String task1() {
        return Stream.of("java", "code", "loop", "sky").filter(w -> w.chars().filter(c -> "aeiou".indexOf(c) >= 0).count() > 2).collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
            if (list.size() != 1) {
                throw new IllegalStateException("no no");
            }
            return list.get(0);
        }));
    }

    public String task2() {
        return List.of(1, 2, 3, 4, 5).stream().filter(a -> a % 2 == 0).map(a -> a * a + "").collect(Collectors.collectingAndThen(Collectors.toList(), list -> String.join("; ", list)));
    }

    public Integer task3() {
        return Stream.of("java", "code", "loop", "sky").collect(Collectors.collectingAndThen(Collectors.groupingBy(w -> w.charAt(w.length() - 1)), Map::size));
    }

    public List<String> task4() {
        return Stream.of("java", "code", "loop", "sky").collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public Integer task5() {
        return Stream.of(3, 9, 2, 4, 6, 7, 12).collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
    }

    public String task6() {
        List<String> data = List.of("apple", "car", "banana", "hi", "cherry");
        return data.stream().sorted(Comparator.reverseOrder()).collect(Collectors.collectingAndThen(Collectors.toList(), List::getFirst));
        }

        public Integer task7 () {
        return Stream.of(5, 3, 4, 4, 3, 6).distinct().collect(Collectors.collectingAndThen(Collectors.toList(), List::getFirst));
        }

    public Set<Integer> task8 () {
        return List.of(2, 4, 10, 12, 14, 12, 4).stream().collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));
    }


    public Map <Character, List <String>> task9 (List <String> list) {
        return list.stream().collect(Collectors.collectingAndThen(Collectors.groupingBy(w->w.charAt(0)), Collections::unmodifiableMap));
    }

    public String task10 (List <String> l) {
        return l.stream().filter(w->w.contains("p")).collect(Collectors.collectingAndThen(Collectors.toList(), list ->{
            if (list.size() != 1) {
                throw new IllegalStateException("no no");
            }
            return list.get(0);
        }));
    }

    public String task11 (List <Integer> l) {
        return l.stream().filter(a->a%2==0).map(String::valueOf).collect(Collectors.collectingAndThen(Collectors.toList(), list->String.join(", ", list)));
    }

    public Integer rask12 (List <String> l) {
        return l.stream().collect(Collectors.collectingAndThen(Collectors.groupingBy(String::length), Map::size));
    }

}
package stream.task20_collectingAndThen_11;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main4 {

    public List<Integer> myCollecting1() {
        List<Integer> numbers = List.of(10, 70, 20, 90, 55, 30);
        return numbers.stream().filter(a -> a > 50).sorted(Comparator.reverseOrder())
                .collect(Collectors
                        .collectingAndThen(Collectors.toList(), a -> Collections.unmodifiableList(a)));
    }

    public List<String> myCollecting2() {
        List<String> numbers = List.of("Polly", "it's", "a", "bird", "Polly", "it's", "a", "bird");
        return numbers.stream()
                .filter(a->a.length()>4)
                .collect(Collectors.collectingAndThen(Collectors.toList(), a->Collections.unmodifiableList(a)));
    }

    public String practice3 () {
        return List.of("apple", "car", "banana", "hi", "cherry").stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> list.get(0)));
        }

    public Integer practice4 () {
        return Arrays.stream(new int [] {5, 3, 4, 4, 3, 6}).distinct().boxed()
                .collect(Collectors.collectingAndThen(Collectors.toList(), list->list.get(0)));
    }

    public Set <Integer> practice5 () {
        return Arrays.stream(new int [] {2, 4, 10, 12, 14, 12, 4}).filter(a->a>10).boxed()
                .collect(Collectors.collectingAndThen(Collectors.toSet(), (set)->Collections.unmodifiableSet(set)));
    }

    public Double practice6 () {
        return  Stream.of("code", "stream", "java")
                .map(String::length).collect(Collectors.collectingAndThen(Collectors.toList(),
                        (List <Integer> list)->list.stream().mapToInt(Integer::intValue).average().orElse(0.0)));
    }

    public Map <Character, List <String>> practice7 () {
        return Stream.of("apple", "ant", "banana", "bat", "car")
                .collect(Collectors.collectingAndThen(Collectors.groupingBy(w->w.charAt(0)), (Map <Character, List<String>>map) -> Collections.unmodifiableMap(map)));
    }

    public String practice8 () {
        return Stream.of("java", "zip", "jazz").filter(w->w.contains("z"))
                .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                    if (list.size() != 1) {
                        throw new IllegalStateException("except one letter z");
                    }
                    return list.get(0);
                }
                ));
    }

    public String practice9 () {
        return Stream.of(1, 2, 3, 4, 5).filter(n->n%2==1).map(String::valueOf)
                .collect(Collectors.collectingAndThen(Collectors.toList(), list->String.join(", ", list)));
    }

    public  Integer practice10 () {
        return Stream.of ("hi", "hello", "world", "no", "yes").collect(Collectors.collectingAndThen(Collectors.groupingBy(String::length), Map::size));
    }


}



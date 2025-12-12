package stream3.task5_;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main1 {

    public List<String> practice1() {
        return Stream.of("cooperation", "stream", "banana",
                        "supernova", "moon", "queueing", "idealism")
                .sorted(Comparator.comparing(Main1::count).thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

    public static Long count(String s) {
        return s.chars().filter(c -> "aeiou".indexOf(c) >= 0).count();
    }

    public List<Integer> practice2(List<Integer> numbers) {
        return numbers.stream().sorted(Comparator.comparing((Integer n) -> n % 2 == 0)
                        .thenComparing(Comparator.reverseOrder()))
                .toList();
    }

    public LinkedHashMap<Integer, List<String>> practice3(Map<Integer, List<String>> input) {
        return input
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(e -> e.getValue().size()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (a, b) -> b, LinkedHashMap::new));
    }

    public List <String> practice4 (List <String> words) {
        return words.stream().sorted(Comparator.comparing(String::length)
                .reversed()).toList();
    }

    public LinkedHashMap <Character, Integer> practice5 (Map <Character, Integer> map) {
        return  map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1,e2)->e1, LinkedHashMap::new
                        ));
    }

    public String practice6 () {
        return List.of("alpha","arena","java","banana","lava").stream()
                .max(Comparator.comparing(w->w.chars().filter(c->c=='a').count())).orElse("");
    }

    public List <String> practice7 (List <String> words) {
        return words.stream().sorted(Comparator.comparing(Main1::count).thenComparing(String::length)).toList();
    }

    public List <String> practice8 (Map <String, Long> map, int n) {
        return map.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(n)
                .map(Map.Entry::getKey)
                .toList();
    }




}

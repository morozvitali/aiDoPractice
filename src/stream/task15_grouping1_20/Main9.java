package stream.task15_grouping1_20;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main9 {
    public Map<String, Boolean> practice0 () {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        return Arrays.stream(words).collect(Collectors.toMap(Function.identity(), word->word.chars().anyMatch(ch->"aeiou".indexOf(ch)>=0)));
    }

    public Long practice1 (String s) {
        Map <Character, Long> map = s.toLowerCase().chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map.entrySet().stream().filter(e->e.getValue()>1).count();
    }

    public String practice2 (String s) {
        Map <String, Long> map = Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return Collections.max(map.entrySet(), Comparator.comparingLong(entry -> entry.getValue())).getKey();
    }

    public Map <Integer, Integer> practice3 () {
        return List.of(12, 23, 34, 45, 16, 7).stream().collect(Collectors.groupingBy(value -> value%10, Collectors.summingInt(n->n)));
    }
    public void practice4 () {
        String[] words = {"one", "two", "three", "six", "seven"};
        Arrays.stream(words).collect(Collectors.groupingBy(value -> value.length(), Collectors.counting()));
    }

    public void practice5 () {
        String[] words = {"apple", "banana", "avocado",
                "blueberry", "bleuberry", "apricot"};
        Map<Character, List<String>> map = Arrays.stream(words).collect(Collectors.groupingBy(w->w.charAt(0)));
    }

    public int practice6 () {
        Map <Integer, Long> map = List.of(1,2,2,3,3,3,4,4).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map.entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue)).get().getKey();
    }

    public Map <Character, Long> practice7 () {
        return "ab123cc44a77"
                .chars()
                .filter(c->Character.isDigit(c))
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
    }

    public boolean practice8 () {
        Map <Integer, Long> map = List.of(1, 2, 3, 2).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return map.entrySet().stream().anyMatch(entry -> entry.getValue() > 1);
    }

    public Map <String, List <Integer>> practice9 () {
         return List.of(1, 2, 3, 4, 5).stream().collect(Collectors.groupingBy(value -> value %2 == 0 ? "even" : "odd"));
    }

    public Map <Integer, Double> practice10 () {
        return List.of(3, 6, 7, 8, 9, 10, 12)
                .stream()
                .collect(Collectors
                        .groupingBy(value-> value %3,
                                Collectors
                                        .averagingDouble(n->n)));
    }

    public Map <Character, Long> practice12 (Map <Character, Long> map) {
        return map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }

    public Character practice11 () {
        String[] words = {"apple", "banana", "avocado",
                "blueberry", "bleuberry", "apricot"};
        Map<Character, Long> map = Arrays.stream(words)
                .collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.counting()));
        return map.entrySet().stream()
                .max(Comparator.comparingLong(n->n.getValue()))
                .map(Map.Entry::getKey)
                .orElse(null);
    }


    public Map <Character, Integer> practice13 () {
        String[] words = {"a10", "b20",
                "a5", "b7", "b12", "a6"};
        return Arrays.stream(words).collect(Collectors.groupingBy(w->w.charAt(0), Collectors.summingInt(w->Integer.parseInt(w.substring(1)))));
    }

    public String practice14() {
        String[] words = {"java", "engineer", "platform", "stream"};
        Map <String,Long> map = Arrays.stream(words).collect(Collectors.toMap(w->w, w->w.chars().filter(c->"aeiou".indexOf(c) >=0).count()));
        return map.entrySet().stream().max(Comparator.comparingLong(a->a.getValue())).map(a->a.getKey()).orElse("");
    }

    public boolean practice15 (Map <String, Integer> map) {
        return map.values().stream().allMatch(value -> value % 2 ==0);
    }

    public Map <Integer, List <String>> practice16 () {
        String[] words = {"apple", "banana",
                "dog", "kiwi", "plum"};
        return Arrays.stream(words).collect(Collectors.groupingBy(word-> word.length(), Collectors.mapping(word -> word.toUpperCase(), Collectors.toList())));
    }


}

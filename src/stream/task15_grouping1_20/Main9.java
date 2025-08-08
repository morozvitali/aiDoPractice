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









}

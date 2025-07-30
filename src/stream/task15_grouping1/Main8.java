package stream.task15_grouping1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main8 {

    public Map<String, Boolean> practice0() {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        return Arrays.stream(words)
                .collect(Collectors
                        .toMap(Function.identity(),
                                word -> word
                                        .chars()
                                        .anyMatch(ch -> "aeiou"
                                                .indexOf(ch) >= 0)
                        ));
    }

    public int practice1(String s) {
        Map<Character, Long> map = s.toLowerCase().chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return (int) map.entrySet().stream().filter(e -> e.getValue() > 1).count();
    }

    public String practice2() {
        Map<String, Long> map = Arrays.stream("java is fun and java is powerful".split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return Collections.max(map.entrySet(), Comparator.comparingLong(entry -> entry.getValue())).getKey();
    }


    public Map<Integer, Integer> practice3() {
        Integer[] array = new Integer[]{12, 23, 34, 45, 16, 7};
        return Arrays.stream(array).collect(Collectors.groupingBy(n -> n % 10, Collectors.summingInt(n -> n)));
    }

    public Map<Character, List<String>> practice5() {
        String[] words = {"apple", "banana", "avocado",
                "blueberry", "bleuberry", "apricot"};
        return Arrays.stream(words).collect(Collectors.groupingBy(w -> w.charAt(0)));
    }

    public Integer practice6() {
        int[] numbers = {1, 2, 2, 3, 3, 3, 4, 4};
        Map<Integer, Long> map = Arrays.stream(numbers).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (var e : map.entrySet()) {
            System.out.println(e.getValue());
            System.out.println(e.getKey());
        }

        return map.entrySet().stream()
                .max(Comparator.comparingLong(entry -> entry.getValue())).get().getKey();
    }

    public Map<Integer, Long> practice7() {
        return "ab123cc44a77".chars().filter(c -> Character.isDigit(c)).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public boolean practice8() {
        int[] numbers = {1, 2, 2, 3, 3, 3, 4, 4};
        Map<Integer, Long> map = Arrays.stream(numbers).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        for (var e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }

        return map.entrySet().stream().anyMatch(entry -> entry.getValue() > 1);
    }

    public void practice9() {
        int[] numbers = {1, 2, 2, 3, 3, 3, 4, 4};
        Arrays.stream(numbers).boxed().collect(Collectors.groupingBy(value -> value % 2 == 0 ? "even" : "odd"));
    }

    public void practice10() {
        int[] numbers = {1, 2, 2, 3, 3, 3, 4, 4};
        Arrays.stream(numbers).boxed().collect(Collectors.groupingBy(d -> d % 3, Collectors.averagingInt(n -> n)));
    }

    public Character practice11() {
        String[] words = {"apple", "banana", "avocado",
                "blueberry", "bleuberry", "apricot"};

        Map<Character, Long> map = Arrays.stream(words).collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.counting()));
        return map.entrySet().stream().max(Comparator.comparingLong(e -> e.getValue())).get().getKey();
    }

    public void practice12() {
        Map<Character, Long> map = new HashMap<>();
        map.put('a', 2L);
        map.put('b', 5L);
        map.put('c', 1L);
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(entry -> System.out.println(entry.getValue() + "->" + entry.getKey()));
    }

    public Map <Character, Integer> practice13() {
        String[] words = {"a10", "b20", "a5",
                "b7", "b12", "a6"};
        return Arrays.stream(words).collect(Collectors.groupingBy(w->w.charAt(0), Collectors.summingInt(w->Integer.parseInt(w.substring(1)))));
    }


}

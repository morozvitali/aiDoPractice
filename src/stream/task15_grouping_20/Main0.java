package stream.task15_grouping_20;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main0 {
    public Map<Integer, List<String>> practice1() {
        String[] words = {"apple", "dog", "banana",
                "cat", "kiwi", "plum", "watermelon"};
        return Arrays.stream(words).collect(Collectors.groupingBy(String::length));
    }

    public Map<Character, List<String>> practice2() {
        List<String> words = List.of("Apple", "apricot",
                "Banana", "blue", "Cherry", "cranberry");
        return words.stream().map(a -> a.toLowerCase()).collect(Collectors.groupingBy(w -> w.charAt(0)));
    }

    public Map<Character, Long> practice3() {
        String[] words = {"apple", "banana", "apricot",
                "blue", "berry", "cherry"};
        return Arrays.stream(words).collect(Collectors.groupingBy(a -> a.charAt(0), Collectors.counting()));
    }

    public Map<String, Boolean> practice4() {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        return Arrays.stream(words).collect(Collectors.toMap(a -> a, a -> a.chars().filter(c -> "aeiou".indexOf(c) >= 0).count() > 0 ? true : false));
    }

    public Map<Character, Long> practice5() {
        return "pentagramma".toLowerCase().chars().mapToObj(ch -> (char) ch).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public String practice6() {
        String s = "java is fun and java is powerful";
        Map<String, Long> map = Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(a -> a, Collectors.counting()));
        return Collections.max(map.entrySet(),
                Comparator.comparingLong(entry -> entry.getValue())).getKey();
    }

    public Map<Integer, Integer> practice7() {
        Integer[] array = new Integer[]{12, 23, 34, 45, 16, 7};
        return Arrays.stream(array).collect(Collectors.groupingBy(a -> a % 10, Collectors.summingInt(b -> b)));
    }

    public Map<Integer, Long> practice8() {
        String[] words = {"one", "two", "three", "six", "seven"};
        return Arrays.stream(words).collect(Collectors.groupingBy(s -> s.length(), Collectors.counting()));
    }

    public void practice9() {
        String[] words = {"apple", "banana", "avocado",
                "blueberry", "bleuberry", "apricot"};
        Arrays.stream(words).collect(Collectors.groupingBy(a -> a.charAt(0)));
    }

    public int practice10() {
        int[] numbers = {1, 2, 2, 3, 3, 3, 4, 4};
        Map<Integer, Long> map = Arrays.stream(numbers).boxed().collect(Collectors.groupingBy(a -> a, Collectors.counting()));
        for (var e : map.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

        return map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(-1);
    }

    public Map<Integer, Long> practice11() {
        return "ab123cc44a77"
                .chars()
                .map(a -> (char) a)
                .filter(a -> Character.isDigit(a))
                .boxed()
                .collect(Collectors
                        .groupingBy(a -> a, Collectors
                                .counting()));
    }

    public void practice12() {
        int[] numbers = {1, 2, 3, 4, 3};
        Map<Integer, Long> map = Arrays.stream(numbers).boxed().collect(Collectors.groupingBy(a -> a, Collectors.counting()));
        map.entrySet().stream().anyMatch(entry -> entry.getValue() > 1);
    }

    public void practice13() {
        int[] numbers = {1, 2, 3, 4, 3};
        Arrays.stream(numbers)
                .boxed()
                .collect(Collectors
                        .groupingBy(a -> a % 2 == 0 ? "even" : "odd"));
    }

    public void practice14() {
        int[] numbers = {3, 6, 7, 8, 9, 10, 12};
        Map<Integer, Double> map = Arrays.stream(numbers)
                .boxed()
                .collect(Collectors
                        .groupingBy(a -> a % 3, Collectors
                                .averagingInt(n -> n)));

        for (var e : map.entrySet()) {
            System.out.println(e.getKey() + "->" + e.getValue());
        }
    }

    public void practice15() {
        String[] words = {"apple", "banana", "avocado",
                "blueberry", "bleuberry", "apricot"};

        Map<Character, Long> map = Arrays.stream(words).collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.counting()));

        map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

        for (var e : map.entrySet()) {
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }

    public void practice16 () {
        String[] words = {"a10", "a20", "b5",
                "b7"};
        Arrays.stream(words).collect(Collectors.groupingBy(a->a.charAt(0), Collectors.summingInt(entry -> Integer.parseInt(entry.substring(1)))));
    }

    public void practice17 () {
        String[] words = {"java", "engineer", "platform", "stream"};
        Map<String, Long> map = Arrays
                .stream(words)
                .collect(Collectors
                        .toMap(w->w, w->w.chars().map(a->(char)a).filter(ch->"aeiou".indexOf(ch)>=0).count()));
        map.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
    }

    public void practice18 () {
        Map <String, Integer> map = null;
        map.values().stream().allMatch(value -> value %2 == 0);
        for (var e : map.entrySet()) {
            System.out.println(e.getKey() + "->" + e.getValue());
        }
    }
}
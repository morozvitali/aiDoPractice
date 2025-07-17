package stream.task15_grouping1;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main0 {
    public Map<Integer, List<String>> practice1 () {
        String[] words = {"apple", "dog", "banana",
                "cat", "kiwi", "plum", "watermelon"};
        return Arrays.stream(words).collect(Collectors.groupingBy(String::length));
    }

    public Map <Character, List <String>> practice2 () {
        List<String> words = List.of("Apple", "apricot",
                "Banana", "blue", "Cherry", "cranberry");
        return words.stream().map(a->a.toLowerCase()).collect(Collectors.groupingBy(w->w.charAt(0)));
    }

    public Map <Character, Long> practice3 () {
        String[] words = {"apple", "banana", "apricot",
                "blue", "berry", "cherry"};
        return Arrays.stream(words).collect(Collectors.groupingBy(a->a.charAt(0), Collectors.counting()));
    }

    public Map <String, Boolean> practice4 () {
        String[] words = {"sky", "apple",
                "dry", "orange", "sun"};
        return Arrays.stream(words).collect(Collectors.toMap(a->a, a-> a.chars().filter(c->"aeiou".indexOf(c)>= 0).count() > 0 ? true : false));
    }

    public Map <Character, Long> practice5 () {
        return "pentagramma".toLowerCase().chars().mapToObj(ch->(char)ch).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public String practice6 () {
        String s = "java is fun and java is powerful";
        Map <String, Long> map = Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(a->a, Collectors.counting()));
                return Collections.max(map.entrySet(),
                        Comparator.comparingLong(entry -> entry.getValue())).getKey();
    }

    public Map <Integer, Integer> practice7 () {
        Integer [] array = new Integer [] {12, 23, 34, 45, 16, 7};
        return Arrays.stream(array).collect(Collectors.groupingBy(a->a%10, Collectors.summingInt(b->b)));
    }

    public Map <Integer, Long> practice8 () {
        String[] words = {"one", "two", "three", "six", "seven"};
        return Arrays.stream(words).collect(Collectors.groupingBy(s->s.length(), Collectors.counting()));
    }

    public void practice9 () {
        String[] words = {"apple", "banana", "avocado",
                "blueberry", "bleuberry", "apricot"};
        Arrays.stream(words).collect(Collectors.groupingBy(a->a.charAt(0)));
    }

    public int practice10 () {
        int [] numbers = {1, 2, 2, 3, 3, 3, 4, 4};
        Map <Integer, Long> map = Arrays.stream(numbers).boxed().collect(Collectors.groupingBy(a -> a, Collectors.counting()));
        return map.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(-1);
    }

}

package stream3.task3_;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main1 {
    public Map<String, Boolean> practice1 () {
        String [] words = new String[] {"Aa", "Bba", "Cec"};
        return Arrays.stream(words)
                        .collect(Collectors.toMap(Function.identity(),
                                w->w.chars().anyMatch(c->"aeiou".indexOf(c)>=0)));
    }

    public Map <Boolean, List<String>> practice2 () {
        String [] array = new String [] {"Aa", "Bba", "Cec"};
        return Arrays.stream(array)
                .collect(Collectors.partitioningBy(w->w.chars()
                        .anyMatch(c->"aeiou".indexOf(c)>=0)));
    }

    public Map <Integer, Long> practice3 () {
        String [] array = new String [] {"Aa", "Bba", "Cec"};
        return Arrays.stream(array).
                filter(w->w.chars().anyMatch(c->"aeiou".indexOf(c)>=0))
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
    }

    public Map <Character, Double> practice4() {
        String [] array = new String [] {"Aa", "Bba", "Cec"};
        return Arrays.stream(array).collect(Collectors.groupingBy(w->w.charAt(0), Collectors.averagingInt(String::length)));
    }

    public Character practice5() {
        String[] array = new String[]{"Aa", "Bba", "Cec", "Aata"};
        return Arrays.stream(array)
                .collect(Collectors.groupingBy(w -> w.charAt(0), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public Map<Integer, List<String>> practice6 () {
        String [] array = new String[]{"Aa", "Bba", "Cec", "Aata"};
        return Arrays.stream(array)
                .collect(Collectors
                        .groupingBy(String::length,
                                Collectors.mapping(String::toUpperCase,
                                        Collectors.toList())));
    }

    public IntSummaryStatistics practice7 () {
        String [] array = new String[]{"Aa", "Bba", "Cec", "Aata"};
        return Arrays.stream(array).filter(w->hasRepeatingLetters(w))
                .mapToInt(String::length)
                .summaryStatistics();
    }

    public static Boolean hasRepeatingLetters(String w) {
        return w.length() - w.chars().distinct().count() == 0;
    }

    public Map <Boolean, List<String>> practice8 () {
        String [] array = new String[]{"Aa", "Bba", "Cec", "Aata"};
        return Arrays.stream(array)
                .collect(Collectors.partitioningBy(w->Character.isUpperCase(w.charAt(0))));
    }

    public void practice9 () {
        String [] array = new String[]{"Aa", "Bba", "Cec", "Aata"};
        Arrays.stream(array).filter(w->Character
                        .isUpperCase(w
                                .charAt(0)))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }

    public Map <Integer, Double> practice10 () {
        String [] array = new String[]{"Aa", "Bba", "Cec", "Aata"};
        return Arrays.stream(array).collect(Collectors.collectingAndThen(
                Collectors.groupingBy(String::length, Collectors.averagingInt(
                        w->(int)w.chars().filter(c -> "aeiou".indexOf(c) >= 0).count())),
                Collections::unmodifiableMap));
    }
}

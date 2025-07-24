package stream.task1_comparator;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main0 {

    public void practice1 () {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");

        words.stream()
                .sorted(Comparator.comparing((String word) -> word.chars()
                        .filter(ch -> "aeiou".indexOf(ch) >=0).count())
                        .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);
    }

    public void practice2 () {
        List.of("alpha", "arena", "java", "banana", "lava").stream().map(w-> Map.entry(w, w.chars().filter(c-> c=='a').count()))
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("Empty");
    }

    public void practice3 () {
        List.of(111, 123, 444, 1212).stream().map(n -> Map.entry(n, (int) String.valueOf(n).chars().distinct().count()))
                .max(Map.Entry.comparingByValue())
                .get().getKey();
    }

    public int [] practice4 (List<Integer> numbers) {
        List<Integer> sorted = numbers.stream().sorted().collect(Collectors.toList());
        return IntStream.range(0, sorted.size() - 1)
                .mapToObj(i -> new int[]{sorted.get(i), sorted.get(i + 1)})
                .min(Comparator.comparingInt(pair -> Math.abs(pair[0] - pair[1])))
                .orElse(null);
    }

    public String practice44 () {
        return List.of("abc", "aaa", "zzz").stream()
                .map(w-> Map.entry(w, w.chars().sum()))
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("empty");
    }


}

package stream.task7_comparator_8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main3 {
    public List<String> practice1() {
        List<String> words = List.of("sky", "banana",
                "apple", "grape", "orange", "plum");
        return words.stream().sorted(Comparator.comparing(Main3::getCount)).toList();
    }

    public static long getCount(String s) {
        return s.chars().filter(c -> "aeiou".indexOf(c) >= 0).count();
    }

    public String practice2() {
        return Stream.of("alpha", "arena", "java", "banana", "lava")
                .collect(Collectors.toMap(Function.identity(), w -> getcount2(w, 'a')))
                .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey).orElse("");
    }

    public long getcount2(String s, char c) {
        return s.chars().filter(ch -> ch == c).count();
    }

    public int practice3(int n) {
        return String.valueOf(Math.abs(n)).chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();
    }
}

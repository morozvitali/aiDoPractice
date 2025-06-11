package stream.task14;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main5 {
    public String practice1() {
        String[] words = {"java", "stream", "code", "developer", "sun"};
        return Arrays.stream(words).filter(w -> w.indexOf('e') >= 0).reduce((a, b) -> a.length() <= b.length() ? a : b).orElse("");
    }

    public long practice2() {
        return Arrays.stream(new int[]{2, 4, 2, 6, 8, 4, 10, 10, 12}).filter(a -> a % 2 == 0).distinct().count();
    }

    public List<String> practice3() {
        List<String> words = List.of("APPLE", "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().filter(a -> a.length() % 2 == 0).map(a -> a.toLowerCase()).toList();
    }

    public Map<Character, List<String>> practice4 () {
        String[] words = {"apple", "ant", "banana", "blue", "berry", "dog", "dolphin"};
        return Arrays.stream(words).collect(Collectors.groupingBy(a->a.charAt(0)));
    }

    public Map<String, Integer> practice5 () {
        String[] words = {"sky", "apple", "moon", "dry", "banana"};
        return Arrays.stream(words).filter(a->counting(a)>1).collect(Collectors.toMap(a->a, a->(int)counting(a)));
    }

    public long counting (String sentence) {
        return sentence.chars().filter(a->"aeiou".indexOf(a) >=0).count();
    }

}
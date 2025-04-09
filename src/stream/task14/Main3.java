package stream.task14;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main3 {
    public String myFilter1() {
        return Arrays.stream(new String[]{"java", "stream", "code", "developer", "sun"})
                .filter(a -> a.contains("e"))
                .reduce((a, b) -> a.length() > b.length() ? a : b)
                .orElse("");
    }

    public int myFilter2 () {

        return (int) Arrays.stream(new int [] {2, 4, 2, 6, 8, 4, 10, 10, 12})
                .filter(a->a%2 == 0)
                .distinct()
                .count();
    }

    public List<String> myFilter3 () {
        List<String> words = List.of("APPLE", "Banana", "CHERRY", "kiwi", "PLUM");
        return words.stream().filter(a->a.length()%2 == 0)
                .map(a->a.toLowerCase())
                .collect(Collectors.toList());
    }

    public Map <Character, List<String>> myFilter4 () {
        return Arrays.stream(new String [] {"apple", "ant", "banana", "blue", "berry", "dog", "dolphin"})
                .filter(a->a.length()>4)
                .collect(Collectors.groupingBy(a->a.charAt(0)));
    }

    public Map<String, Integer> myFilter5 () {
        return Arrays.stream(new String [] {"sky", "apple", "moon", "dry", "banana"})
                .filter(a->isContains(a) > 1)
                .collect(Collectors.toMap(a->a, a-> isContains (a)));
    }

    public int isContains (String s) {
        return (int) s.chars().filter(a->"aeiou".indexOf(a)>=0).count();
    }
}

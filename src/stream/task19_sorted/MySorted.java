package stream.task19_sorted;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MySorted {
    public List<String> mySort() {

        List<String> words = List.of("sun", "banana", "kiwi",
                "cherry", "apple", "tea", "pear");

        return words.stream().filter(a -> a.length() > 3)
                .sorted(Comparator.comparing(String::length)
                .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }
}


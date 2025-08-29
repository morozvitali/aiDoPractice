package stream.task19_sorted_10;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main10 {
    public List <String> practice0 () {
        List<String> words = List.of("sun", "banana", "kiwi",
                "cherry", "apple", "tea", "pear");
        return words.stream().sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder())).toList();
    }

    public List <String> practice2 () {
        return Stream.of("pear", "apple", "banana").sorted(Comparator.naturalOrder()).toList();
    }


}

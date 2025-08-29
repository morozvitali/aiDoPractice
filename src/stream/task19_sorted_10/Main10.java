package stream.task19_sorted_10;

import java.util.Comparator;
import java.util.List;

public class Main10 {
    public List <String> practice1 () {
        List<String> words = List.of("sun", "banana", "kiwi",
                "cherry", "apple", "tea", "pear");
        return words.stream().sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder())).toList();
    }



}

package stream.task19_sorted_10;

import java.util.Comparator;
import java.util.List;

public class Main7 {

    public static void main(String[] args) {
        Main7 m = new Main7();
        m.practice1();
    }

    public List <String> practice1 () {
        List<String> words = List.of("sun", "banana", "kiwi",
                "cherry", "apple", "tea", "pear");

        return words.stream().filter(w->w.length()>3)
                .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder())).toList();
    }



}

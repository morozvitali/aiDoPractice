package stream3.task1_;

import java.util.Comparator;
import java.util.List;

public class Main1 {
    public List<String> practice1() {
        List<String> list = List.of("A", "B", "C");
        return list.stream().filter(w -> w.length() > 3)
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public List <String> practice2() {
        List<String> list = List.of("A", "B", "C");
        return list.stream()
                .map(String::toLowerCase)
                .sorted()
                .toList();
    }

}

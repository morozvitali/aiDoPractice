package stream.task20_collectingAndThen_11;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main1 {
    public List<String> practice1() {
        List<String> data = List.of("apple", "car",
                "banana", "hi", "cherry");
        return data.stream().filter(w -> w.length() > 4).collect(Collectors.collectingAndThen(Collectors.toList(), a -> Collections.unmodifiableList(a)));
    }

    public int practice2() {
        List<Integer> data = List.of(3, 9, 2, 4, 6, 7, 12);
        return data.stream().collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
    }

    public String practice3 () {
        List<String> data = List.of("apple", "car",
                "banana", "hi", "cherry");
        return data.stream().sorted(Comparator.reverseOrder()).collect(Collectors.collectingAndThen(Collectors.toList(), list-> list.get(0)));
    }

    public void practice4 () {
        List<Integer> data = List.of(3, 9, 2, 4, 6, 7, 12);
        data.stream().distinct().toList().get(0);
    }

}

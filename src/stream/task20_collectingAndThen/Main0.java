package stream.task20_collectingAndThen;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main0 {
    public void practice0() {
        List<Integer> numbers = List.of(10, 70, 20, 90, 55, 30);
        numbers.stream().filter(a-> a>50).sorted(Comparator.reverseOrder()).collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public void practice1 () {
        List<String> data = List.of("apple", "car",
                "banana", "hi", "cherry");
        data.stream().filter(a->a.length() >4).collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public void practice2 () {
        List<Integer> numbers = List.of(10, 70, 20, 90, 55, 30);
        numbers.stream().collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
    }

    public void practice3 () {
        List<String> data = List.of("apple", "car",
                "banana", "hi", "cherry");
        data.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors
                        .collectingAndThen(Collectors
                                .toList(),
                                list-> list.get(0)));
    }
}

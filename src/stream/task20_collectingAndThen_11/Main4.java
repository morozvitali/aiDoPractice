package stream.task20_collectingAndThen_11;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main4 {

    public List<Integer> myCollecting1() {
        List<Integer> numbers = List.of(10, 70, 20, 90, 55, 30);
        return numbers.stream().filter(a -> a > 50).sorted(Comparator.reverseOrder())
                .collect(Collectors
                        .collectingAndThen(Collectors.toList(), a -> Collections.unmodifiableList(a)));
    }

    public List<String> myCollecting2() {
        List<String> numbers = List.of("Polly", "it's", "a", "bird", "Polly", "it's", "a", "bird");
        return numbers.stream()
                .filter(a->a.length()>4)
                .collect(Collectors.collectingAndThen(Collectors.toList(), a->Collections.unmodifiableList(a)));
    }
}



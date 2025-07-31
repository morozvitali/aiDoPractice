package stream.task20_collectingAndThen;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main0 {
    public void practice1() {
        List<Integer> numbers = List.of(10, 70, 20, 90, 55, 30);
        numbers.stream().filter(a-> a>50).sorted(Comparator.reverseOrder()).collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }



}

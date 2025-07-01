package stream.task1__sorting;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main6 {
    public List<Integer> practice1() {
        List<Integer> numbers = List.of(3, 6, 1, 9, 4, 8, 2);
        return numbers.stream().filter(a -> a % 2 == 0).map(a -> a * a).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }


}

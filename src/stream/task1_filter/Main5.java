package stream.task1_filter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main5 {
    public static List <Integer> myFiltering () {
        List<Integer> numbers = List.of(3, 6, 1, 9, 4, 8, 2);
        return numbers.stream()
                .filter(a-> a % 2 == 0)
                .map(a->a*a)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(Main5.myFiltering());
    }
}

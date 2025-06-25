package stream.task1__sorting;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main1 {
    public List<Integer> practice1 () {
        List<Integer> numbers = List.of(3, 6, 1, 9, 4, 8, 2);
        return numbers.stream()
                .filter(a->a%2==0)
                .map(a-> a*a)
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    public int practice2 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        return numbers.stream()
                .filter(a->a%2 ==0)
                .map(a-> a*a)
                .mapToInt(a->a)
                .sum();
    }

    public List <String> practice3 () {
        List<String> names = List.of("Ola", "Vitalii", "Sasha", "Alina", "Max");
        return names.stream().filter(a->a.length() >= 4)
                .map(a->a.toUpperCase())
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    public List <Integer> practice6 () {
        List<Integer> numbers = List.of(3, 5, 9, 12, 8, 15);
        long counting = numbers.stream()
                .filter(a->a%3==0)
                .map(a->a*a).count();
        return IntStream.range (0, (int) counting).mapToObj(a->(int)a).toList();
    }
}

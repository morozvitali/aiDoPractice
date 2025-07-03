package stream.task99skip.task1__sorting__to_bucket;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main6 {
    public List<Integer> practice1() {
        List<Integer> numbers = List.of(3, 6, 1, 9, 4, 8, 2);
        return numbers.stream().filter(a -> a % 2 == 0).map(a -> a * a).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }

    public int practice2 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        return numbers.stream().filter(a->a%2!=0).map(a->a*a).mapToInt(a->(int)a).sum();
    }

    public List <String> practice3 () {
        List<String> names = List.of("Ola", "Vitalii", "Sasha", "Alina", "Max");
        return names.stream().filter(a->a.length() > 4).map(a->a.toUpperCase()).sorted(Comparator.reverseOrder()).toList();
    }

    public List <Integer> practice4 () {
        List<Integer> numbers = List.of(4, 6, 2, 6, 4, 8, 10, 2);
        return numbers.stream().filter(a->a%2==0).distinct().sorted(Comparator.naturalOrder()).toList();
    }

    public List <Integer> practice5 () {
        List<String> words = List.of("Apple", "orange",
                "Banana", "Umbrella", "Elephant", "Cat");
        return words.stream().map(a->a.toLowerCase()).filter(a->a.chars().filter(c->"aeiou".indexOf(c) >= 0).count() > 0).map(a->a.length()).toList();
    }

    public List <Integer> practice6 () {
        List<Integer> numbers = List.of(3, 5, 9, 12, 8, 15);
        List list = numbers.stream().filter(a->a%3==0).map(a->a*a).toList();
        return (List<Integer>) IntStream.rangeClosed(0,list.size());
    }

}

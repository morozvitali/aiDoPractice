package stream.task1_filter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main5 {
    public static List <Integer> myFiltering () {
        List<Integer> numbers = List.of(3, 6, 1, 9, 4, 8, 2);
        return numbers.stream()
                .filter(a-> a % 2 == 0)
                .map(a->a*a)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public static int myFiltering2 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7);
        return numbers.stream().filter(a->a%2!=0).map(a->a*a).reduce(0,(a,b)->a+b);
    }

    public static List <String> myFiltering3 () {
        List<String> names = List.of("Ola", "Vitalii", "Sasha", "Alina", "Max");
        return names.stream().filter(a->a.length() > 4).map(a->a.toUpperCase()).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }

    public static List <Integer> myFiltering4 () {
        List<Integer> numbers = List.of(4, 6, 2, 6, 4, 8, 10, 2);
        return numbers.stream().distinct().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }

    public static List <Integer> myFilterin5 () {
        List<String> words = List.of("Apple", "orange", "Banana", "Umbrella", "Elephant", "Cat");
        return words.stream().map(a->a.toLowerCase()).filter(a->"aeiou".indexOf(a.charAt(0))>=0).map(a->a.length()).collect(Collectors.toList());
    }

    public static List <Integer> myFiltering6 () {
        List<Integer> numbers = List.of(3, 5, 9, 12, 8, 15);
        List list = numbers.stream().filter(a -> a%3 == 0).map(a->a*a).collect(Collectors.toList());
        return IntStream.range(0,list.size())
                .boxed()
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(Main5.myFiltering());
    }
}

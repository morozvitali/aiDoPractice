package stream.task1__sorting__to_bucket;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main3 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(3, 6, 1, 9, 4, 8, 2);
        Main3 main3 = new Main3();
        List <Integer> list = main3.filtering1(numbers);
        System.out.println(list.toString());
    }



    public List <Integer> filtering1 (List<Integer> integers) {

        return integers.stream()
                .filter(a -> a % 2 == 0)
                .map(a->a*a)
                .sorted((a,b) -> a > b ? a : b)
                .collect(Collectors.toList());

        //.sorted(Comparator.reverseOrder())
    }

    public int filtering2 (List<Integer> integers) {
        return integers.stream()
                .filter(a->a%2 != 0)
                .map(a->a*a)
                .reduce(0, Integer::sum);
    }

    public List <String> filtering3 (List<String> strings) {
        return strings.stream().filter(s->s.length()>4)
                .map(String::toUpperCase)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public List <Integer> filtering4 (List<Integer> integers) {
        return integers.stream()
                .filter(a->a%2==0)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    public List <Integer> filtering5 (List<String> strings) {
        return strings.stream().filter(a->"aeiou".indexOf(a.charAt(0)) >=0)
                .map(a->a.length())
                .collect(Collectors.toList());

        //Pattern.compile("^[aeiou]").matcher(a).find()
    }

    public List <Integer> filteringBonus (List<Integer> integers) {

        List <Integer> list = integers.stream().filter(a->a%3==0)
                .map(a->a*a)
                .collect(Collectors.toList());

        return IntStream.range(0, list.size())
                .boxed()
                .collect(Collectors.toList());
    }
}
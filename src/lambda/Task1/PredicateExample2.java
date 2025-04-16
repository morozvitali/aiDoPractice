package lambda.Task1;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class PredicateExample2 {
    public static void main(String[] args) {

        Predicate <String> p1 = a -> a.startsWith("A");
        Predicate <String> p2 = a -> a.endsWith("a");
        Predicate <String> p3 = a -> a.contains("aa");

        List <String> list = List.of("Aaa", "Baba", "Gala", "Maga", "Baac", "Caaob");

        PredicateExample2 predicateExample2 = new PredicateExample2();
        System.out.println(predicateExample2.filterWords(list, p1.or(p2)));
    }

    public List <String> filterWords(List<String> list, Predicate<String> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }
}

package stream1.task12_plus_valueOf_10;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main27 {
    public Map<Integer, Long> practice1 () {
        List<String> inputs = List.of("1", "2", "2", "3", "3", "3");
        return inputs.stream()
                .map(Integer::parseInt)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public List<Long> practice2 () {
        List <Long> top10 = new Random().ints(100, -100, 101)
                .mapToObj(String::valueOf)
                .map(Long::valueOf)
                .filter(n->n>0)
                .sorted(Comparator.reverseOrder())
                .limit(10)
                .toList();
        return top10;
    }

    public int practice3(int number) {
        return Integer.parseInt(String.valueOf(Math.abs(number)).chars().map(Character::getNumericValue)
                .map(a->a*a)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }

    public int practice4 (int number) {
        return Integer.parseInt(String.valueOf(Math.abs(number)).chars().map(Character::getNumericValue)
                .map(d->d*d*d)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }




}

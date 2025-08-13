package stream.task1_peek_mapping_chartoint_8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main6 {
    public int practice1(int n) {
        return String.valueOf(n).chars().map(c -> c - '0')
                .map(d -> d * d)
                .sum();
    }

    public boolean practice2(int n) {
        return String.valueOf(n).chars().map(c -> c - '0')
                .allMatch(a -> a % 2 == 0);
    }

    public int practice3(int n) {
        return String.valueOf(n).chars().map(c -> c - '0')
                .reduce(-1, (a, b) -> a > b ? a : b);
    }

    public long practice4 (int n) {
        return String.valueOf(n).chars().map(c->c-'0').filter(d->d>5).count();
    }

    public int practice5 (int n) {
        int [] array = String.valueOf(n).chars().map(c->c-'0').toArray();
        return IntStream.range(0,array.length).filter(i->i%2==1)
                .map(i->array[i])
                .reduce((a,b)->a*b)
                .orElse(-1);
    }

    public void practice6 () {
        List<String> words = List.of("sun", "apple",
                "bee", "banana");
        words.stream().peek(System.out::println)
                .map(w->w.toUpperCase())
                .peek(System.out::println)
                .filter(w->w.length()>3)
                .forEach(System.out::println);
    }

    public Map<Integer, List<String>> practice7 () {
        List<String> emails = List.of("ivan@ukr.net",
                "olga@gmail.com", "petro@ukr.net");
        Map<Integer, List <String>> map = emails.stream()
                .collect(Collectors
                        .groupingBy(w -> w.substring(0,
                                w.indexOf("@")).length(),
                                Collectors.toList()));
        return map;
    }




}

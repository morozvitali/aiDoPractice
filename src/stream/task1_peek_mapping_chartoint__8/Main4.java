package stream.task1_peek_mapping_chartoint__8;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main4 {
    public void practice1 () {
        int n = 234;
        String.valueOf(n).chars().map(c-> c-'0').map(d->d*d).sum();
    }

    public boolean practice2 () {
        int n = 2486;
        return String.valueOf(n).chars().map(a->a-'0')
                .allMatch(a->a%2==0);
    }

    public void practice3 () {
        int n = 8354;
        String.valueOf(n).chars().map(d->d-'0')
                .max().orElse(-1);
    }

    public Long practice4 () {
        int n = 987654321;
        return String.valueOf(n).chars().map(c->c-'0')
                .filter(a->a>5).count();
    }

    public int practice5 () {
        int n = 123456;
        int [] array = String.valueOf(n).chars().map(a->a-'0')
                .toArray();

        return IntStream.range(0, array.length).filter(i-> i%2 == 1)
                .map(i->array[i]).reduce((a,b)->a*b).orElse(-1);
    }

    public void practice6 () {
        List<String> words = List.of("sun", "apple",
                "bee", "banana");
        words.stream().peek(System.out::println)
                .map(a->a.toUpperCase())
                .peek(System.out::println)
                .filter(a->a.length()>3)
                .forEach(System.out::println);
    }

    public Map<Integer, List<String>> practice7 () {
        List<String> emails = List.of("ivan@ukr.net",
                "olga@gmail.com", "petro@ukr.net");
        return emails.stream().collect(Collectors.groupingBy(email -> email.substring(0, email.indexOf("@")).length(),Collectors.toList()));
    }

    public void practice8 () {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        nums.stream().peek(value -> System.out.println("start value " + value)).filter(a->a%2==0).peek(System.out::println).toList();
    }

}

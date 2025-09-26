package stream.task5_peek_mapping_chartoint_8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main5 {
    public void practice1 () {
        int n = 234;
        String.valueOf(n).chars().map(a->a-'0').map(d->d*d).sum();
    }

    public void practice2 () {
        int n = 2486;
        String.valueOf(n).chars().map(a->a-'0')
                .allMatch(a->a%2 == 0);
    }

    public void practice3 () {
        int n = 8354;
        String.valueOf(n).chars().map(c->c-'0').max().orElse(-1);
    }

    public void practice4 () {
        int n = 987654321;
        String.valueOf(n).chars().map(a->a - '0')
                .filter(d->d>5)
                .count();
    }

    public void practice5 () {
        int n = 123456;
        int [] array = String.valueOf(n).chars().map(c->c-'0').toArray();
        IntStream.range(0, array.length).filter(i->i%2 == 1)
                .map(i->array[i]).reduce(1, (a,b) -> a*b);
    }

    public void practice6 () {
        List<String> words = List.of("sun", "apple",
                "bee", "banana");
        words.stream().peek(System.out::println)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .filter(a-> a.length() > 3)
                .forEach(System.out::println);
    }

    public void practice7 () {
        List<String> emails = List.of("ivan@ukr.net",
                "olga@gmail.com", "petro@ukr.net");
        emails.stream().collect(Collectors.groupingBy(email->email.substring(0, email.indexOf("@")).length(), Collectors.toList()));
    }

    public void practice8 () {
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        nums.stream().peek(System.out::println).filter(a->a%2==0).forEach(System.out::println);
    }

}
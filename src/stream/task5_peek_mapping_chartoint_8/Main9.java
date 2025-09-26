package stream.task5_peek_mapping_chartoint_8;

import java.util.List;
import java.util.stream.IntStream;

public class Main9 {
    public int practice1 (int n) {
return String.valueOf(Math.abs(n)).chars()
        .map(c->c-'0')
        .map(a->a*a)
        .sum();
    }

    public Boolean practice2 (int n) {
        return String.valueOf(Math.abs(n)).chars().map(c->c-'0').allMatch(a->a%2==0);
    }

    public int practice3 (int n) {
        return String.valueOf(Math.abs(n)).chars().max().orElse(-1);
    }

    public long practice4 (int n) {
        return String.valueOf(Math.abs(n)).chars().map(c->c-'0').filter(a->a>5).count();
    }

    public int practice5 (int n) {
        int [] digits = String.valueOf(Math.abs(n)).chars().map(c->c-'0').toArray();
        return IntStream.range(0, digits.length)
                .filter(i->i%2==1).map(i->digits[i]).reduce(1, (a,b)-> a*b);
    }

    public void practice6 () {
        List<String> words = List.of("sun", "apple",
                "bee", "banana");
        words.stream()
                .peek(System.out::println)
                .map(String::toUpperCase)
                .peek(System.out::println)
                .filter(w->w.length()>3)
                .forEach(System.out::println);
    }

    public void practice7 () {

    }
}

package stream.task6;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main5 {

    public long practice0 () {
        return IntStream.range(1,100).sum();
    }

    public long practice1 () {
        return IntStream.rangeClosed(10,20).filter(a->a%2==0)
                .count();
    }

    public long practice2 () {
        return IntStream.rangeClosed(21,40).filter(a->a%2!=0).reduce((a,b)-> a<b ? a:b).orElse(-1);
    }

    public long practice3 () {
        return IntStream.rangeClosed(1,5).reduce((a,b) -> a * b).orElse(-1);
    }

    public void practice4 () {
        IntStream.rangeClosed(1,30).filter(a->a%4==0).forEach(System.out::println);
    }
    public String practice5 () {
        int[] numbers = {10, 20, 30};
        return Arrays.stream(numbers)
                .mapToObj(a->String.valueOf(a))
                .reduce("", (a,b) -> (a) + "|" + (b));
    }

    public String practice6 () {
        String[] words = {"apple", "pie", "banana", "kiwi"};
        return Arrays.stream(words).reduce((a,b)-> a.length() <= b.length() ? a : b).orElse("");
    }

    public int practive7 () {
        int[] numbers = {2, 3, 4, 5, 6, 7};
        return Arrays.stream(numbers)
                .filter(a->a%2==0)
                .reduce((a,b) -> a * b)
                .orElse(0);
    }

}

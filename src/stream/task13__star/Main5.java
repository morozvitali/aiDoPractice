package stream.task13__star;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main5 {

    public int practice0 () {
        int[] numbers = {2, 8, 15, 21, 4, 9};
        return Arrays.stream(numbers).filter(a->a%2 != 0).reduce((a,b) -> a>b? a:b).orElse(-1);
    }

    public int practice1 () {
        int[] numbers = {-5, 3, 0, -2, 10, 1};
        return Arrays.stream(numbers).filter(a->a%3==0).reduce((a,b) -> a <=b ? a : b ).orElse(-1);
    }

    public int practice2 () {
        int[] numbers = {-5, 3, 0, -2, 10, 1};
        return Arrays.stream(numbers).filter(a->a>=0).reduce((a,b) -> a >=b ? a : b ).orElse(-1);
    }

    public int practice3 () {
        int[] numbers = {10, 40, 55, 49, 60, 30};
        return Arrays.stream(numbers).reduce((a,b)->a>=b?a:b).orElse(-100);
    }

    public int practice4 () {
        int[] numbers = {10, 40, 55, 49, 60, 30};
        return Arrays.stream(numbers).filter(a->a<50).reduce((a,b)->a>=b?a:b).orElse(-1);
    }

    public int practice5 () {
        int[] numbers = {3, 5, 2, 6};
        return Arrays.stream(numbers).filter(a->a%2==0).map(a->a*a).max().orElse(-1);
    }

    public int practice6 () {
        int[] numbers = {2, 3, 4, 5, 6, 7};
        return Arrays.stream(numbers).filter(a->a%2==0).reduce((a,b)->a*b).orElse(0);
    }

    public int practice7 () {
        return IntStream.rangeClosed(1,5).map(a->a*a).sum();
    }

    public List<Integer> practice8 () {
        return IntStream.rangeClosed(10,50).filter(a->a%7==0).boxed().collect(Collectors.toList());
    }

    public long practice9 () {
        return IntStream.rangeClosed(1,100).filter(a->a%3==0 || a%5==0).count();
    }

    public void practice10 () {
        IntStream.iterate(10, i -> i-1).limit(10).forEach(System.out::println);
    }
}

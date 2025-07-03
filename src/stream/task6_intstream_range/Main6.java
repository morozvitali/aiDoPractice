package stream.task6_intstream_range;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main6 {
    public int practice1 () {
        return IntStream
                .rangeClosed(1,99)
                .sum();
    }

public long practice2 () {
        return IntStream.rangeClosed(10,20)
                .filter(a->a%2==0)
                .count();
}

public int practice3 () {
        return IntStream.rangeClosed(21,40)
                .filter(a->a%2 != 0)
                .findFirst()
                .orElse(-1);
}

public int practice4 () {
        return IntStream.rangeClosed(1,5).reduce((a,b)-> a*b).orElse(-1);
}

public void practice5 () {
        IntStream.rangeClosed(1, 30).filter(a->a%4==0).forEach(System.out::println);
}

public void practice6 () {
        IntStream.rangeClosed(1,31)
                .filter(a->a%2==1)  // непарні
                .mapToObj(a-> BigInteger.valueOf(a)) // перетворюємо на BigInteger
                .reduce(BigInteger.ONE, (a,b) -> a.multiply(b)); // тут форма reduce (0, (a,b)->do)) - бо є початкове значення і orElse не треба
}

public void practice7 () {
    int[] numbers = {10, 20, 30};
    Arrays.stream(numbers)
            .mapToObj(a->String.valueOf(a))
            .reduce((a,b) -> a + "|" + b)
            .orElse("");
}

public int practice8 () {
        return IntStream.rangeClosed(2,8)
                .filter(a->a%2==1)
                .reduce((a,b)-> a*b)
                .orElse(-1);
}

public int practice9 () {
        return IntStream.rangeClosed(1,5).map(a->a*a).sum();
}

public List<Integer> practice10 () {
        return IntStream.rangeClosed(10, 50).filter(a->a%7==0)
                .boxed()
                .collect(Collectors.toList());
}
}

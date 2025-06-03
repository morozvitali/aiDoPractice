package stream.task6;

import java.util.Arrays;

public class Main5 {

    public String practice4 () {
        int[] numbers = {10, 20, 30};
        return Arrays.stream(numbers).mapToObj(a-> String.valueOf(a))
                .reduce((a,b) -> a + "|" + b).orElse("empty");
    }

    public String practice5 () {
        String[] words = {"apple", "pie", "banana", "kiwi"};
        return Arrays.stream(words).reduce((a,b) -> a.length() < b.length() ? a : b).orElse("");
    }

    public int practice6 () {
        int [] numbers = {2, 3, 4, 5, 6, 7};
        return Arrays.stream(numbers).filter(a->a%2 == 0).reduce((a,b) -> a*b).orElse(0);
    }
}

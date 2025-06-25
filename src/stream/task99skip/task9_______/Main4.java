package stream.task99skip.task9_______;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main4 {
    public List<Integer> lenghtCalc () {
        String[] words = {"java", "python", "go"};
        return Arrays.stream(words).map(a->a.length()).collect(Collectors.toList());
    }

    public List<Integer> sqaureCalc () {
        int[] numbers = {2, 3, 4};
        return Arrays.stream(numbers).map(a->a*a)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<String> toUpperCaseEditor () {
        String[] words = {"apple", "banana", "kiwi"};
        return Arrays.stream(words).map(a->a.toUpperCase()).collect(Collectors.toList());
    }
}

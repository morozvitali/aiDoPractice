package stream.task99skip.task9_______;

import java.util.Arrays;

public class Main5 {
    public void practice1 () {
        String[] words = {"java", "python", "go"};
        Arrays.stream(words).map(a->a.length()).forEach(System.out::println);
    }

    public void practice2 () {
        int[] numbers = {2, 3, 4};
        Arrays.stream(numbers).map(a->a*a).forEach(System.out::println);
    }

    public void practice3 () {
        String[] words = {"apple", "banana", "kiwi"};
        Arrays.stream(words).map(a->a.toUpperCase()).forEach(System.out::println);
    }



}

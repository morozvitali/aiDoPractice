package stream.task7;

import java.util.Arrays;

public class Main5 {
    public void practice1 () {
        String[] words = {"apple", "banana", "book", "car", "blue"};
        Arrays.stream(words)
                .filter(a-> "aeiou"
                .indexOf(a.charAt(0))>=0)
                .forEach(System.out::println);
    }

    public void practice5 () {
        int [] numbers = {3, 10, 14, 9, 20, 25, 8};
        Arrays.stream(numbers).filter(a-> a%2 ==0).forEach(System.out::println);
    }



}

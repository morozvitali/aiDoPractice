package stream.task99skip.task10___________;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {

    public List <Integer> myMap1 () {
        String[] words = {"hi", "apple", "go", "banana", "car"};
        return  Arrays.stream(words)
                .map(String::length)
                .filter(a->a>3)
                .collect(Collectors.toList());
    }

    public List<Integer> myMap2 () {
        int[] numbers = {1, 2, 3, 4, 5};
        return Arrays.stream(numbers)
                .filter(a -> a % 2 != 0)
                .map(a -> a * a)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<String> myMap3 () {
        String[] words = {"apple", "banana", "apricot", "cherry", "avocado"};
        return Arrays.stream(words)
                .map(String::toUpperCase)
                .filter(a->a.charAt(0)=='a')
                .collect(Collectors.toList());
    }
}

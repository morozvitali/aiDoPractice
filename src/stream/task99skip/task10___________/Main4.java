package stream.task99skip.task10___________;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main4 {
    public List<Integer> myFilter() {
        String[] words = {"hi", "apple", "go", "banana", "car"};
        return Arrays.stream(words)
                .filter(a -> a.length() > 3)
                .map(a -> a.length())
                .toList();
    }

    public List<Integer> myFilter2() {
        int[] numbers = {1, 2, 3, 4, 5};
        return Arrays.stream(numbers)
                .filter(a -> a % 2 != 0)
                .map(a -> a * a)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<String> myFilter3() {
        String[] words = {"apple", "banana", "apricot", "cherry", "avocado"};
        return Arrays.stream(words)
                .map(a -> a.toLowerCase())
                .filter(c -> c.startsWith("a"))
                .map(a -> a.toUpperCase())
                .collect(Collectors.toList());
    }

    public List<Integer> myFilter4() {
        int[] numbers = {3, 5, 10, 14, 15};
        return Arrays.stream(numbers)
                .filter(a -> a % 5 == 0)
                .map(a -> a * 2)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<String> myFilter5() {
        String[] words = {"java", "code", "home", "sun", "snow"};
        return Arrays.stream(words)
                .filter(a -> a.length() == 4)
                .map(w -> w.substring(0, 1).toUpperCase() + w.substring(1).toLowerCase())
                .collect(Collectors.toList());
    }

    public List <Integer> myFilter6() {
        int[] numbers = {2, 2, 4, 6, 3, 4};
        return Arrays.stream(numbers)
                .filter(a->a%2==0)
                .map(a->a*a)
                .distinct()
                .boxed()
                .collect(Collectors.toList());
    }
}
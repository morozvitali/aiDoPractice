package stream.task10_map_filter_collect;

import java.util.Arrays;

public class Main5 {
    public void practice1 () {
        String[] words = {"hi", "apple", "go", "banana", "car"};
        Arrays.stream(words).filter(a-> a.length() > 3).map(a->a.length()).forEach(System.out::println);
    }

    public void practice2 () {
        int[] numbers = {1, 2, 3, 4, 5};
        Arrays.stream(numbers).filter(a->a%2 == 0).map(a->a*a).forEach(System.out::println);
    }

    public void practice3 () {
        String[] words = {"apple", "banana", "apricot", "cherry", "avocado"};
        Arrays.stream(words).filter(a->a.charAt(0) == 'a').map(a->a.toUpperCase()).forEach(System.out::println);
    }


}

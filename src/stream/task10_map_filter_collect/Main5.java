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

    public void practice4 () {
        int[] numbers = {3, 5, 10, 14, 15};
        Arrays.stream(numbers).filter(a->a%5==0).map(a->a*2).forEach(System.out::println);
    }

    public void practic5 () {
        String[] words = {"java", "code", "home", "sun", "snow"};
        Arrays.stream(words).filter(a->a.length() == 4).map(w ->w.substring (0,1).toUpperCase() + w.substring(1).toLowerCase()).forEach(System.out::println);
    }

    public void practice6 () {
        int[] numbers = {2, 2, 4, 6, 3, 4};
        Arrays.stream(numbers).filter(a->a%2==0).map(a->a*a).distinct().forEach(System.out::println);
    }


}

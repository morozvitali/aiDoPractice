package stream.task99skip.task7_anymatch;

import java.util.Arrays;
import java.util.List;

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

    public boolean practice6 () {
        List<Integer> list = List.of(3, -5, 7, 10);
        return list.stream()
                .anyMatch(a->a<0);
    }

    public boolean practice7 () {
        List<Integer> list = List.of(2, 5, 10, 20);
        return list.stream().allMatch(a->a>=0);
    }

    public boolean practice8() {
        List<Integer> list = List.of(1, 2, 3, 0);
        return list.stream().noneMatch(a->a==0);
    }

    public boolean practice9() {
        List<Integer> list = List.of(1, 2, 3, 0);
        return list.stream().anyMatch(a->a%7==0);
    }

    public boolean practice10 () {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        return names.stream().allMatch(a-> Character.isUpperCase(a.charAt(0)));
    }

    public boolean practice11 () {
        List<String> words = List.of("racecar", "apple", "madam");
        return words.stream().anyMatch(a->a==isPolindrom(a));
    }

    public String isPolindrom (String str) {
        return new StringBuilder(str).reverse().toString();
    }
}

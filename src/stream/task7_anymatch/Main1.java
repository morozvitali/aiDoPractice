package stream.task7_anymatch;

import java.util.List;

public class Main1 {
    public boolean practice1 () {
        List<Integer> list = List.of(3, -5, 7, 10);
        return list.stream().anyMatch(a-> a < 0);
    }

    public boolean practice2 () {
        List<Integer> list = List.of(2, 5, 10, 20);
        return list.stream().allMatch(a-> a>0);
    }

    public boolean practice3 () {
        List<Integer> list = List.of(1, 2, 3, 0);
        return list.stream().noneMatch(a->a==0);
    }

    public boolean practice4 () {
        List<Integer> list = List.of(1, 2, 3, 0);
        return list.stream().anyMatch(a->a%7 == 0);
    }

    public boolean practice5 () {
        List<String> names = List.of("Alice", "Bob", "Charlie");
        return names.stream().allMatch(w -> Character.isUpperCase(w.charAt(0)));
    }

    public boolean practice6 () {
        List<String> words = List.of("racecar", "apple", "madam");
        return words.stream().anyMatch(a-> a.equals(new StringBuilder(a).reverse().toString()));
    }
}

package stream2.task6_;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main3 {
    public void practice1() {
        List<String> names = List.of("Bob", "Anna", "John");
        Map<String, Integer> map = names.stream().collect(Collectors.toMap(
                name -> name,
                String::length
        ));
        System.out.println(map);
    }

    public void practice2() {
        List<String> names = List.of("Bob", "Bill", "Anna");

        Map<Character, String> map = names.stream()
                .collect(Collectors.toMap(name -> name.charAt(0),
                        name -> name));
        System.out.println(map);
    }

    public void practice3() {
        List<String> names = List.of("Bob", "Bill", "Anna");
        Map<Character, String> map = names.stream()
                .collect(Collectors.toMap(name -> name.charAt(0),
                        name -> name,
                        (v1, v2) -> v1 + ", " + v2));
        System.out.println(map);
    }

    public void practice4() {
        List<String> names = List.of("Bob", "Bill", "Benjamin");
        Map<Character, String> map = names.stream()
                .collect(Collectors.toMap(
                        s -> s.charAt(0),
                        s -> s,
                        (a, b) -> a.length() <= b.length() ? a : b
                ));
        System.out.println(map);
    }

    public void practice5 () {
        List<String> fruits = List.of("apple", "pear", "apple", "banana", "pear");
        Map<String, Long> freq = fruits.stream().collect(Collectors.toMap(
                f -> f,
                _ ->1L,
                Long::sum
                ));
        System.out.println(freq);
    }


    public void practice6 () {
        List<String> words = List.of("cat", "cow", "dog", "duck");
        Map <Character, List<String>> map = words.stream()
                .collect(Collectors.toMap(
                        w->w.charAt(0),
                        w->new ArrayList<>(List.of(w)),
                        (list1, list2) -> {list1.addAll(list2); return list1;}
                ));
        System.out.println(map);
    }


}

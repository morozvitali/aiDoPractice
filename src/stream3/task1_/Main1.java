package stream3.task1_;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main1 {
    public List<String> practice1() {
        List<String> list = List.of("A", "B", "C");
        return list.stream().filter(w -> w.length() > 3)
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public List <String> practice2() {
        List<String> list = List.of("A", "B", "C");
        return list.stream()
                .map(String::toLowerCase)
                .sorted()
                .toList();
    }

    public String practice3 () {
        List<String> list = List.of("Aa", "Bob", "Coca");
        return list.stream().map(w-> Map.entry(w, w.length()))
                .max(Comparator.comparingInt(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("");
    }

    public Integer practice4 (Integer n) {
        return String.valueOf(Math.abs(n))
                .chars()
                .map(c->c-'0')
                .map(d->d*d)
                .sum();
    }

    public List<Integer> practice5 (String s) {
        return s.chars()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .distinct()
                .sorted()
                .boxed()
                .toList();
    }

    public Integer practice6 (int n) {
        return Integer.parseInt(
                new StringBuilder(String
                        .valueOf(Math.abs(n)))
                        .reverse()
                        .toString());
    }

    public Integer practice7 (int n) {
        return Integer.parseInt(String.valueOf(Math.abs(n))
                .chars()
                .filter(a->a%2==0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining()));
    }










}

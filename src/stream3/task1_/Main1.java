package stream3.task1_;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

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
















}

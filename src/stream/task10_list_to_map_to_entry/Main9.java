package stream.task10_list_to_map_to_entry;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main9 {
    public String practice1 () {
        List<String> words = List.of("stream", "code",
                "developer", "Engineer");
        return words.stream().collect(Collectors.toMap(Function.identity(), String::length)).entrySet().stream()
                .max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
    }

    public String practice2 () {
        List<String> list = List.of("Java", "C",
                "Python", "Go", "Kotlin");
        //return list.stream().collect(Collectors.reducing((a,b)->a.length() > b.length() ? a : b)).orElse("");
        return list.stream().collect(Collectors.toMap(Function.identity(), String::length))
                .entrySet().stream().reduce((a,b)->a.getValue() > b.getValue() ? a : b)
                .map(Map.Entry::getKey).orElse("");
    }

    public String practice3 () {
        List<String> list = List.of("apple", "banana",
                "orange", "blueberry");
        return list.stream().collect(Collectors.toMap(Function.identity(), w->getCount(w)))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
    }

    public static long getCount (String s) {
        return s.chars().filter(c->"aeiou".indexOf(c)>=0).count();
    }

    public String practice4 () {
        List<String> list = List.of("apple", "pear",
                "banana", "kiwi");

        return list.stream().collect(Collectors.toMap(Function.identity(), w->getUniqLetter(w)))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse("");
    }

    public static int getUniqLetter (String s) {
        Set<Character> set = null;

        s.chars().forEach(c->set.add((char) c));
        assert set != null;
        return set.size();
    }


}

package stream2.task7_;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main3 {

    public void practice1 () {
        List<String> names = Stream.of("Bob", "Alice", "Tom")
                .collect(Collectors
                        .toUnmodifiableList());
        System.out.println(names);
    }

    public void practice2 () {
        Set <Integer> set = Stream.of(1,2,3,2)
                .collect(Collectors.toUnmodifiableSet());
        System.out.println(set);
    }

    public void practice3 () {
        Map<String, Integer> map = Stream.of("A", "B", "C")
                .collect(Collectors.toUnmodifiableMap(
                        s->s,
                        String::length
                ));
    }

    public void ptactice4 () {
        List<String> list = List.of("apple", "apricot");
        Map <Character, String> map = list.stream()
                .collect(Collectors.toUnmodifiableMap(
                        s-> s.charAt(0),
                        s->s
                ));
        System.out.println(map);
    }

    public void practice5 () {
        Map<Character, String> map = Stream.of("apple", "apricot")
        .collect(Collectors.toUnmodifiableMap(
                s->s.charAt(0),
                s->s,
                (a,b) -> a+ ", " + b
        ));
        System.out.println(map);
    }


}

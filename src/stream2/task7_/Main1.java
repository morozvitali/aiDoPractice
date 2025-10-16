package stream2.task7_;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main1 {
    public void practice1 () {
        List<String> names = Stream.of("Bob", "Alice", "Tom")
                .collect(Collectors.toUnmodifiableList());
        System.out.println(names);
        names.add("aa");
    }

    public void practice2 () {
        Set<Integer> set = Stream.of(1,2,3,4)
                .collect(Collectors.toUnmodifiableSet());
        System.out.println(set);
        set.add(11);
    }

    public void practice3 () {
        Map<String, Integer> map = Stream.of("A", "B", "C")
                .collect(Collectors.toUnmodifiableMap(
                        s->s,
                        String::length
                ));
    }

    public void practice4 () {
        List<String> list = List.of("apple", "apricot");
        Map <Character, String> map = list.stream()
                .collect(Collectors.toUnmodifiableMap(
                        s->s.charAt(0),
                        s->s
                ));
            // Illegal State Exception, dublicate key 'a'

    }

}

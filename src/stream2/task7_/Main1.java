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

    public void practice5 () {
        Map <Character, String> map = Stream.of("apple", "apricot")
                .collect(Collectors.toUnmodifiableMap(
                    s -> s.charAt(0),
                    s->s,
                        (a,b) -> a + "," + b
                ));
        System.out.println(map);
    }

    public void practice6 () {
        Map <Character, List <String>> map = Stream.of("cat", "cow", "dog")
                .collect(Collectors.toUnmodifiableMap(
                        w->w.charAt(0),
                        w->List.of(w),
                        (l1,l2) -> Stream.concat(l1.stream(), l2.stream()).toList()
                ));
        System.out.println(map);
    }

    public void practice7 () {
        var modifiable = Stream.of("A", "B").collect(Collectors.toList());
        var unmodifiable = Stream.of("A", "B").collect(Collectors.toUnmodifiableList());
        modifiable.add("C");
        unmodifiable.add("C");
    }



}

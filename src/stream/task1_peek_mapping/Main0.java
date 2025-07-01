package stream.task1_peek_mapping;

import java.util.List;
import java.util.stream.Collectors;

public class Main0 {
    public void practice1 () {
        List<String> words = List.of("sun", "apple", "bee", "banana");
        List <String> result = words.stream()
                .peek(w-> System.out.println("оригінал" + w))
                .map(w->w.toUpperCase())
                .peek(System.out::println)
                .filter(a->a.length()>3)
                .peek(w-> System.out.println("більше 3 букв " + w))
                .collect(Collectors.toList());
    }

}

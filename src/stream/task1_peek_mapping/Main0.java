package stream.task1_peek_mapping;

import java.util.List;
import java.util.Map;
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

    public void practice2 () {
        List<String> emails = List.of("ivan@ukr.net", "olga@gmail.com", "petro@ukr.net");
        Map<Integer, List<String>> byLoginLength =
                emails.stream()
                        .collect(Collectors.groupingBy(
                                email -> email.substring(0, email.indexOf("@")).length(),
                                Collectors.mapping(
                                        email -> email.substring(email.indexOf("@") + 1),
                                        Collectors.toList()
                                )
                        ));
    }
    
}

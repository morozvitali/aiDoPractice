package stream2.task6_;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main1 {
    public void practice1 () {
        List<String> names = List.of("Bob", "Anna", "John");

        Map<String, Integer> map = names.stream()
                .collect(Collectors.toMap(
                        name-> name,
                        String::length
                ));
        System.out.println(map);
    }



}

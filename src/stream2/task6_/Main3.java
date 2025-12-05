package stream2.task6_;

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
    }

    public void pracvtice3() {
        List<String> names = List.of("Bob", "Bill", "Anna");
        Map <Character, String> map = names.stream()
                .collect(Collectors.toMap(name -> name.charAt(0),
                        name -> name,
                        (v1,v2)->v1 + ", " + v2));
        System.out.println(map);
    }
}

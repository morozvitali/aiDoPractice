package stream.task11;

import java.util.List;

public class Main5 {
    public List <String> practice1() {
        List<String> names = List.of
                ("Alice", "Bob", "Anna", "George", "alex", "Amanda");

        return names.stream().filter(value -> value.startsWith("A")).toList();
    }

    public long practice2 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 8);
        return numbers.stream().filter(a-> a%2 == 0).count();
    }


}

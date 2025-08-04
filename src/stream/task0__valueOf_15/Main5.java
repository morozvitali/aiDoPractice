package stream.task0__valueOf_15;

import java.util.List;
import java.util.stream.Collectors;

public class Main5 {
    public void practice1 () {
        List<Integer> codes = List.of(97, 98, 99, 100, 101);
        codes.stream().map(c->String.valueOf((char)(int)c))
                .collect(Collectors.toList());
    }

    public void practice2 () {
        String mixed = "a1b2c3x9z7";
        mixed.chars().filter(c->Character.isDigit(c))
                .mapToObj(c->Character.getNumericValue(c))
                .sorted()
                .collect(Collectors.toList());
    }

}

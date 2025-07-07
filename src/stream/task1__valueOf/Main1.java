package stream.task1__valueOf;

import java.util.List;
import java.util.stream.Collectors;

public class Main1 {
    public List<String> practice1 () {
        List<Integer> codes = List.of(97, 98, 99, 100, 101);
        return codes.stream().map(n-> String.valueOf((char)(int)n))
                .collect(Collectors.toList());
    }

    public List <Integer> practice2 () {
        String mixed = "a1b2c3x9z7";
        return mixed.chars()
                .filter(c->Character.isDigit(c))
                .mapToObj(c-> Character.getNumericValue(c))
                .sorted()
                .collect(Collectors.toList());
    }

}

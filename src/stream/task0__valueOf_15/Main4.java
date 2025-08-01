package stream.task0__valueOf_15;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main4 {

    public List <String> practice1 () {
        List<Integer> codes = List.of(97, 98, 99, 100, 101);
        return codes.stream().map(c->String.valueOf((char)(int)c)).collect(Collectors.toList());
    }

public void practice2 () {
    String mixed = "a1b2c3x9z7";
    mixed.chars()
            .filter(value->Character
                    .isDigit(value))
            .mapToObj(c->Character
            .getNumericValue(c))
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toList());
}

    public void practice3 () {
        String s = "abracadabra";
        s.chars()
                .distinct()
                .mapToObj(c->String.valueOf((char)c))
                .collect(Collectors.toList());
    }


}

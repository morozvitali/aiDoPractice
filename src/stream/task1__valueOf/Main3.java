package stream.task1__valueOf;

import java.util.List;
import java.util.stream.Collectors;

public class Main3 {

    public void practice1 () {
        List<Integer> codes = List.of(97, 98, 99, 100, 101);
        codes.stream().map(ch-> String.valueOf((char)(int)ch))
                .collect(Collectors.toList());
    }

    public void practice2 () {
        String mixed = "a1b2c3x9z7";
        mixed.chars().filter(ch->Character.isDigit(ch))
                .mapToObj(c->Character.getNumericValue(c))
                .sorted()
                .toList();
    }

    public void practice3 () {
        String s = "abracadabra";
        s.chars().distinct().mapToObj(ch->String.valueOf((char)ch)).toList();


    }
}

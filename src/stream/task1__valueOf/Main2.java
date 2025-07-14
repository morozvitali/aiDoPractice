package stream.task1__valueOf;

import java.util.List;
import java.util.stream.Collectors;

public class Main2 {
    public void practice1 () {
    List<Integer> codes = List.of(97, 98, 99, 100, 101);
    List <String> list = codes.stream().map(c->String.valueOf((char)(int)c))
            .collect(Collectors.toList());
}

public void practice2 () {
    String mixed = "a1b2c3x9z7";

    List <Integer> list = mixed.chars().filter(Character::isDigit)
            .mapToObj(ch->Character.getNumericValue(ch))
            .sorted()
            .collect(Collectors.toList());
}



}

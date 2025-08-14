package stream.task12_plus_valueOf_10;

import java.util.stream.Collectors;

public class Main4 {
    public int practice1 (int number) {
        return Integer.valueOf(
                String.valueOf(number)
                .chars()
                        .map(ch->Character.getNumericValue(ch))
                        .map(a->a*a)
                        .mapToObj(n->String.valueOf(n))
                        .collect(Collectors.joining()));
    }


}

package stream.task12_plus;

import java.util.stream.Collectors;

public class Main0 {
    public int practice1 (int n) {
        return Integer.parseInt(String.valueOf(n)
                .chars()
                .map(ch->Character.getNumericValue(ch))
                .map(a->a*a)
                .mapToObj(a->String.valueOf(a))
                .collect(Collectors.joining()));
    }

    public int practice2 (int number) {
        return Integer.parseInt(String.valueOf(number)
                .chars()
                .map(ch->Character.getNumericValue(ch))
                .map(a->a*a)
                .mapToObj(a->String.valueOf(a))
                .collect(Collectors.joining()));
    }

}

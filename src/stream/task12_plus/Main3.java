package stream.task12_plus;

import java.util.stream.Collectors;

public class Main3 {
    public int practice1 (int number) {
        return Integer.valueOf(String.valueOf(number)
                .chars()
                .map(ch-> Character.getNumericValue(ch))
                .map(a->a*a)
                .mapToObj(n->String.valueOf(n))
                .collect(Collectors.joining()));
    }

    public int practice2 (int number) {
        return Integer.valueOf(
                String.valueOf(number)
                .chars()
                .map(a->a*a*a)
                        .mapToObj(n->String.valueOf(n))
                        .collect(Collectors.joining()));
    }




}

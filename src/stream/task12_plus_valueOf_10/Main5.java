package stream.task12_plus_valueOf_10;

import java.util.stream.Collectors;

public class Main5 {
    public String practice1 (int n) {
        return String.valueOf(n).chars().map(a->Character.getNumericValue(a))
                .map(a->a*a).mapToObj(String::valueOf).collect(Collectors.joining());
    }


}

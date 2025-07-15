package stream.task12_plus;
import java.util.stream.Collectors;
public class Main1 {
public int practice1 (int n) {
            return Integer.valueOf(String.valueOf(n)
                            .chars().map(ch->Character
                                    .getNumericValue(ch))
                            .map(a->a*a).mapToObj(a->String.valueOf(a))
                            .collect(Collectors.joining("")));
}


public int practice2 (int number) {
    return Integer.valueOf(String
            .valueOf(number)
            .chars()
            .map(ch->Character.getNumericValue(ch))
            .map(a->a*a*a)
            .mapToObj(a-> String.valueOf(a))
            .collect(Collectors
                    .joining("")));
}

    public int practice3 (int number) {
    return Integer.valueOf(String
            .valueOf(number)
            .chars()
            .map(ch->Character.getNumericValue(ch))
            .filter(n->n%2==0)
            .mapToObj(a->String.valueOf(a))
            .collect(Collectors
                    .joining("")));
    }

    public String practice5 (int number) {
    return String
            .valueOf(number)
            .chars()
            .mapToObj(a-> "*".repeat(a))
            .collect(Collectors.joining(""));
    }

    public int practice6 (int number) {
    return Integer.valueOf(new StringBuilder(String.valueOf(number)).reverse().toString());
    }

    public int practice (int number) {

    return Integer.valueOf(String.valueOf(number)
            .chars()
            .map(ch->Character.getNumericValue(ch))
            .map(a->a%2==1 ? a : a*a)
            .mapToObj(a->String.valueOf(a))
            .collect(Collectors.joining("")));
    }
}

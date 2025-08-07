package stream.task12_plus_valueOf_10;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public long practice8 (int number) {
    return String.valueOf(number).length();
    }

    public void practice10 (int number) {
    Integer.valueOf(String
            .valueOf(number)
            .chars()
            .map(ch->Character.getNumericValue(ch))
            .map(val->Math.abs(val-5))
            .mapToObj(d->String.valueOf(d))
            .collect(Collectors.joining())
    );
    }

    public int practice9 (int number) {
    String s = String.valueOf(number);
    return Integer.valueOf(IntStream.rangeClosed(1, s.length() + 1)
            .mapToObj(i-> {
                int digit = Character
                        .getNumericValue(s.charAt(i));
                return String.valueOf(digit * (i+1));
                    }).collect(Collectors.joining()));
    }

    public int practice11 (int number) {
    return Integer.valueOf(String.valueOf(number)
            .chars()
            .map(ch -> Character.getNumericValue(ch))
            .mapToObj(a->a>5?"X":"0")
            .collect(Collectors.joining()));
    }
}

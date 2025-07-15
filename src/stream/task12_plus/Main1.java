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


}

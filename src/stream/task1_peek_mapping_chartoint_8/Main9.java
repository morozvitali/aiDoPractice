package stream.task1_peek_mapping_chartoint_8;

import java.util.stream.Collectors;

public class Main9 {
    public int practice1 (int n) {
return String.valueOf(Math.abs(n)).chars()
        .map(c->c-'0')
        .map(a->a*a)
        .sum();
    }


}

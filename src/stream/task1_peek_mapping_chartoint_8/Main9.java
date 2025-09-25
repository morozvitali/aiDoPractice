package stream.task1_peek_mapping_chartoint_8;

import java.util.stream.Collectors;

public class Main9 {
    public int practice1 (int n) {
return String.valueOf(Math.abs(n)).chars()
        .map(c->c-'0')
        .map(a->a*a)
        .sum();
    }

    public Boolean practice2 (int n) {
        return String.valueOf(Math.abs(n)).chars().map(c->c-'0').allMatch(a->a%2==0);
    }

    public int practice3 (int n) {
        return String.valueOf(Math.abs(n)).chars().max().orElse(-1);
    }

    public long practice4 (int n) {
        return String.valueOf(Math.abs(n)).chars().map(c->c-'0').filter(a->a>5).count();
    }


}

package stream.task1_peek_mapping_chartoint;

import java.util.stream.IntStream;

public class Main4 {
    public void practice1 () {
        int n = 234;
        String.valueOf(n).chars().map(c-> c-'0').map(d->d*d).sum();
    }

    public boolean practice2 () {
        int n = 2486;
        return String.valueOf(n).chars().map(a->a-'0')
                .allMatch(a->a%2==0);
    }

    public void practice3 () {
        int n = 8354;
        String.valueOf(n).chars().map(d->d-'0')
                .max().orElse(-1);
    }

    public Long practice4 () {
        int n = 987654321;
        return String.valueOf(n).chars().map(c->c-'0')
                .filter(a->a>5).count();
    }

    public int practice5 () {
        int n = 123456;
        int [] array = String.valueOf(n).chars().map(a->a-'0')
                .toArray();

        return IntStream.range(0, array.length).filter(i-> i%2 == 1)
                .map(i->array[i]).reduce((a,b)->a*b).orElse(-1);
    }
}

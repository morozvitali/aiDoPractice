package stream.task1_peek_mapping_chartoint_8;

public class Main6 {
    public int practice1 (int n) {
        return String.valueOf(n).chars().map(c->c-'0')
                .map(d->d*d)
                .sum();
    }

    public boolean practice2 (int n) {
        return String.valueOf(n).chars().map(c->c-'0')
                .allMatch(a->a%2==0);
    }


}

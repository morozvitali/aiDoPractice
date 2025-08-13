package stream.task1_peek_mapping_chartoint_8;

public class Main6 {
    public void practice1 (int n) {
        String.valueOf(n).chars().map(c->c-'0')
                .map(d->d*d)
                .sum();
    }


}

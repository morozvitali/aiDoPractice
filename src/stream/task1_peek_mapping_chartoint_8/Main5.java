package stream.task1_peek_mapping_chartoint_8;

public class Main5 {
    public void practice1 () {
        int n = 234;
        String.valueOf(n).chars().map(a->a-'0').map(d->d*d).sum();
    }

    public void practice2 () {
        int n = 2486;
        String.valueOf(n).chars().map(a->a-'0')
                .allMatch(a->a%2 == 0);
    }



}

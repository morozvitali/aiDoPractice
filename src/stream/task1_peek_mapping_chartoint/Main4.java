package stream.task1_peek_mapping_chartoint;

public class Main4 {
    public void practice1 () {
        int n = 234;
        String.valueOf(n).chars().map(c-> c-'0').map(d->d*d).sum();
    }

    public void practice2 () {

    }
}

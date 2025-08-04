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

    public void practice3 () {
        int n = 8354;
        String.valueOf(n).chars().map(c->c-'0').max().orElse(-1);
    }

    public void practice4 () {
        int n = 987654321;
        String.valueOf(n).chars().map(a->a - '0')
                .filter(d->d>5)
                .count();
    }


}
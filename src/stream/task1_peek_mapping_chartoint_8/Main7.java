package stream.task1_peek_mapping_chartoint_8;

public class Main7 {
    public int practice1(int n) {
        return String.valueOf(n).chars()
                .map(c -> c - '0')
                .map(d -> d * d)
                .sum();
    }

    public Boolean practice2 (int n) {
        return String.valueOf(n).chars()
                .map(c->c-'0')
                .allMatch(d->d%2==0);
    }

    public int practice3 (int n) {
        return String.valueOf(n).chars()
                .map(c->c-'0')
                .max()
                .orElse(-1);
    }


}

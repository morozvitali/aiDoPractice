package stream.task1_peek_mapping_chartoint;

public class Main1 {
    public int practice1(int n) {
        return String.valueOf(n).chars().map(c -> c - '0').map(d -> d * d).sum();
    }

    public boolean practice2(int n) {
        return String.valueOf(n).chars().map(c -> c - '0').allMatch(d -> d % 2 == 0);
    }

    public int practice3(int n) {
        return String.valueOf(n).chars().map(c -> c - '0')
                .max().orElse(-1);
    }

    public long practice4(int n) {
        return String.valueOf(n).chars().map(c -> c - '0').filter(a -> a > 5).count();
    }
}

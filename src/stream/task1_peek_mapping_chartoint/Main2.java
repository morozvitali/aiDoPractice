package stream.task1_peek_mapping_chartoint;

public class Main2 {
    public int practice1 (int n) {
        return String.valueOf(n).chars().map(c-> c - '0')
                .map(d-> d*d)
                .sum();
    }
}

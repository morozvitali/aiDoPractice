package stream.task1_peek_mapping_chartoint;

public class Main2 {
    public int practice1 (int n) {
        return String.valueOf(n).chars().map(c-> c - '0')
                .map(d-> d*d)
                .sum();
    }

    public Boolean practice2 (int n) {
        return String.valueOf(n).chars().allMatch(a-> a%2 == 0);
    }

    public int practice3 (int n) {
        return String.valueOf(n).chars().max().orElse(-1);
    }



}

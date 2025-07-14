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

    public long practice4 (int n) {
        return String.valueOf(n).chars().map(c->c-'0')
                .filter (a->a>5)
                .count();
    }

    public int practice5 (int n) {
        int [] array = String
                .valueOf(n)
                .chars()
                .map(a->a-'0')
                .toArray();

        int result = 1;
        for (int i =0; i < array.length; i+=2) {
            result = result * array[i];
        }
        return result;
    }


}

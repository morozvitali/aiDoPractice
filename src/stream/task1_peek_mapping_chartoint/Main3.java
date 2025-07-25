package stream.task1_peek_mapping_chartoint;

public class Main3 {

    public void practice1 () {
        int n = 234;
        String.valueOf(n).chars()
                .map(c-> c-'0')
                .map(val -> val * val)
                .sum();
    }

    public void practice2 () {
        int n = 2486;
        String.valueOf(n).chars()
                .map(c-> c-'0')
                .allMatch(value -> value %2 == 0);
    }



}

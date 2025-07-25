package stream.task1_peek_mapping_chartoint;

import java.util.stream.IntStream;

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

    public void practice3 () {
        int n = 8354;
        String.valueOf(n).chars().map(c->c-'0')
                .max()
                .orElse(-1);
    }

    public void practice4 () {
        int n = 987654321;
        String.valueOf(n).chars().map(ch->ch-'0')
                .filter(value -> value > 5)
                .count();
    }

    public void practice5 () {
        int number = 123456;
        int [] array = String
                .valueOf(number)
                .chars()
                .map(n-> n-'0')
                .toArray();

        IntStream.range(0, array.length)
                        .filter(i->i%2 ==1)
                                .map(i->array[i])
                                        .reduce(1, (a,b) -> a*b);
    }


}

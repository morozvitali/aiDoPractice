package stream.task4__takewhile_anonimous_class;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class Main1 {
    public void practice1() {
        IntStream.iterate(1, i -> i + 1).takeWhile(new IntPredicate() {
            int sum = 0;

            @Override
            public boolean test(int i) {
                sum = sum + i;
                return sum < 50;
            }
        });
    }
}
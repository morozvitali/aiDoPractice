package stream2.task2_;

import java.util.stream.IntStream;

public class Main1 {
public void practice1 () {
    int sum = IntStream.rangeClosed(1,5).map(n->n*n).sum();
}


}

package stream2.task4_;

import java.util.UUID;
import java.util.stream.Stream;

public class Main1 {
    public void practice1() {
        Stream.iterate(0, n -> n + 2)
                .limit(5)
                .forEach(System.out::println);
    }

    public void practice2() {
        Stream.generate(() -> (int) (Math.random() * 10))
                .limit(5)
                .forEach(System.out::println);
    }

    public void practice3 () {
        Stream.iterate(1, n->n+1)
                .map(n->n*n)
                .limit(5)
                .forEach(System.out::println);
    }


    public void practice4 () {
        Stream.iterate(1, n->n <=10, n-> n+2)
                .forEach(System.out::println);
    }

    public void practice5 () {
        Stream.generate(UUID::randomUUID)
                .limit(3)
                .forEach(System.out::println);
    }

    public void practice6 () {
        Stream.iterate(new int[]{0,1}, a -> new int []{a[1], a[0] + a[1]})
                .limit(10)
                .map(a->a[0])
                .forEach(System.out::println);
    }

    public void practice7 () {
        Stream.iterate(1, n->n+1)
                .peek(n->{
                    try {Thread.sleep(1000); } catch (InterruptedException e) {}
                })
                .limit(5)
                .forEach(n-> System.out.println("Tick " + n));
    }

    public void practice8 () {
        Stream.iterate(1, n-> n+3)
                .takeWhile(n->n<20)
                .forEach(System.out::println);
    }


}

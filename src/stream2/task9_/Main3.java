package stream2.task9_;

import java.util.List;

public class Main3 {

    public void practice1() {
        List.of(1, 2, 3, 4, 5)
                .stream()
                .forEach(System.out::println);
    }

    public void practice2() {
        List.of(1, 2, 3, 4, 5)
                .parallelStream()
                .forEach(System.out::println);
    }

    public void practice3() {
        List.of(1, 2, 3, 4, 5)
                .parallelStream()
                .forEachOrdered(System.out::println);
    }

    public void practice4() {
        List.of("a", "b", "c", "d")
                .parallelStream()
                .forEach(s ->
                        System.out.println(Thread.currentThread()
                                .getName() + " -> " + s));
    }

}

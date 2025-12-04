package stream2.task3_;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Main3 {

    public void practice1() {
        Stream.of(1, 2, 3, 4, 6, 2, 1)
                .takeWhile(n -> n < 5)
                .forEach(System.out::println);
    }

    public void practice2() {
        Stream.of(1, 2, 3, 4, 6, 2, 1)
                .dropWhile(n -> n < 5)
                .forEach(System.out::println);
    }

    public void practice3() {
        Stream.of(1, 2, 3, 6, 2, 1)
                .filter(n -> n < 5)
                .forEach(System.out::println);
    }

    public void practice4() {
        List<Integer> nums = List.of(1, 2, 3, 2, 5);
        AtomicInteger prev = new AtomicInteger(0);
        List<Integer> result = nums.stream()
                .takeWhile(n -> {
                    boolean ok = n > prev.get();
                    prev.set(n);
                    return ok;
                }).toList();
        System.out.println(result);
    }

    public void practice5() {
        List<String> lines = List.of("", "", "Hello", "World", "!");
        List<String> content = lines.stream()
                .dropWhile(String::isEmpty)
                .toList();
    }

    public void practice6() {
        List<Integer> temps = List.of(15, 16, 18, 21, 19, 17);
        List<Integer> morning = temps.stream()
                .takeWhile(t->t <=20)
                .toList();
    }

    public void practice7() {
        List<Integer> nums = List.of(0, 0, 0, 4, 5, 0, 6);
        List <Integer> clean = nums.stream()
                .dropWhile(n->n==0)
                .toList();
        System.out.println(clean);
    }


}


















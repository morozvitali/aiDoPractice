package stream.task5_skip_limit;

import java.util.List;

public class Main0 {
    public void practice1 () {
        List<Integer> list = List.of(10, 20, 30, 40, 50);
        list.stream().limit(3).forEach(System.out::println);
    }



}

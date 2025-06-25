package stream.task5_skip_limit;

import java.util.List;

public class Main1 {
    public List <Integer> practice1 () {
        List<Integer> list = List.of(10, 20, 30, 40, 50);
        return list.stream().limit(3).toList();
    }

    public void practice2 () {
        List<Integer> list = List.of(5, 6, 7, 8, 9);
        list.stream().skip(2).forEach(System.out::println);
    }

    public void practice3 () {
        List<Integer> list = List.of(100, 200, 300, 400, 500);
        list.stream().skip(1).limit(3).forEach(System.out::println);
    }

}

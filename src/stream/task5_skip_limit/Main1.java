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

    public void practice4 () {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        list.stream().skip(list.size()-2).forEach(System.out::println);
    }

    public int practice5 () {
        List<Integer> list = List.of(3, 2, 4, 6, 1, 8, 10, 12);
        return list.stream().limit(5).mapToInt(a-> (int)a).sum();
    }

}

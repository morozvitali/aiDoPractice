package stream.task5_skip_limit;

import java.util.List;

public class Main1 {
    public List <Integer> practice1 () {
        List<Integer> list = List.of(10, 20, 30, 40, 50);
        return list.stream().limit(3).toList();
    }



}

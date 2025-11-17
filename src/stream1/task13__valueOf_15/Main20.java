package stream1.task13__valueOf_15;

import java.util.List;

public class Main20 {
    public List <String> task1 () {
        List<Integer> codes = List.of(97, 98, 99, 100, 101);
        return codes.stream().map(String::valueOf).toList();
    }




}

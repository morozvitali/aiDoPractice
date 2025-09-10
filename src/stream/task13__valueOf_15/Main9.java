package stream.task13__valueOf_15;

import java.util.List;

public class Main9 {
    public List <Character> practice1 () {
        List<Integer> codes = List.of(97, 98, 99, 100, 101);
        return codes.stream().map(a->(char)(int)a)
                //.map(String::valueOf)
                .toList();
    }


}

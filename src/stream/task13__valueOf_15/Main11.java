package stream.task13__valueOf_15;

import java.util.List;

public class Main11 {
    public void practice1 () {
        List<Integer> codes = List.of(97, 98, 99, 100, 101);
        codes.stream().map(c->String.valueOf((char)(int)c))
                .toList();
    }

    public void practice2 () {

    }


}

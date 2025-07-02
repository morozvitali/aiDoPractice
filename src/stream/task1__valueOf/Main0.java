package stream.task1__valueOf;

import java.util.List;
import java.util.stream.Collectors;

public class Main0 {
    public List <String> practice1 () {
        List<Integer> codes = List.of(97, 98, 99, 100, 101);
        return codes.stream().map(c->String.valueOf((char)(int)c)).collect(Collectors.toList());
    }


}

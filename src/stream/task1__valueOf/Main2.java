package stream.task1__valueOf;

import java.util.List;
import java.util.stream.Collectors;

public class Main2 {
    public void practice1 () {
    List<Integer> codes = List.of(97, 98, 99, 100, 101);
    List <String> list = codes.stream().map(c->String.valueOf((char)(int)c))
            .collect(Collectors.toList());
}


}

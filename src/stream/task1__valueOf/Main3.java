package stream.task1__valueOf;

import java.util.List;
import java.util.stream.Collectors;

public class Main3 {

    public void practice () {
        List<Integer> codes = List.of(97, 98, 99, 100, 101);
        codes.stream().map(ch-> String.valueOf((char)(int)ch))
                .collect(Collectors.toList());
    }




}

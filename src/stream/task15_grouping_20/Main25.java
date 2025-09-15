package stream.task15_grouping_20;

import java.util.function.Function;
import java.util.stream.Collectors;

public class Main25 {
    public Long practice1 (String s) {
        return s.toLowerCase().chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e->e.getValue() >1).count();
    }



}

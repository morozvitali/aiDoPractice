package stream.task15_grouping_20;

import java.util.function.Function;
import java.util.stream.Collectors;

public class Main16 {
    public long practice1 (String s) {
        return s.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream().filter(entry->entry.getValue() > 1).count();
    }


}

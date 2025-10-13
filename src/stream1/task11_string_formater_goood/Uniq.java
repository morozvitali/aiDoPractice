package stream1.task11_string_formater_goood;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Uniq {
    public List<String> uniqWords (String s) {
        return Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry->entry.getValue()==1).map(Map.Entry::getKey).toList();
    }
}

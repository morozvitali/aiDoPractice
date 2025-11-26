package stream1.task12_plus_valueOf_10;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main27 {
    public Map<Integer, Long> practice1 () {
        List<String> inputs = List.of("1", "2", "2", "3", "3", "3");
        return inputs.stream()
                .map(Integer::parseInt)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }


}

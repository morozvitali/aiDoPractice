package stream.task18_flatMap_19;

import java.util.List;
import java.util.stream.Collectors;

public class Main5 {

    public List<Integer> mapper() {
        List<List<Integer>> weeklyData = List.of(
                List.of(40, 55, 60),
                List.of(30, 70),
                List.of(65, 10, 90)
        );

        return weeklyData.stream().flatMap(list->list.stream())
                .filter(a -> a > 50)
                .collect(Collectors.toList());
    }
}

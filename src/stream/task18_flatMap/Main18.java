package stream.task18_flatMap;

import java.util.List;
import java.util.stream.Collectors;

public class Main18 {
    public List<Integer> practice1 () {
        List<List<Integer>> weeklyData = List.of(
                List.of(40, 55, 60),
                List.of(30, 70),
                List.of(65, 10, 90)
        );

        return weeklyData.stream()
                .flatMap(list->list.stream())
                .collect(Collectors.toList()).stream().filter(a->a<50).toList();
    }
}

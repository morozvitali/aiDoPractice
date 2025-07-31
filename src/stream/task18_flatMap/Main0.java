package stream.task18_flatMap;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main0 {
    public void practice1 () {
    List<List<Integer>> weeklyData = List.of(
            List.of(40, 55, 60),
            List.of(30, 70),
            List.of(65, 10, 90)
    );

    weeklyData.stream().flatMap(list->list.stream())
            .filter(value->value > 50)
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.toList())




}

package stream.task18_flatMap_13;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main4 {
    public List<Integer> myFlatMap () {

        List<List<Integer>> weeklyData = List.of(
                List.of(40, 55, 60),
                List.of(30, 70),
                List.of(65, 10, 90)
        );

        return weeklyData.stream().flatMap(list->list.stream())
                .filter(a -> a>50)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}

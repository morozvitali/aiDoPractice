package stream.task18_flatMap;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MyFlatMap {

    public List<Integer> myFlat() {

        List<List<Integer>> weeklyData = List.of(
                List.of(40, 55, 60),
                List.of(30, 70),
                List.of(65, 10, 90)
        );


        // чистіше .flatMap(Collection::stream)

        return weeklyData.stream().flatMap(list -> list.stream())
                .filter(a -> a>50)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }
}

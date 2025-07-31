package stream.task18_flatMap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main0 {
    public void practice0() {
        List<List<Integer>> weeklyData = List.of(
                List.of(40, 55, 60),
                List.of(30, 70),
                List.of(65, 10, 90)
        );

        weeklyData.stream().flatMap(list -> list.stream())
                .filter(value -> value > 50)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
    }

    public void practice1 () {
        int[][] data = {
                {3, 11},
                {6, 7},
                {10}
        };

        Arrays.stream(data).flatMapToInt(arr -> Arrays.stream(arr))
                .filter(a->a%2==0)
                .min()
                .orElse(-1);
    }


}

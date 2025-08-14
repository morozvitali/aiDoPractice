package stream.task9_diff_21;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main3 {
    public List<Integer> practice1 () {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{2, 4, 6};

        Set<Integer> setb = Arrays.stream(b)
                .boxed().collect(Collectors.toSet());
        return Arrays.stream(a)
                .filter(value -> setb.contains(value))
                .boxed()
                .collect(Collectors.toList());

    }


}

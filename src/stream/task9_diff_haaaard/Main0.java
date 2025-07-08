package stream.task9_diff_haaaard;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Main0 {
    public int [] practice1 () {
        int [] a = new int [] {1, 2, 3, 4};
        int [] b = new int [] {2, 4, 6};
        // -> [2, 4]
        Set<Integer> set = Arrays.stream(b)
                .boxed()
                .collect(Collectors.toSet());
        return Arrays.stream(a).filter(x->set.contains(x))
                .toArray();
    }

    public int [] practice2 () {
        int [] a = new int [] {1, 2, 3, 4};
        int [] b = new int [] {2, 4, 6};
        Set <Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());
        return Arrays.stream(b).filter(x->!set.contains(x)).toArray();
    }




}

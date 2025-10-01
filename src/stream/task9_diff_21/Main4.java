package stream.task9_diff_21;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main4 {
    public int [] practice1 () {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{2, 4, 6};
            Set<Integer> set = Arrays.stream(b).boxed().collect(Collectors.toSet());
            return Arrays.stream(a).filter(set::contains).toArray();
    }

    public int [] practice2 () {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{2, 4, 6};
        Set <Integer> setb = Arrays.stream(b).boxed().collect(Collectors.toSet());
        return Arrays.stream(a).filter(n->!setb.contains(n)).toArray();
    }




}

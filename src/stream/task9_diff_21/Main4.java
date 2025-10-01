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

    public List practice3 () {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{2, 4, 6};
        Set<Integer>  sa = Arrays.stream(a).boxed().collect(Collectors.toSet());
        Set<Integer>  sb = Arrays.stream(b).boxed().collect(Collectors.toSet());

        Set<Integer> one = sa.stream().filter(value -> !sb.contains(value)).collect(Collectors.toSet());
        Set<Integer> two = sb.stream().filter(value -> !sa.contains(value)).collect(Collectors.toSet());
        return Stream.concat(one.stream(), two.stream()).toList();
    }



}

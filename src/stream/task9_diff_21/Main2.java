package stream.task9_diff_21;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main2 {
    public List<Integer> practice1() {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{2, 4, 6};

        Set<Integer> set = Arrays.stream(b).boxed().collect(Collectors.toSet());
        return Arrays.stream(a).filter(value ->set.contains(a)).boxed().collect(Collectors.toList());
    }

    public void practice2 () {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{2, 4, 6};

        Set <Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());
        Arrays.stream(b).boxed().filter(value->!set.contains(value)).collect(Collectors.toList());
    }

    public Set <Integer> practice3 () {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{2, 4, 6};

        Set <Integer> sa = Arrays.stream(a).boxed().collect(Collectors.toSet());
        Set <Integer> sb = Arrays.stream(b).boxed().collect(Collectors.toSet());
        Set <Integer> one = sa.stream().filter(value -> !sb.contains(value)).collect(Collectors.toSet());
        Set <Integer> two = sb.stream().filter(value-> !sa.contains(value)).collect(Collectors.toSet());
        Set<Integer> result = new HashSet<>();
        result.addAll(one);
        result.addAll(two);
        return result;

    }


}

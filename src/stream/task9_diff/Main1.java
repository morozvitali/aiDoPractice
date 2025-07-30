package stream.task9_diff;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main1 {

    public List<Integer> practice1() {

        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{2, 4, 6};

        Set<Integer> set = Arrays.stream(b).boxed().collect(Collectors.toSet());
        return Arrays.stream(a).filter(set::contains).boxed().collect(Collectors.toList());
    }

    public List <Integer> practice2 () {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{2, 4, 6};

        Set <Integer> set = Arrays.stream(b).boxed().collect(Collectors.toSet());
        return Arrays.stream(a).filter(value -> !set.contains(value)).boxed().collect(Collectors.toList());
    }

    public Set <Integer> practice3 () {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{2, 4, 6};

        Set <Integer> seta = Arrays.stream(a).boxed().collect(Collectors.toSet());
        Set <Integer> setb = Arrays.stream(b).boxed().collect(Collectors.toSet());

        Set<Integer> sum1 = seta.stream().filter(value -> !setb.contains(value)).collect(Collectors.toSet());
        Set<Integer> sum2 = setb.stream().filter(value -> !seta.contains(value)).collect(Collectors.toSet());
        sum1.addAll(sum2);
        return sum1;
    }

    public List<Integer> practice4 () {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{2, 4, 6};

        Set <Integer> set = Arrays.stream(b).boxed().collect(Collectors.toSet());
        return Arrays.stream(a).filter(value -> set.stream().noneMatch(s->value%s == 0)).boxed().collect(Collectors.toList());
    }


}

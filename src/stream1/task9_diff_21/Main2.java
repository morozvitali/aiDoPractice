package stream1.task9_diff_21;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main2 {
    public List<Integer> practice1() {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{2, 4, 6};

        Set<Integer> set = Arrays.stream(b).boxed().collect(Collectors.toSet());
        return Arrays.stream(a).filter(value -> set.contains(a)).boxed().collect(Collectors.toList());
    }

    public void practice2() {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{2, 4, 6};

        Set<Integer> set = Arrays.stream(a).boxed().collect(Collectors.toSet());
        Arrays.stream(b).boxed().filter(value -> !set.contains(value)).collect(Collectors.toList());
    }

    public Set<Integer> practice3() {
        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{2, 4, 6};

        Set<Integer> sa = Arrays.stream(a).boxed().collect(Collectors.toSet());
        Set<Integer> sb = Arrays.stream(b).boxed().collect(Collectors.toSet());
        Set<Integer> one = sa.stream().filter(value -> !sb.contains(value)).collect(Collectors.toSet());
        Set<Integer> two = sb.stream().filter(value -> !sa.contains(value)).collect(Collectors.toSet());
        Set<Integer> result = Stream.concat(one.stream(), two.stream()).collect(Collectors.toSet());
        return result;
    }

    public List<Integer> practice4() {
        List<Integer> a = List.of(10, 15, 20, 11);
        List<Integer> b = List.of(5, 7);

        return a.stream().filter(x -> b.stream().noneMatch(value -> x % value == 0)).toList();
    }

    public List <String> practice5() {
        List<String> a = List.of("hi", "hello", "world");
        List<Integer> b = List.of(5, 7);
        return a.stream().filter(value -> !b.contains(value.length())).toList();
    }


    public List <Integer> practice6 () {
        List<Integer> a = List.of(1, 2, 2, 3, 3, 4);
        List<Integer> b = List.of(3);
        Map<Integer, Long> map = a.stream().collect(Collectors
                .groupingBy(value -> value,
                        Collectors.counting()));
        return a.stream().filter(x->map.get(x) >1 && !b.contains(x)).toList();
    }

    public List <Integer> practice7 () {
        List<Integer> a = List.of(0, 1, 0, 2);
        List<String> b = List.of("zero");

        return b.contains("zero") ? a : a.stream().filter(value -> value != 0).toList();
    }


}

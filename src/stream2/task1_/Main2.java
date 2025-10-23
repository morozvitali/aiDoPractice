package stream2.task1_;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;

public class Main2 {
    public String practice1 () {
        List<String> list = List.of("Java", "Stream", "API");
        String result = list.stream().collect(Collector.of(
                StringBuilder::new,
                (sb, s) -> sb.append(s).append(" "),
                StringBuilder::append,
                StringBuilder::toString
        ));
        return result;
    }

    public int practice2 () {
        List<Integer> nums = List.of(1, 2, 3, 4);
        int sum = nums.stream().collect(Collector.of(
                () -> new int[1],
                (a, n) -> a[0] += n,
                (a1, a2) -> {
                    a1[0] += a2[0]; return a1;
                }, a->a[0]
        ));
        return sum;
    }

    public double practice3 () {
        List<Integer> list = List.of(5, 10, 15);
        double avg = list.stream().collect(Collector.of(
                () -> new int [2],
                (a,n) -> {a[0] += n; a[1]++;},
                (a1,a2) -> {a1[0] +=a2[0]; a1[1]+=a2[1]; return a1;},
                a->(double)a[0]/a[1]
        ));
        return avg;
    }

    public void practice4 () {
        List<String> words = List.of("a", "b", "a", "c");
            Set<String> set = words.stream().collect(Collector.of(
                    HashSet::new,
                    Set::add,
                    (s1, s2) -> {
                        s1.addAll(s2);
                        return s1;
                    }
            ));
    }










}

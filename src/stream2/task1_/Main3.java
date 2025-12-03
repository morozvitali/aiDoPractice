package stream2.task1_;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main3 {

    public void practice1 () {
        List<String> list = List.of("Java", "Stream", "API");
        String result = list.stream().collect(Collector.of(
                StringBuilder::new,
                (sb, s) -> sb.append(s).append(" "),
                StringBuilder::append,
                StringBuilder::toString
        ));
    }

    public void practice2 () {
        List<Integer> nums = List.of(1, 2, 3, 4);
        int sum = nums.stream().collect(Collector.of(
                () -> new int[1],
                (a,n) -> a[0] += n,
                (a1, a2) -> {a1[0] +=a2[0]; return a1;},
                a->a[0]
        ));
    }

    public void practice3 () {
        List<Integer> list = List.of(5, 10, 15);
        double avg = list.stream().collect(Collector.of(
                () -> new int[2],
                (a, n) -> { a[0] += n; a[1]++; },
                (a1, a2) -> {a1[0]+=a2[0]; a1[1]+=a2[1]; return a1; },
                a->(double)a[0]/a[1]
        ));
    }

    public void practice4 () {
        List<String> words = List.of("a", "b", "a", "c");
        Set<String> set = words.stream().collect(Collector.of(
                HashSet::new,
                Set::add,
                (s1,s2) -> {s1.addAll(s2); return s1;}
        ));
    }

    public void practice5 () {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        List <Integer> evens = nums.stream().collect(Collector.of(
                ArrayList::new,
                (list, n) -> {if (n%2 == 0) list.add(n);},
                (l1,l2) -> {l1.addAll(l2); return l1;}
        ));
    }

    public void practice6 () {
        List<String> words = List.of("apple", "banana", "pear");
        Map<Character, Integer> map = words.stream().collect(Collector.of(
                HashMap::new,
                (m, s) -> m.put(s.charAt(0), s.length()),
                (m1, m2) -> {m1.putAll(m2); return m1;}
                ));
    }


}

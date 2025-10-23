package stream2.task1_;

import java.util.*;
import java.util.stream.Collector;

public class Main2 {
    public String practice1() {
        List<String> list = List.of("Java", "Stream", "API");
        String result = list.stream().collect(Collector.of(
                StringBuilder::new,
                (sb, s) -> sb.append(s).append(" "),
                StringBuilder::append,
                StringBuilder::toString
        ));
        return result;
    }

    public int practice2() {
        List<Integer> nums = List.of(1, 2, 3, 4);
        int sum = nums.stream().collect(Collector.of(
                () -> new int[1],
                (a, n) -> a[0] += n,
                (a1, a2) -> {
                    a1[0] += a2[0];
                    return a1;
                }, a -> a[0]
        ));
        return sum;
    }

    public double practice3() {
        List<Integer> list = List.of(5, 10, 15);
        double avg = list.stream().collect(Collector.of(
                () -> new int[2],
                (a, n) -> {
                    a[0] += n;
                    a[1]++;
                },
                (a1, a2) -> {
                    a1[0] += a2[0];
                    a1[1] += a2[1];
                    return a1;
                },
                a -> (double) a[0] / a[1]
        ));
        return avg;
    }

    public void practice4() {
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


    public void practice5() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        List<Integer> evens = nums.stream().collect(Collector.of(
                ArrayList::new,
                (list, n) -> {
                    if (n % 2 == 0)
                        list.add(n);
                },
                (l1, l2) -> {
                    l1.addAll(l2);
                    return l1;
                }
        ));
    }

    public Map<Character, Integer> practice6() {
        List<String> words = List.of("apple", "banana", "pear");

        Map<Character, Integer> map = words.stream().collect(Collector.of(
                HashMap::new,
                (m, s) -> m.put(s.charAt(0), s.length()),
                (m1, m2) -> {
                    m1.putAll(m2);
                    return m1;
                }));

        return map;
    }

    public List<String> practice7() {
        List<String> list = List.of("a", "b", "c");
        List<String> upper = list.stream().collect(Collector.of(
                ArrayList::new,
                List::add,
                (a, b) -> {
                    a.addAll(b);
                    return a;
                },
                l -> l.stream().map(w -> ((String) w).toUpperCase()).toList()
        ));
        return upper;
    }

    public void practice8() {
        List<String> names = List.of("Mark", "Luke", "John");
        String joined = names.stream().collect(Collector.of(
                StringBuilder::new,
                (sb, s) -> {
                    if (sb.length() > 0) sb.append(", ");
                    sb.append(s);
                },
                (a, b) -> {
                    if (a.length() > 0 && b.length() > 0) a.append(", ");
                    a.append(b);
                    return a;
                },
                StringBuilder::toString
        ));
    }

    public void practice9 () {
        List<Integer> nums = List.of(10, 20, 30);
        Map <String, Double> result = nums.stream().collect(Collector.of(
                () -> new double[2],
                (a,n) -> {a[0]+= n; a[1]++; },
                (a1,a2) -> {a1[0]+= a2[0];a1[1]+=a2[1]; return a1;},
                a->Map.of("sum", a[0], "avg", a[0]/a[1])
        ));
    }

    public void practice10 () {
        String text = "banana";
        long vowels = text.chars().mapToObj(c->(char)c)
                .collect(Collector.of(
                        () -> new long[1],
                        (a,ch) -> { if ("aeiou".indexOf(ch) >= 0) a[0]++;},
                        (a1,a2) -> {a1[0] +=a2[0]; return a1;},
                        a->a[0]
                ));
    }







}

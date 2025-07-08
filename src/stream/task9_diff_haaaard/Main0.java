package stream.task9_diff_haaaard;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public int [] practice3 () {
        int [] a = new int [] {1, 2, 3, 4};
        int [] b = new int [] {2, 4, 6};
        Set <Integer> setA = Arrays.stream(a).boxed().collect(Collectors.toSet());
        Set <Integer> setB = Arrays.stream(b).boxed().collect(Collectors.toSet());

        int [] arrayA = Arrays.stream(b).filter(value -> !setA.contains(value)).toArray();
        int [] arrayB = Arrays.stream(a).filter(value -> !setB.contains(value)).toArray();

        return IntStream.concat(Arrays.stream(arrayA), Arrays.stream(arrayB)).toArray();
    }

    public int [] practice4 () {
        int [] a = new int [] {10, 15, 20, 11};
        int [] b = new int [] {5, 7};
        return Arrays.stream(a).filter(value->Arrays.stream(b).filter(d->value%d==0).count()>0).toArray();
    }

    public String [] practice5 () {
        String [] a = new String [] {"hi", "hello", "world"};
        int [] b = new int [] {5, 7};
        return (String[]) Arrays.stream(a).filter(value -> Arrays.stream(b).filter(number -> value.length() == number).count()>0).toArray();
    }
}

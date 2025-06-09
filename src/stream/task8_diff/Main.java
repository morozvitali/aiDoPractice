package stream.task8_diff;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public int [] practice1 (){
        int [] a = new int [] {1, 2, 3, 4};
        int [] b = new int [] {2, 4, 6};
        // -> [2, 4]
        Set <Integer> set = Arrays.stream(b).boxed().collect(Collectors.toSet());
        return Arrays.stream(a).filter(x->set.contains(x))
                .toArray();
    }

    public int [] practice2 (){
        int [] a = new int [] {1, 2, 3, 4};
        int [] b = new int [] {2, 4, 6};
        // -> [1, 3]
        Set <Integer> set = Arrays.stream(b).boxed().collect(Collectors.toSet());
        return Arrays.stream(a).filter(x->!set.contains(x))
                .toArray();
    }

    public void practice3 () {
        int [] a = new int [] {1, 2, 3};
        int [] b = new int [] {3, 4};
        // -> [1, 2, 4]

        Set <Integer> setA = Arrays.stream(a).boxed().collect(Collectors.toSet());
        Set <Integer> setB = Arrays.stream(b).boxed().collect(Collectors.toSet());

        a = Arrays.stream(a).filter(x->!setB.contains(x)).toArray();
        b = Arrays.stream(b).filter(x->!setA.contains(x)).toArray();

        int [] result = IntStream.concat(Arrays.stream(a), Arrays.stream(b)).toArray();
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        Main m = new Main();
        m.practice3();
    }
}


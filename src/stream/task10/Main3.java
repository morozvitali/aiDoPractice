package stream.task10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main3 {

    public List<Integer> myMapFilter1 () {
        return Arrays.stream(new String [] {"hi", "apple", "go", "banana", "car"})
                .map(String::length)
                .filter(length -> length > 3)
                .collect(Collectors.toList());
    }

    public List<Integer> myMapFilter2 () {
        return Arrays.stream(new int [] {1,2,3,4,5,6})
                .filter(a -> a%2 !=0)
                .map(a->a*a)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<String> myMapFilter3 () {
        return Arrays.stream(new String []{"apple", "banana", "apricot", "cherry", "avocado"})
                .map(String::toLowerCase)
                .filter(a-> a.charAt(0) == 'a')
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public List <Integer> myMapFilter4 () {
        return Arrays.stream(new int [] {3, 5, 10, 14, 15})
                .filter(a->a%5 ==0)
                .map(a->a*2)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<String> myMapFilter5 () {
        return Arrays.stream(new String [] {"java", "code", "home", "sun", "snow"})
                .filter(w->w.length() == 4)
                .map(w->w.substring(0,1).toUpperCase() + w.substring(1).toLowerCase())
                .collect(Collectors.toList());
    }

    public List <Integer> myMapList6 () {
        return Arrays.stream(new int [] {2, 2, 4, 6, 3, 4})
                .filter(a->a%2 == 0)
                .map(a->a*a)
                .distinct()
                .boxed()
                .collect(Collectors.toList());
    }
}



package stream3.task4_;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main1 {
    public List <Integer> practice1 () {
        return List.of(10,70,20,90,55,30).stream()
                .filter(a->a>50)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }




}

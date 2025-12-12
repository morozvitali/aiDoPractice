package stream3.task4_;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main1 {
    public List <Integer> practice1 () {
        return List.of(10,70,20,90,55,30).stream()
                .filter(a->a>50)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        Collections::unmodifiableList));
    }

    public String practice2 () {
        return Stream.of("Dog", "Cat", "Mister", "Thea", "Dinner", "Architector")
                .filter(w->w.length() > 6)
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        list-> list.isEmpty() ? "empty" : list.get(0)));
    }






}

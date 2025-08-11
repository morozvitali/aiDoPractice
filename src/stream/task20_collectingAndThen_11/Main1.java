package stream.task20_collectingAndThen_11;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main1 {
    public List <String> practice1 () {
        List<String> data = List.of("apple", "car",
                "banana", "hi", "cherry");
        return data.stream().filter(w->w.length()>4).collect(Collectors.collectingAndThen( Collectors.toList(), a-> Collections.unmodifiableList(a)));
    }

    public void practice2 () {
        List<Integer> data = List.of(3, 9, 2, 4, 6, 7, 12);



    }

}

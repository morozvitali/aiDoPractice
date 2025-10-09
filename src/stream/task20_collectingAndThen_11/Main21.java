package stream.task20_collectingAndThen_11;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main21 {
    public String practice1 () {
        List<String> list = Stream.of("java", "code", "loop", "sky")
                .filter(w -> w.chars().filter(c -> "aeiou".indexOf(c) >= 0).count() == 2).toList();
        if (list.size() > 1) {
            throw new IllegalStateException(" ");
        }
        return list.get(0);
    }

    public String practice2 () {
        return List.of(1, 2, 3, 4, 5).stream().filter(n->n%2==0).map(n->n*n+"").collect(Collectors.collectingAndThen(Collectors.toList(), list-> String.join(" : ", list)));
    }






}

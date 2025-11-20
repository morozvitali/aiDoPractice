package stream1.task20_collectingAndThen_11;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main22 {
    public String task1 () {
        return Stream.of("java", "code", "loop", "sky").filter(w->w.chars().filter(c->"aeiou".indexOf(c)>=0).count() >2).collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
            if (list.size() !=1) {
                throw new IllegalStateException("no no");
            }
            return list.get(0);
        }));
    }


}

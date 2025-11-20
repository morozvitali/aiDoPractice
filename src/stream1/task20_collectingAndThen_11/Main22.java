package stream1.task20_collectingAndThen_11;

import java.util.Collections;
import java.util.List;
import java.util.Map;
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

public String task2 () {
        return List.of(1, 2, 3, 4, 5).stream().filter(a->a%2==0).map(a->a*a + "").collect(Collectors.collectingAndThen(Collectors.toList(), list-> String.join("; ", list)));
}

public Integer task3 () {
        return Stream.of("java", "code", "loop", "sky").collect(Collectors.collectingAndThen(Collectors.groupingBy(w->w.charAt(w.length()-1)), Map::size));
}

public List <String> task4 () {
        return Stream.of("java", "code", "loop", "sky").collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
}

public Integer task5 () {
        return Stream.of(3, 9, 2, 4, 6, 7, 12).collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
}



}

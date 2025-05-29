package stream.task2;

import java.util.ArrayList;
import java.util.List;

public class Main5 {
    public String myFiltering () {
        List<String> list = List.of("home", "is", "where", "the", "heart", "is");
        return list.stream().reduce((a,b)-> a.length() <= b.length() ? a : b).orElse("");
    }

}

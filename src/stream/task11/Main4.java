package stream.task11;

import java.util.List;
import java.util.stream.Collectors;

public class Main4 {
    public List <String> filtering() {
        List<String> names = List.of
                ("Alice", "Bob", "Anna", "George", "alex", "Amanda");
        return names.stream().filter(a->a.charAt(0) == 'A').collect(Collectors.toList());
    }


}

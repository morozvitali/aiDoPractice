package stream3.task6_;

import java.util.List;
import java.util.stream.Collectors;

public class Main1 {


    public String practice1(List<String> data) {
        return data.stream().filter(w -> w.contains("p"))
                .collect(Collectors.collectingAndThen(Collectors.toList(),
                        list -> {
                            if (list.size() != 1) {
                                throw new IllegalStateException("Expected only one word with 'p'");
                            }
                            return list.get(0);
                        }
                ));
    }

    public List <String> practice2 (List <String> words) {
        return words.stream()
                .filter(w->"aeiou"
                        .chars()
                        .allMatch(c->w.indexOf(c)>=0))
                .toList();
    }





}


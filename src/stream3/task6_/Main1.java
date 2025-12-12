package stream3.task6_;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public void practice3 () {
        List<Long> top10 = new Random().ints(100, -100, 101)
                .mapToObj(String::valueOf)
                .map(Long::valueOf)
                .filter(n->n>0)
                .sorted(Comparator.reverseOrder())
                .limit(10)
                .toList();
    }

    public Integer practice4 () {
        return Stream.of("hi","hello","mango","go","halo","yo")
                .collect(Collectors.groupingBy(w->w.charAt(w.length()-1)))
                .size();
    }



}


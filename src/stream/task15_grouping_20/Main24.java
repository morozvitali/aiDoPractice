package stream.task15_grouping_20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main24 {
    public Long practice1 (String s) {
        return s.chars().mapToObj(Character::toLowerCase).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e->e.getValue()>1).count();
    }

    public String rpactice2 (String s) {
        return Arrays.stream(s.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).map(Map.Entry::getKey).orElse("");
    }

}

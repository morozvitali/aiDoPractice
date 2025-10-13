package stream1.task11_string_formater_goood;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Place1 {


    public void count(List<String> orders) {
        Map<String, Long> cityStats = orders.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        cityStats.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).limit(3).forEach(System.out::println);
    }


}
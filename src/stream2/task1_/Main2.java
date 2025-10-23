package stream2.task1_;

import java.util.List;
import java.util.stream.Collector;

public class Main2 {
    public String practice1 () {
        List<String> list = List.of("Java", "Stream", "API");
        String result = list.stream().collect(Collector.of(
                StringBuilder::new,
                (sb, s) -> sb.append(s).append(" "),
                StringBuilder::append,
                StringBuilder::toString
        ));
        return result;
    }





}

package stream2.task1_;

import java.util.List;
import java.util.stream.Collector;

public class Main1 {


    public void practice1() {
        List<String> list = List.of("java", "Stream", "API");

        String result = list.stream().collect(Collector.of(
                StringBuilder::new,
                (sb, s) -> sb.append(s).append(" "),
                StringBuilder::append,
                StringBuilder::toString
        ));
    }


}

package stream.task3__optional_11;

import java.util.List;
import java.util.Optional;

public class Main8 {
    public int practice1() {
        List<Integer> numbers = List.of(3, 8, 10, 15, 4);
        return numbers.stream().filter(a -> a % 5 == 0).findFirst().orElse(-1);
    }

    public int practice2 () {
        Optional <Integer> value = Optional.of(7);
        return value.map(v->v*2).orElse(-1);
        }


    public String practice3 () {
        Optional <String> value = Optional.of("Helloworld");
        return value.filter(w->w.length() >5).orElse("Short");
    }

    public String practice4 () {
        Optional <String> value = Optional.of("Vitali");
        return value.map(name->"Hello " + name + "!").orElse("Hello, Guest!");
    }


    public void practice5 () {
        List <Integer> list = List.of(1, 2, 3, 4, 5);
        //return list.stream().mapToInt(a->a).max().orElse(-1);
        list.stream().max((a,b)-> a.compareTo(b)).ifPresentOrElse(value -> System.out.println("Max = " + value), ()-> System.out.println("немає значень"));
    }

    public void practice6 () {
        List <Integer> list = List.of(1, 2, 3, 4, 5);
        list.stream().min((a,b)->a < b ? a : b).ifPresentOrElse(value -> System.out.println("min " + value), () -> System.out.println("немає значень"));
    }


}

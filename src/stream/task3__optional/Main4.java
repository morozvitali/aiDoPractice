package stream.task3__optional;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Function;

public class Main4 {
    public void practice1 () {
        List<Integer> numbers = List.of(3, 8, 10, 15, 4);
        int response = numbers.stream().filter(value-> value %5 == 0).findFirst().orElse(-1);
    }

    public void practice2 () {
     Optional<Integer> value = Optional.of(7);
     int response = value.map(i -> i*i).orElse(-1);
    }

    public void practice3 () {
        Optional <String> name = Optional.of("Vitali");
        name.map(w->"hello, " + name)
                .orElse("hello, guest");
    }

    public void practice4 () {
        Optional <String> str = Optional.of("shrt");
                String response = str
                .filter(s -> s.length() > 5)
                .orElse("short");
    }

    public void practice5 () {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        nums.stream().max((a,b)->a.compareTo(b)).ifPresent(System.out::println);
    }

    public void practice6 () {
        Optional<String> email = Optional.of("ADMIN@SITE.COM");
        email.map(s->s.toLowerCase()).filter(e->e.contains(".com"))
                .orElseThrow(()->new IllegalArgumentException("Invalid email"));
    }

    public void practice7 () {
        List<Integer> nums = List.of(5, 2, 9);
        nums.stream().min((a,b) -> a.compareTo(b))
                .ifPresentOrElse(value -> System.out.println("min " + value), () -> System.out.println("empty list"));
    }

    public void practice8 () {
        List<String> words =  List.of("Java", "Spring");
        words.stream().findFirst()
        .map(value -> value.length())
        .ifPresentOrElse(len -> System.out.println("Length is " + len), () -> System.out.println("list values is empty"));
    }

    public void practice9 () {
        Optional <String> name = Optional.of("Ivan");
        name.ifPresentOrElse(value-> System.out.println(value.toUpperCase()), () -> new NoSuchElementException("Name not found"));
    }

    public void practice10 () {
        Optional <String> login = Optional.of("administrator");
        login.map(l->l.startsWith("admin") ? "Admin access" : "User access")
                .orElse("No login");
    }

    public void practice11 () {
        Optional <Integer> number = Optional.of(11);
        number.filter(value->value%2 == 0).map(n->n*2)
                .ifPresentOrElse(value-> System.out.println("double value " + value), () -> System.out.println("empty or not odd"));
    }
}

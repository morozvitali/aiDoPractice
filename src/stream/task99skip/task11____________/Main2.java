package stream.task99skip.task11____________;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main2 {


    public static void main(String[] args) {
        Main2 main2 = new Main2();
        System.out.println(main2.myMapper1());
        System.out.println(main2.myMapper2());
        System.out.println(main2.myMapper3());
        System.out.println(main2.myMapper4());
    }

    public List <String> myMapper1 () {
        List<String> names = List.of
                ("Alice", "Bob", "Anna", "George", "alex", "Amanda");
        return names.stream().filter(a->a.startsWith("A")).collect(Collectors.toList());
    }

    public Long myMapper2 () {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 8);
        return numbers.stream().filter(a -> a%2==0).count();
    }

    public Map<Character, List <String>> myMapper3 () {
        List<String> words = List.of("apple", "banana",
                "apricot", "blueberry", "cherry");
        return words.stream().collect(Collectors.groupingBy(word->word.charAt(0)));
    }

    public Map<String, Integer> myMapper4 () {
        List<String> words = List.of("hi", "apple", "banana");
        return words.stream().collect(Collectors.toMap(a->a, a->a.length()));
    }


}

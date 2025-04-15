package lambda.Task1;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {

    /*
    повертатиме List <String> ,
    а приймтиме List <String> а також Predicate <String> condition
    */


    public static List<String> filteringString(List<String> list, Predicate<String> condition) {
        return list.stream().filter(condition.or(condition).or(condition)).collect(Collectors.toList());
    }

    /*
    викличкаємо predicate
     */

    public static void main(String[] args) {
        filteringString(List.of("apple", "pie", "dog"), s->s.length() > 3 );

    }
}

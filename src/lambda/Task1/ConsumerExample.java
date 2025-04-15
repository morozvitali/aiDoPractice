package lambda.Task1;
import java.util.*;
import java.util.function.Consumer;

public class ConsumerExample {

    /*
    consumer, має метод accept, нічого  не повертає
     */

    public static void consumeNumbers (List <Integer> list, Consumer<Integer> consumer) {
        for (Integer number : list) {
            consumer.accept(number);
        }
    }

    public static void main(String[] args) {

        List <Integer> numbers = Arrays.asList(5,10,15);

        Set <Integer> integerSet = new HashSet<>();
        consumeNumbers(numbers, n-> System.out.println("Print number " + n));
        consumeNumbers(numbers, n-> System.out.println("square " + (n * n)));
        consumeNumbers(numbers, n-> System.out.println("square " + (10 * n)));



        /*
        реалізація дефолтного метода andThen(Consumer <? super T> after)
         */
        Consumer <String> c1 = s-> System.out.println(("First " + s));
        Consumer <String> c2 = s-> System.out.println(("Second " + s));

        Consumer <String> combined = c1.andThen(c2);
        combined.accept("Vitalii");

    }


    /*
    static <T> Consumer<T> identity()
    це статичний метод але він нічого не робить, типу метод заглушки коли потрібно повернути consumer
     */
}

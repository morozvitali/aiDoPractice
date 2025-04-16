package lambda.Task1;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample2 {

    public void myTest (List<String> list, Consumer<String> myConsumer) {

        for (String s : list) {
            myConsumer.accept(s);
        }
    }

    public static void main(String[] args) {
        ConsumerExample2 consumerExample2 = new ConsumerExample2();
        List <String> list = List.of("A", "Баба", "Гала", "Мага");
        consumerExample2.myTest (list, a-> System.out.println("testing consumer: " + a));



        System.out.println("------------------t-e-s-t-i-n-g---a-n-d-T-h-e-n-----------------");
        Consumer <String> co1 = a-> System.out.println("testing and Then 1" + a);
        Consumer <String> co2 = a-> System.out.println("testing and Then 2" + a);


        consumerExample2.myTest (list,co1.andThen(co2));

    }
}

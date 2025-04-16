package lambda.Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class UnaryOperatorExample2 {

    /*
    ЗАДАЧА 1: Замінити всі слова у списку на їх версії без пробілів

    Умова:
    Напиши метод cleanList, який:
    приймає List<String>
    застосовує UnaryOperator<String> до кожного елемента (replaceAll)
    повертає оновлений список


    ЗАДАЧА 2: Підняти всі числа до квадрату
    List<Integer> nums = new ArrayList<>(List.of(2, 3, 4, 5));
    nums.replaceAll(x -> x * x);
    // [4, 9, 16, 25]


    #1 List.Of робить список імьютабл
    #2 Використовуй list.set(i) list.get(i)

    ---------------------------------

    Бонус-завдання:
    Зроби UnaryOperator<Integer>, який:
    залишає парні числа без змін
    а непарні обнуляє
    результат для [1, 2, 3, 4, 5] → [0, 2, 0, 4, 0]

     */

    public List<Integer> squareInListCalculator(List<Integer> list, UnaryOperator<Integer> unaryOperator) {


        // або! list.replaceAll(unaryOperator);

        for (int i = 0; i<list.size(); i++) {
            list.set(i, unaryOperator.apply(list.get(i)));
        }
        return list;
    }


    public List<String> emptySpaceReplacer(List<String> list, UnaryOperator<String> unaryOperator) {
        list.replaceAll(unaryOperator);
        return list;
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A ");
        list.add("BA BA");
        list.add("GA L A");
        list.add("M AGA");
        list.add("A ");
        list.add("A ");
        list.add("A ");

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(11);
        list2.add(111);
        list2.add(2);
        list2.add(1);


        UnaryOperatorExample2 unaryOperatorExample2 = new UnaryOperatorExample2();
        UnaryOperator<String> unaryOperator = a -> a.replaceAll(" ", "");
        System.out.println(unaryOperatorExample2.emptySpaceReplacer(list, unaryOperator));

        UnaryOperator<Integer> integerUnaryOperator = a -> a * a;
        System.out.println(unaryOperatorExample2.squareInListCalculator(list2, integerUnaryOperator));
    }
}


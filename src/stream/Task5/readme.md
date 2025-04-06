    🎯 Тренажер: reduce — Частина 1 (3 задачі)
    ✅ Задача 1: знайти мінімальне число
    int[] numbers = {15, 3, 8, 22, 1, 10};
    Завдання: використай reduce, щоб знайти найменше число.
    
    ✅ Задача 2: об'єднати слова в один рядок, але через кому
    String[] words = {"Java", "Python", "C++"};
    Очікуваний результат: "Java, Python, C++"
    (без коми на початку чи в кінці!)
    
    ✅ Задача 3: знайти число з найбільшою сумою цифр
    int[] numbers = {123, 91, 77, 456, 18};
    
    Наприклад:
    123 → 1+2+3 = 6
    456 → 4+5+6 = 15
    
    Очікуваний результат: 456

package stream.Task5;

import java.util.Arrays;

public class Main3 {
public int myReduce1() {
return Arrays.stream(new int[]{15, 3, 8, 22, 1, 10})
.reduce(Integer.MIN_VALUE, (a, b) -> a + b);
}

    public String myReduce2() {
        return Arrays.stream(new String[]{"Java", "Python", "C++" })
                .reduce((a, b) -> a + ", " + b)
                .orElse("");
    }

    public int myReduce3() {
        return Arrays.stream(new int []{23, 91, 77, 456, 18)
        .reduce(0, (a,b) -> calc(a) < calc(b) ? a : b)
    }

    public int calc (int number) {
        int sum = 0;
            while (number > 0) {
                sum += number = number%10;}
            return sum;
    }
}

    

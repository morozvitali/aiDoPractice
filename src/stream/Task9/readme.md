Тренажер map: Частина 1 (3 прості задачі)
✅ Задача 1: Знайти довжини слів

String[] words = {"java", "python", "go"};
Очікуваний результат:

4
6
2

Підказка: map(word -> word.length())

✅ Задача 2: Піднести числа до квадрату

int[] numbers = {2, 3, 4};
Очікуваний результат:

Копіювати
Редагувати
4
9
16
Підказка: .map(n -> n * n)

✅ Задача 3: Зробити всі слова великими літерами

String[] words = {"apple", "banana", "kiwi"};
Очікуваний результат:

APPLE
BANANA
KIWI
Підказка: map(String::toUpperCase)

💡 Створи по одному методу на кожну задачу. 



    public void myMap1 () {
        Arrays.stream(new String [] {"java", "python", "go"})
                .map(a->a.length())
                .forEach(System.out::println);
    }

    public void myMap2 () {
        Arrays.stream(new int [] {2,3,4,5})
                .map(a->a*a)
                .forEach(System.out::println);
    }

    public void myMap3 () {
        Arrays.stream(new String [] {"apple", "banana", "kiwi"})
                .map(a->a.toUpperCase())
                .forEach(System.out::println);
    }
}

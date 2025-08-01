🌊 Друга хвиля: groupingBy, counting, 
mapping, partitioningBy

✅ Завдання 1: Згрупуй слова за довжиною 
і зроби їх великими літерами

String[] words = {"apple", "banana", 
"dog", "kiwi", "plum"};
Очікуваний результат:

{
3=[DOG],
4=[KIWI, PLUM],
5=[APPLE],
6=[BANANA]
}
📌 Тип: Map<Integer, List<String>>

🧠 Підказка: groupingBy(..., 
mapping(..., toList()))

----------------------------------------------------

✅ Завдання 2: Порахуй кількість 
слів для кожної довжини, але тільки
якщо слово містить голосну

    String[] words = {"apple", "banana",
        "dog", "kiwi", "plum"};
Очікуваний результат:

{
5=1,
6=1,
2=1
}

📌 Тип: Map<Integer, Long>
🧠 Підказка: фільтр на countVowels > 0, 
потім groupingBy(..., 
counting())

    public Map <Integer, Long> practice2 () {
        String[] words = {"apple", "banana",
                "dog", "kiwi", "plum"};
        return Arrays.stream(words).filter(w->w.chars().anyMatch(c->"aeiou".indexOf(c) >=0)).collect(Collectors.groupingBy(w->w.length(), Collectors.counting()));
    }


return Arrays.stream(words)
.filter(b-> b
.chars()
.map(c -> (char) c)
.filter(ch -> "aeiou"
.indexOf(ch) >= 0).findAny().isPresent())
.collect(Collectors
.groupingBy(a->a.length(), Collectors.counting()));

-------------------------------------------------------

✅ Завдання 3: Розділи слова на 2 групи —
ті, що містять голосну, і ті, що ні

String[] words = {"apple", "sky",
"banana", "dry", "orange"};
Очікуваний результат:

{
true=[apple, banana, orange],
false=[sky, dry]
}

📌 Тип: Map<Boolean, List<String>>
🧠 Підказка: Collectors.partitioningBy(...)

-----------------------------------------------------

✅ Завдання 4: Створи мапу:
довжина слова → кількість
слів із такою довжиною,
що починаються на голосну

String[] words = {"apple", "banana",
"orange", "umbrella",
"ant", "dog", "egg"};
Очікуваний результат:

{
3=1,
5=2,
6=1,
8=1
}

📌 Тип: Map<Integer, Long>
🧠 Підказка: перевірка startsWith(...),
groupingBy(length, counting())

        String[] words = {"apple", "banana",
                "orange", "umbrella",
                "ant", "dog", "egg"};
        Arrays.stream(words)
.filter(word->"aeiou"
.indexOf(word.charAt(0)>=0)
.count()>0)
.collect(Collectors
.groupingBy(a->a.length(), 
Collectors.counting()));

або, лаконічніше
Set<Character> vowels = Set .of('a', 'e', 'i', 'o', 'u');
.filter(word -> vowels.contains(Character.
toLowerCase(word.charAt(0))))

------------------------------------------

✅ Задача 5 : Знайди виняткове число (Outlier)

📋 Умова:
У тебе є масив цілих чисел. Усі числа в цьому масиві або 
парні, або непарні — окрім одного. Знайди і поверни це
виняткове число. Масив гарантовано містить щонайменше 
3 елементи.

🧠 Підказка:
Використай partitioningBy, щоб розділити числа
на парні та непарні.
У якій групі лише одне число — це і є outlier.
Поверни його.

📦 Вхід:
int[] arr = {2, 4, 6, 8, 10, 3}; 
// одне непарне серед парних

[2, 4, 0, 100, 4, 11, 2602, 36] -->  11
(the only odd number)
[160, 3, 1719, 19, 11, 13, -21] --> 160 
(the only even number)

🎯 Очікуваний результат: 3


✅ Рішення:
import java.util.*;
import java.util.stream.*;

public class OutlierFinder {
public static int find(int[] integers) {

Map<Boolean, List<Integer>> map = 
Arrays.stream(integers)
.boxed()
.collect(Collectors
.partitioningBy(n -> n % 2 == 0));

return map.get(true).size() == 1
                ? map.get(true).get(0)
                : map.get(false).get(0);
    }
}
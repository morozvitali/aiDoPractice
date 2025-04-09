🌊 Друга хвиля: groupingBy, counting, mapping, partitioningBy

✅ Завдання 1: Згрупуй слова за довжиною і зроби їх великими літерами

String[] words = {"apple", "banana", "dog", "kiwi", "plum"};
Очікуваний результат:

{
3=[DOG],
4=[KIWI, PLUM],
5=[APPLE],
6=[BANANA]
}
📌 Тип: Map<Integer, List<String>>

🧠 Підказка: groupingBy(..., mapping(..., toList()))

-----------------------------------------------------------------------

✅ Завдання 2: Порахуй кількість слів для кожної довжини, але тільки
якщо слово містить голосну

String[] words = {};
Очікуваний результат:

{
5=1,
6=1,
6=1
}

📌 Тип: Map<Integer, Long>
🧠 Підказка: фільтр на countVowels > 0, потім groupingBy(..., counting())

---------------------------------------------------------------------------

✅ Завдання 3: Розділи слова на 2 групи — ті, що містять голосну, і ті, що ні

String[] words = {"apple", "sky", "banana", "dry", "orange"};
Очікуваний результат:

{
true=[apple, banana, orange],
false=[sky, dry]
}

📌 Тип: Map<Boolean, List<String>>
🧠 Підказка: Collectors.partitioningBy(...)

---------------------------------------------------------------------------

✅ Завдання 4: Створи мапу: довжина слова → кількість слів із такою довжиною, що починаються на голосну

String[] words = {"apple", "banana", "orange", "umbrella",
"ant", "dog", "egg"};
Очікуваний результат:

{
3=1,
5=2,
6=1,
8=1
}

📌 Тип: Map<Integer, Long>
🧠 Підказка: перевірка startsWith(...), groupingBy(length, counting())


    public Map<Integer, List<String>> myGrouping1() {

        return Arrays.stream(new String[]{"apple", "banana", "dog", "kiwi", "plum"})
                .map(a -> a.toUpperCase())
                .collect(Collectors.groupingBy(a -> a.length()));
    }

    public Map<Integer, Long> myGrouping2() {
        return Arrays.stream(new String [] {"apple", "sky", "banana", "dry", "orange"})
                .filter(a->a.chars().anyMatch(c->"aeiou".indexOf(c)>=0))
                .collect(Collectors.groupingBy(a-> a.length(), Collectors.counting()));
    }

    public Map <Boolean, List <String>> myGrouping3 () {
        return Arrays.stream(new String [] {"apple", "sky", "banana", "dry", "orange"})
                .collect(Collectors.partitioningBy(a->isContains(a)));
    }

    public boolean isContains (String s) {
        return s.toLowerCase().chars().anyMatch(c->"aeiou".indexOf(c)>=0);
    }

    public Map <Integer, Long> myGrouping4 () {
        return Arrays.stream(new String [] {"apple", "banana", "orange", "umbrella",
                "ant", "dog", "egg"})
                .filter(a->a.chars().anyMatch(c->"aeiou".indexOf(c) == 0))
                .collect(Collectors.toMap(a->a.length(), Collectors.counting()));
    }
}

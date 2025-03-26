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

‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️

✅ Завдання 2: Порахуй кількість слів для кожної довжини, але тільки
якщо слово містить голосну

String[] words = {"apple", "sky", "banana", "dry", "orange"};
Очікуваний результат:

{
5=1,
6=1,
6=1
}

📌 Тип: Map<Integer, Long>
🧠 Підказка: фільтр на countVowels > 0, потім groupingBy(..., counting())

⚽️⚽️⚽️⚽️⚽️⚽️⚽️⚽️⚽️⚽️⚽️⚽️⚽️⚽️⚽️⚽️⚽️⚽️⚽️⚽️⚽️⚽️⚽️⚽️⚽️

✅ Завдання 3: Розділи слова на 2 групи — ті, що містять голосну, і ті, що ні
java
Копіювати
Редагувати
String[] words = {"apple", "sky", "banana", "dry", "orange"};
Очікуваний результат:

{
true=[apple, banana, orange],
false=[sky, dry]
}

📌 Тип: Map<Boolean, List<String>>
🧠 Підказка: Collectors.partitioningBy(...)

‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍❄️‍

✅ Завдання 4: Створи мапу: довжина слова → кількість
слів із такою довжиною, що починаються на голосну
java
Копіювати
Редагувати
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
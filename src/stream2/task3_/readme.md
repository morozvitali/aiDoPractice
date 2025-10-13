🧩 Модуль №3 — takeWhile() і dropWhile()

📘 Мета:
навчитися бачити різницю між ними та filter(),
зрозуміти, чому вони зупиняються або “відтинають” потік,
і як це використати для практичної логіки (до першого помилкового елемента, до зміни порядку, тощо).

✅ Завдання 1 — takeWhile: простий приклад

📋 Умова:
Виведи числа, поки вони менші за 5.

Stream.of(1, 2, 3, 6, 2, 1)
.takeWhile(n -> n < 5)
.forEach(System.out::print);


📤 Очікуване: 123
(бо коли дійшли до 6, takeWhile зупинив потік)

✅ Завдання 2 — dropWhile: простий приклад

📋 Умова:
Пропусти числа, поки вони менші за 5.

Stream.of(1, 2, 3, 6, 2, 1)
.dropWhile(n -> n < 5)
.forEach(System.out::print);


📤 Очікуване: 621
(бо поки <5 — пропускає, як тільки 6 — починає обробку)

✅ Завдання 3 — Порівняння з filter()

📋 Умова:
Порівняй результати трьох потоків:

Stream.of(1, 2, 3, 6, 2, 1)
.filter(n -> n < 5)
.forEach(System.out::print); // 12321


🧠 Висновок:

filter() перевіряє всі елементи;

takeWhile() зупиняється після першого порушення умови.

✅ Завдання 4 — takeWhile для відсортованого списку

📋 Умова:
Порахуй скільки елементів іде підряд у зростанні.

List<Integer> nums = List.of(1, 2, 3, 5, 2, 6, 7);
List<Integer> rising = nums.stream()
.takeWhile(new int[]{Integer.MIN_VALUE}::equals) // 🤔 неправильний варіант, дивись нижче


🛠 Правильніше:

AtomicInteger prev = new AtomicInteger(0);
List<Integer> result = nums.stream()
.takeWhile(n -> {
boolean ok = n > prev.get();
prev.set(n);
return ok;
})
.toList();

System.out.println(result); // [1, 2, 3, 5]

✅ Завдання 5 — dropWhile для пропуску “заголовків”

📋 Умова:
Пропусти порожні рядки, поки не почався контент.

List<String> lines = List.of("", "", "Hello", "World", "!");
List<String> content = lines.stream()
.dropWhile(String::isEmpty)
.toList();

System.out.println(content); // [Hello, World, !]

✅ Завдання 6 — takeWhile для аналізу температури

📋 Умова:
Є температури за день. Виведи лише “ранкові” значення (до першого >20°C).

List<Integer> temps = List.of(15, 16, 18, 21, 19, 17);

List<Integer> morning = temps.stream()
.takeWhile(t -> t <= 20)
.toList();

System.out.println(morning); // [15, 16, 18]

✅ Завдання 7 — dropWhile для очищення нулів

📋 Умова:
Пропусти нулі на початку.

List<Integer> nums = List.of(0, 0, 0, 4, 5, 0, 6);

List<Integer> clean = nums.stream()
.dropWhile(n -> n == 0)
.toList();

System.out.println(clean); // [4, 5, 0, 6]

✅ Завдання 8 — takeWhile для текстових даних

📋 Умова:
Зупинись, коли зустрінеш слово "STOP".

List<String> words = List.of("start", "read", "analyze", "STOP", "finalize");

List<String> beforeStop = words.stream()
.takeWhile(w -> !w.equals("STOP"))
.toList();

System.out.println(beforeStop); // [start, read, analyze]

✅ Завдання 9 — dropWhile у поєднанні з map()

📋 Умова:
Пропусти від’ємні числа, потім перетвори решту в абсолютні.

List<Integer> nums = List.of(-3, -2, -1, 0, 5, -4, 7);

List<Integer> abs = nums.stream()
.dropWhile(n -> n < 0)
.map(Math::abs)
.toList();

System.out.println(abs); // [0, 5, 4, 7]

✅ Завдання 10 — Комбіноване завдання

🎯 Мета: використати takeWhile + dropWhile разом.

📋 Умова:
Є список температур.

Пропусти всі до початку підйому (dropWhile(t < 15)).

Потім бери, поки не буде спека (takeWhile(t < 30)).

List<Integer> temps = List.of(10, 12, 15, 20, 25, 30, 32, 28);

List<Integer> mild = temps.stream()
.dropWhile(t -> t < 15)
.takeWhile(t -> t < 30)
.toList();

System.out.println(mild); // [15, 20, 25]

🧠 Різниця між ними в трьох словах:
Метод	Дія	Зупинка
takeWhile()	бере поки true	зупиняється на першому false
dropWhile()	пропускає поки true	починає з першого false
filter()	перевіряє всі елементи	не зупиняється ніколи
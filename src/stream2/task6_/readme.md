⚙️ Модуль №6 — Collectors.toMap() + mergeFunction

📘 Мета:
навчитися створювати Map через Stream;
розібратися, чому виникають колізії ключів;
тренувати merge-функції (конкатенація, підсумовування, 
вибір максимального тощо).

✅ Завдання 1 — Базова мапа без колізій

📋 Умова:
Зроби Map з імен → довжина імені.

    public void practice1 () {
        List<String> names = List.of("Bob", "Anna", "John");
        Map<String, Integer> map = names.stream().collect(Collectors.toMap(
                name -> name,
                String::length
        ));
        System.out.println(map);
    }

System.out.println(map); // {Bob=3, Anna=4, John=4}

🧠 Все просто — унікальні ключі.

✅ Завдання 2 — Колізія ключів без mergeFunction

📋 Умова:
Спробуй створити мапу за першою літерою імені.

    public void practice2() {
        List<String> names = List.of("Bob", "Bill", "Anna");
        Map<Character, String> map = names.stream()
                .collect(Collectors.toMap(name -> name.charAt(0),
                        name -> name));
    }


💥 Результат: IllegalStateException: Duplicate key B

🧠 Колізії — бо двоє на “B”.

✅ Завдання 3 — Розв’язання колізій конкатенацією

📋 Умова:
Якщо ключ повторюється — з’єднати значення комою.

    public void pracvtice3() {
        List<String> names = List.of("Bob", "Bill", "Anna");
        Map <Character, String> map = names.stream()
                .collect(Collectors.toMap(name -> name.charAt(0),
                        name -> name,
                        (v1,v2)->v1 + ", " + v2));
        System.out.println(map);
    }
// {A=Anna, B=Bob, Bill}

✅ Завдання 4 — Вибір найкоротшого значення при колізії

📋 Умова:
Якщо ключ повторюється, залиш коротше ім’я.

    public void practice4() {
        List<String> names = List.of("Bob", "Bill", "Benjamin");
        Map<Character, String> map = names.stream()
                .collect(Collectors.toMap(
                        s -> s.charAt(0),
                        s -> s,
                        (a, b) -> a.length() <= b.length() ? a : b
                ));
        System.out.println(map);
    }
// {B=Bob}

✅ Завдання 5 — Підрахунок повторів

🎯 Мета: створити частотну мапу.

    public void practice5 () {
        List<String> fruits = List.of("apple", "pear", "apple", "banana", "pear");
        Map<String, Long> freq = fruits.stream().collect(Collectors.toMap(
                f -> f,
                f->1L,
                Long::sum
                ));
        System.out.println(freq);
    }
// {banana=1, apple=2, pear=2}

✅ Завдання 6 — Групування по першій літері + список

🎯 Мета: створити Map<Character, List<String>> без groupingBy.

    public void practice6 () {
        List<String> words = List.of("cat", "cow", "dog", "duck");
        Map <Character, List<String>> map = words.stream()
                .collect(Collectors.toMap(
                        w->w.charAt(0),
                        w->new ArrayList<>(List.of(w)),
                        (list1, list2) -> {list1.addAll(list2); return list1;}
                ));
        System.out.println(map);
    }
// {c=[cat, cow], d=[dog, duck]}

✅ Завдання 7 — Злиття Map через toMap()

🎯 Мета: перетворити список Map у одну велику Map.

    public void practice7() {
        List<Map<String, Integer>> maps = List.of(
                Map.of("A", 1, "B", 2),
                Map.of("B", 3, "C", 4)
        );


        Map<String, Integer> merged = maps.stream()
                .flatMap(m -> m.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        Integer::sum
                ));
        System.out.println(merged);
    }

// {A=1, B=5, C=4}

✅ Завдання 8 — Підрахунок сум за ключем

🎯 Мета: схоже до “groupingBy + summingInt”, але вручну.

    public void practice8() {
        List<String> items = List.of("apple", "apple", "pear", "apple", "pear");
        Map<String, Integer> result = items.stream()
                .collect(Collectors.toMap(
                        s -> s,
                        s -> 1,
                        Integer::sum
                ));
        System.out.println(result);
    }
// {apple=3, pear=2}

✅ Завдання 9 — Злиття і форматування результатів

🎯 Мета: об’єднати значення у форматі “name(length)”.

List<String> words = List.of("java", "jungle", "joy");

Map<Character, String> result = words.stream()
.collect(Collectors.toMap(
w -> w.charAt(0),
w -> w + "(" + w.length() + ")",
(a, b) -> a + "; " + b
));

System.out.println(result);
// {j=java(4); jungle(6); joy(3)}

✅ Завдання 10 — Комбіноване: слова → групи → списки без дублікатів

📋 Умова:
Створи мапу, де ключ — перша літера,
значення — унікальні слова у списку.

    public void practice10 () {
        List<String> words = List.of("apple", "apricot", "banana", "blueberry", "apple");
        Map <Character, Set<String>> map = words.stream()
                .collect(Collectors.toMap(
                        w -> w.charAt(0),
                        w -> new HashSet<>(Set.of(w)),
                        (set1, set2) -> { set1.addAll(set2); return set1; } 
                ));
    }

// {a=[apple, apricot], b=[banana, blueberry]}

💡 Підсумок
Варіант mergeFunction	Що робить
(a, b) -> a + ", " + b	З’єднує рядки
Integer::sum	Підсумовує
(a, b) -> a.length() < b.length() ? a : b	Вибирає коротший
(l1, l2) -> { l1.addAll(l2); return l1; }	Об’єднує списки
(s1, s2) -> { s1.addAll(s2); return s1; }	Об’єднує множини

🧠 Порада:
toMap() — найкраще місце для тренування мислення “ключ → дія при конфлікті”.
Коли навчитеся комфортно писати merge-функції, розуміння Stream API вийде на професійний рівень.



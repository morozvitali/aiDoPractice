🎯 Завдання: sorted
Твоя місія — написати метод, який:

Має список слів
Вибирає тільки ті, що довші за 3 літери
Сортує за:
спочатку довжиною слова
потім — в алфавітному порядку
Повертає список

📥 Вхід:
List<String> words = List.of("sun", "banana", "kiwi",
"cherry", "apple", "tea", "pear");

📤 Результат:
[kiwi, pear, apple, banana, cherry]


*ੈ✩‧₊˚༺☆༻*ੈ✩‧₊˚ ੈ✩‧₊˚༺☆༻*ੈ✩‧₊˚
꒷꒦꒷꒦꒷꒦꒷꒦꒷꒦꒷꒦꒷꒦꒷꒦꒷꒷꒦꒷꒦꒷꒦꒷꒦꒷꒦꒷꒦꒷꒦꒷꒦꒷
╰┈➤ ʜɪ! ɪ’ᴍ (your name) ࿐*⁀➷ ⋆ ˚｡⋆୨୧˚
✿𓆉︎✿𓆉︎✿𓆉︎✿𓆉︎
⋆˚✿˖°𝟺ʟɪғᴇʀ: (bffs name) 🫧𓇼𓏲*ੈ✩‧₊˚
⋆˚🐾˖° ɪ ᴅᴏ (sport u do) °❀⋆.ೃ࿔*:･⋆ ˚ ʚɞ
✮ ⋆ ˚｡𖦹 ⋆｡°✩ ✮ ⋆ ˚｡𖦹 ⋆｡°✩ ✮ ⋆ ˚｡𖦹 ⋆｡°✩
༄ ғᴀᴠᴏʀɪᴛᴇ sᴏɴɢ ɪs (fav song) ✦
➪ ғᴀᴠᴏʀɪᴛᴇ ғᴏᴏᴅ ɪs (fav food) •ᴗ•
⋆.ೃ࿔*:･ ᴛʜᴀɴᴋ ʏᴏᴜ ғᴏʀ ʀᴇᴀᴅɪɴɢ! ʙʏᴇᴇ ୨୧
-ˋˏ✄——————————————————





💡 Підказка:
.sorted(Comparator.comparing(String::length)
.thenComparing(Comparator.naturalOrder()))

🔧 Початковий шаблон:
public List<String> sortWordsSmart(List<String> words) {
return words.stream()
.filter(w -> w.length() > 3)
.sorted(
Comparator.comparing(String::length)
.thenComparing(Comparator.naturalOrder())
)
.collect(Collectors.toList());
}


?--?--?--?--?--?--?--?--THEORY--?--?--?--?--?--?--?--?


🧠 Тема: sorted() — сортування в Stream API
📌 Що це таке?
Метод sorted() дозволяє відсортувати потік елементів.

🔹 Варіант 1: Сортування за замовчуванням (natural order)

List.of(3, 1, 4, 2)
.stream()
.sorted()
.toList();   // [1, 2, 3, 4]
🔹 Варіант 2: Зі своїм компаратором

.sorted(Comparator.reverseOrder())     // за спаданням
.sorted(Comparator.comparing(String::length)) // за довжиною рядка
🔹 Варіант 3: Комплексне сортування

Comparator.comparing(Person::getAge)
.thenComparing(Person::getName)


🧠 Теорія: sorted() — що, коли і навіщо
✅ 1. sorted() без параметрів
Сортує елементи в природному порядку
(для String — алфавітно, для Integer — по зростанню)

Stream.of("pear", "apple", "banana")
.sorted()
.toList();  // [apple, banana, pear]

✅ 2. sorted(Comparator) — з компаратором
Дозволяє кастомізувати логіку сортування

🔹 За спаданням:
.sorted(Comparator.reverseOrder())

🔹 За довжиною рядка:
.sorted(Comparator.comparing(String::length))

🔹 За довжиною, потім — алфавітно:
.sorted(Comparator
.comparing(String::length)
.thenComparing(Comparator.naturalOrder()))
📌 thenComparing(...) означає: “якщо значення однакові — сортуємо далі за другим критерієм”

🧊 Аналогія:
Уяви, що ти сортуєш список студентів:
Спочатку — за курсом
Якщо студенти на одному курсі — за прізвищем

.sorted(Comparator
.comparing(Student::getCourse)
.thenComparing(Student::getLastName))
⏱ Що важливо:
Сортування не змінює оригінальний список

Сортування працює на основі стріму, результат — новий список

🔁 Підсумок по теорії sorted():
Метод	Опис
sorted()	Природний порядок
sorted(Comparator.reverseOrder())	За спаданням
sorted(Comparator.comparing(...))	Сортування за певним полем
.thenComparing(...)	Додаткове сортування, якщо рівні
🧪 А тепер — бери теорію й застосуй на практиці.
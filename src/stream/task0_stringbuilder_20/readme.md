Завдання 1
-
Умова: Створіть StringBuilder зі словом "Hello", 
-
додайте в кінець " World", а потім виведіть результат.
-
public class Task1 {

public static void main(String[] args) {
StringBuilder sb = new StringBuilder("Hello");
sb.append(" World");
System.out.println(sb); // Hello World
}
}
Пояснення:

.append() додає текст у кінець.

Після виклику append(" World") вміст змінюється напряму, без створення нового об’єкта (на відміну від String).

Завдання 2
-
Умова: Створіть StringBuilder зі словом "Java", 
-
вставте в середину " cool " і виведіть результат.
-
📌 Підказка: метод .insert(int offset, String str)

public class Task2 {
public static void main(String[] args) {
StringBuilder sb = new StringBuilder("Java");
sb.insert(2, " cool ");
System.out.println(sb); // Ja cool va
}
}
Пояснення:

.insert(index, text) вставляє текст у задану позицію,
не видаляючи наявний.

У нашому випадку "Java" → "Ja" + " cool " + "va".

Завдання 3
-
Умова: Є StringBuilder зі словом "abcdef". 
-
Видаліть з нього літери з індексів 2 по 4 включно.
-
📌 Підказка: метод .delete(start, end)

Пояснення:
.delete(start, end) видаляє символи від start включно і до end невключно.
Тобто .delete(2, 5) видалить символи з індексів 2, 3, 4 (c, d, e).


Завдання 4
-
Умова: Є StringBuilder зі словом "level". 
Переверніть його (reverse) і виведіть результат.
-
public class Task4 {
public static void main(String[] args) {
StringBuilder sb = new StringBuilder("level");
sb.reverse();
System.out.println(sb); // level
}
}
Пояснення:

.reverse() розвертає рядок навпаки.

У нашому випадку "level" симетричне, тому результат той самий, але з іншим словом, наприклад "java" → "avaj".

Завдання 5
-
Умова: Є StringBuilder зі словом "orange". 
Замініть літери з індексу 2 по 5 на "X".

StringBuilder sb = new StringBuilder("orange");
sb.replace(2, 5, "X");
System.out.println(sb); // orXe
}
}
Пояснення:

.replace(start, end, text) замінює ділянку від start включно до end невключно.

"orange" → індекси 2..4 це "a", "n", "g" — вони замінені на "X".

Завдання 6
-
Умова: Створіть StringBuilder зі словом "123". 
Використайте .append() кілька разів, щоб отримати "123456".

StringBuilder sb = new StringBuilder("123");
sb.append("4").append("5").append("6");
System.out.println(sb); // 123456
}
}
Пояснення:

.append() можна викликати ланцюжком (method chaining).

Після кожного виклику об'єкт не створюється заново — змінюється поточний.

Завдання 7
-
Умова: Є StringBuilder зі словом "sunshine". 
Вставте "___" після третьої літери.
-
public class Task7 {
public static void main(String[] args) {
StringBuilder sb = new StringBuilder("sunshine");
sb.insert(3, "___");
System.out.println(sb); // sun___shine
}
}
Пояснення:

.insert(index, text) вставляє новий текст перед символом із цим індексом.

Індекс 3 — це після літер "sun".

Завдання 8
-
Умова: Є StringBuilder зі словом "ABCDEFG". 
Видаліть усі непарні індекси, щоб залишилися 
лише букви на парних позиціях.
-
public class Task8 {
public static void main(String[] args) {
StringBuilder sb = new StringBuilder("ABCDEFG");
for (int i = 1; i < sb.length(); i++) {
sb.deleteCharAt(i);
}
System.out.println(sb); // ACEG?  (Буде помилка!)
}
}

Пояснення та виправлення:
Якщо видаляти зліва направо, індекси зміщуються, 
і ми пропускаємо символи.
Правильний спосіб — видаляти з кінця:

public class Task8 {
public static void main(String[] args) {
StringBuilder sb = new StringBuilder("ABCDEFG");
for (int i = sb.length() - 1; i >= 0; i--) {
if (i % 2 != 0) {
sb.deleteCharAt(i);
}
}
System.out.println(sb); // ACEG
}
}

Завдання 9
-
Умова: Створіть метод, який приймає String 
і повертає цей рядок у зворотному порядку, 
використовуючи StringBuilder.

public class Task9 {
public static String reverseString(String input) {
return new StringBuilder(input).reverse().toString();
}

    public static void main(String[] args) {
        System.out.println(reverseString("Java")); // avaj
    }
}
Пояснення:

Тут ми створюємо StringBuilder із рядка, викликаємо .reverse(), а потім перетворюємо назад у String через .toString().

Завдання 10
-
Умова: Є StringBuilder зі словом "abracadabra".
Замініть усі 'a' на '*',
використовуючи .setCharAt() у циклі.

public class Task10 {
public static void main(String[] args) {
StringBuilder sb = new StringBuilder("abracadabra");
for (int i = 0; i < sb.length(); i++) {
if (sb.charAt(i) == 'a') {
sb.setCharAt(i, '*');
}
}
System.out.println(sb); // *br*c*d*br*
}
}

Пояснення:
.setCharAt(index, char) змінює конкретний символ.

Ми перебираємо кожен символ, і якщо він 'a' — замінюємо на '*'.


Завдання 11 Комбінація insert + delete + append
-
Створити sb, 
знайти індекс "_"
видалити цей знак за індексом
вставити на його місце пробіл
додати і кінці !!!

   StringBuilder sb = new StringBuilder("hello_world");
   int underscoreIndex = sb.indexOf("_");
   sb.deleteCharAt(underscoreIndex);      // прибираємо _
   sb.insert(underscoreIndex, " ");       // додаємо пробіл
   sb.append("!!!");                      // додаємо кінець
   System.out.println(sb); // hello world!!!
   }
   }
   Пояснення:

.indexOf() знаходить позицію _.
.deleteCharAt() прибирає символ.
.insert() вставляє пробіл на це місце.
.append() додає кінець.

Завдання 12 Реверс частини рядка
-

створити sb за стрінгом "abcdefg"
вирізати частину = part з 2-6 (6 не включно) символи
зробити реверс цього фрагменту
заміни в первинному sb частину замість вирізаної на part 

   public class Task2 {
   public static void main(String[] args) {
   StringBuilder sb = new StringBuilder("abcdefg");
   String part = sb.substring(2, 6);       // "cdef"
   String reversed = new StringBuilder(part).reverse().toString();
   sb.replace(2, 6, reversed);             // замінюємо на "fedc"
   System.out.println(sb); // abfedcg
   }
   }
   Пояснення:

.substring() забирає частину, яку хочемо розвернути.
Створюємо новий StringBuilder з цієї частини і .reverse().
.replace() підміняє шматок на розвернуту версію.

Завдання 13 Замінити всі цифри на #
-
   StringBuilder sb = new StringBuilder("Tel: 123-456-789");
   for (int i = 0; i < sb.length(); i++) {
   if (Character.isDigit(sb.charAt(i))) {
   sb.setCharAt(i, '#');
   }
   }
   System.out.println(sb); // Tel: ###-###-###
   }
   }
   Пояснення:

Character.isDigit() перевіряє, чи символ — цифра.

.setCharAt() міняє її на #.

Завдання 14 Переставити слова місцями
-

   StringBuilder sb = new StringBuilder("Java is cool");
   String firstWord = sb.substring(0, 4);  // Java
   sb.delete(0, 4);                        // видаляємо "Java"
   if (sb.charAt(0) == ' ') {              // прибираємо пробіл
   sb.deleteCharAt(0);
   }
   sb.append(" ").append(firstWord);       // додаємо Java у кінець
   System.out.println(sb); // is cool Java
   }
   }
   Пояснення:

.substring() зберігає перше слово.
.delete() прибирає його з початку.
.deleteCharAt(0) прибирає початковий пробіл.
.append() додає слово в кінець.

Завдання 15 Додати нумерацію в список
-
       public class Task5 {
       public static void main(String[] args) {
       StringBuilder sb = new StringBuilder("apple\nbanana\ncherry");
       int counter = 1;
       sb.insert(0, counter++ + ". ");

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '\n') {
                sb.insert(i + 1, counter++ + ". ");
            }
        }
        
        System.out.println(sb);
        /*
        1. apple
        2. banana
        3. cherry
        */
   }
   }
   Пояснення:

Спочатку вставляємо нумерацію перед першим словом.
У циклі шукаємо \n і вставляємо нумерацію після нього.

Завдання 16 Подвійне вставлення та заміна
-
       public class Task6 {
       public static void main(String[] args) {
       StringBuilder sb = new StringBuilder("Winter");
       sb.insert(sb.length(), " cold");       
    // додаємо " cold"
       int start = sb.indexOf("cold");
       sb.replace(start, start + 4, "warm");  
    // замінюємо "cold" на "warm"
       sb.insert(0, "Hot ");                  
    // додаємо "Hot " на початок
       System.out.println(sb); // Hot Winter warm
       }
       }
   Пояснення:

.insert(sb.length(), " cold") вставляє в кінець.
.replace() змінює слово.
.insert(0, "Hot ") ставить текст на початок.

Завдання 17 Побудувати рядок із масиву
-

       String[] colors = {"red", "green", "blue"};
       StringBuilder sb = new StringBuilder();

        for (int i = 0; i < colors.length; i++) {
            sb.append(colors[i]);
            if (i < colors.length - 1) {
                sb.append("-");
            }
        }
        
        System.out.println(sb); // red-green-blue
   }
   }
   Пояснення:

У циклі додаємо елемент і, якщо він не останній, ставимо "-".
Це типова задача побудови рядка через StringBuilder.

Завдання 18 Зашифрувати текст (зсув символів на +1)
-
       public class Task1Hard {
       public static void main(String[] args) {
       StringBuilder sb = new StringBuilder("Hello, Java!");

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            sb.setCharAt(i, (char)(c + 1)); // зсуваємо кожен символ на +1
        }
        
        System.out.println(sb); // Ifmmp-!Kbwb"
   }
   }
   Пояснення:

Проходимось по всіх символах.

(char)(c + 1) зсуває кожен символ у таблиці Unicode.

Пробіли, коми, знаки — теж зсуваються.

Завдання 19 Вирізати всі слова довжиною ≤ 3
-
       public class Task2Hard {
       public static void main(String[] args) {
       StringBuilder sb = new StringBuilder("The sun is big and hot");

        int i = 0;
        while (i < sb.length()) {
            int start = i;
            while (i < sb.length() && sb.charAt(i) != ' ') {
                i++;
            }
            int end = i; // позиція після слова
            
            if (end - start <= 3) {
                if (start > 0) start--; // забираємо пробіл перед словом
                sb.delete(start, end);
                i = start; // повертаємось назад, щоб не пропустити
            } else {
                i++;
            }
        }
        
        System.out.println(sb); // sun big hot
   }
   }
   Пояснення:

Ми рухаємося по рядку, відділяючи слова пробілами.
Якщо довжина слова ≤ 3, видаляємо його з пробілом перед ним.
Після видалення повертаємось назад, щоб не пропустити наступне слово.

Завдання 20 Реверс кожного слова, але зберегти порядок слів
-
   public class Task3Hard {
   public static void main(String[] args) {
   StringBuilder sb = new StringBuilder("Java is powerful");
   int start = 0;

        for (int i = 0; i <= sb.length(); i++) {
            if (i == sb.length() || sb.charAt(i) == ' ') {
                reverseRange(sb, start, i - 1);
                start = i + 1;
            }
        }
        
        System.out.println(sb); // avaJ si lufrewop
   }

   private static void reverseRange(StringBuilder sb, int left, int right) {
   while (left < right) {
   char temp = sb.charAt(left);
   sb.setCharAt(left, sb.charAt(right));
   sb.setCharAt(right, temp);
   left++;
   right--;
   }
   }
   }
   Пояснення:

Шукаємо межі кожного слова (по пробілу або кінцю рядка).

Реверсимо символи всередині цього діапазону.

Порядок слів не змінюється.

Завдання 21 Видалити повторювані символи
-
       public class Task4Hard {
       public static void main(String[] args) {
       StringBuilder sb = new StringBuilder("abracadabra");

        for (int i = 0; i < sb.length(); i++) {
            char current = sb.charAt(i);
            for (int j = i + 1; j < sb.length(); j++) {
                if (sb.charAt(j) == current) {
                    sb.deleteCharAt(j);
                    j--; // після видалення треба залишитися на цьому індексі
                }
            }
        }
        
        System.out.println(sb); // abrcd
   }
   }

   Пояснення:

Два вкладені цикли: зовнішній — по кожному символу, внутрішній — видаляє всі його повторення.

Після .deleteCharAt() зменшуємо j, щоб не пропустити наступний символ.

Завдання 22 Побудувати шахматну дошку
-
   public class Task5Hard {
   public static void main(String[] args) {
   StringBuilder sb = new StringBuilder();

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ((row + col) % 2 == 0) {
                    sb.append('#');
                } else {
                    sb.append('.');
                }
            }
            sb.append('\n');
        }
        
        System.out.println(sb);
   }
   }
   Пояснення:

(row + col) % 2 дозволяє чергувати символи.
Після кожного ряду додаємо \n.
Отримуємо шахматну сітку.
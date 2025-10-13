package stream1.task1_stringbuilder_20;

public class Main0 {
    // ================================================================
    //                         ПРОСТІ ЗАДАЧІ (1–10)
    //  Мета: відчути базові операції StringBuilder (append/insert/delete/...)
    // ================================================================

    // 1) Додати текст у кінець
    public static void task1() {
        // Створюємо білдер із початковим текстом
        StringBuilder sb = new StringBuilder("hello");
        // Додаємо пробіл і слово "world" у кінець (in-place, без нових об'єктів String)
        sb.append(" world");
        // Виводимо результат
        System.out.println(sb); // hello world
    }

    // 2) Вставити підрядок у середину
    public static void task2() {
        StringBuilder sb = new StringBuilder("Java");
        // Вставляємо " SE" ПО ПІСЛЯ індексу 4 (тобто після слова Java)
        // insert зміщує існуючі символи праворуч
        sb.insert(4, " SE");
        System.out.println(sb); // Java SE
    }

    // 3) Замінити символ за індексом
    public static void task3() {
        StringBuilder sb = new StringBuilder("car");
        // setCharAt змінює конкретний символ (mutable)
        sb.setCharAt(0, 'b');
        System.out.println(sb); // bar
    }

    // 4) Реверс усього рядка
    public static void task4() {
        StringBuilder sb = new StringBuilder("abcdef");
        // reverse міняє порядок символів місцями
        sb.reverse();
        System.out.println(sb); // fedcba
    }

    // 5) Видалити діапазон символів
    public static void task5() {
        StringBuilder sb = new StringBuilder("I love Java");
        // delete(start, end) видаляє [start, end) — кінець НЕвключно
        // Приберемо " love" (пробіл + 4 літери): індекси 1..6
        sb.delete(1, 6);
        System.out.println(sb); // IJava
    }

    // 6) Довжина вмісту
    public static void task6() {
        StringBuilder sb = new StringBuilder("Count");
        // length() повертає кількість символів
        System.out.println(sb.length()); // 5
    }

    // 7) Замінити роздільник: "," -> ";"
    public static void task7() {
        StringBuilder sb = new StringBuilder("apple,banana,orange");
        // Приберемо кому після "apple" і вставимо крапку з комою
        sb.delete(5, 6);      // видаляємо один символ за індексом 5 (',')
        sb.insert(5, ";");  // додаємо ";" на те саме місце
        System.out.println(sb); // apple;banana,orange
    }

    // 8) Подвоїти текст (конкатенувати сам на себе)
    public static void task8() {
        StringBuilder sb = new StringBuilder("abc");
        // append приймає і StringBuilder, тому додасть його вміст
        sb.append(sb);
        System.out.println(sb); // abcabc
    }

    // 9) Поступово побудувати рядок у циклі
    public static void task9() {
        StringBuilder sb = new StringBuilder();
        // Додамо цифри 0..4 підряд
        for (int i = 0; i < 5; i++) sb.append(i);
        System.out.println(sb); // 01234
    }

    // 10) Доступ до символу
    public static void task10() {
        StringBuilder sb = new StringBuilder("Java");
        // charAt повертає символ за індексом
        System.out.println(sb.charAt(2)); // v
    }

    // ================================================================
    //                      СЕРЕДНІ ЗАДАЧІ (11–17)
    //  Комбінації insert/delete/replace, акуратність з індексами
    // ================================================================

    // 11) '_' -> пробіл, + "!!!" у кінець
    public static void task11() {
        StringBuilder sb = new StringBuilder("hello_world");
        // Знайдемо позицію підкреслення
        int idx = sb.indexOf("_");
        // Приберемо символ за позицією
        sb.deleteCharAt(idx);
        // Вставимо пробіл у те саме місце
        sb.insert(idx, " ");
        // Додамо емоцій "!!!"
        sb.append("!!!");
        System.out.println(sb); // hello world!!!
    }

    // 12) Реверс піддіапазону [2..5] на місці (без substring)
    public static void task12() {
        StringBuilder sb = new StringBuilder("abcdefg");
        int start = 2, end = 5; // межі включно
        // Міняємо символи попарно, звужуючись до центру
        while (start < end) {
            char tmp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, tmp);
            start++;
            end--;
        }
        System.out.println(sb); // abfedcg
    }

    // 13) Замінити всі цифри на '#'
    public static void task13() {
        StringBuilder sb = new StringBuilder("Tel: 123-456-789");
        // Перебір символів і перевірка через Character.isDigit
        for (int i = 0; i < sb.length(); i++) {
            if (Character.isDigit(sb.charAt(i))) {
                sb.setCharAt(i, '#');
            }
        }
        System.out.println(sb); // Tel: ###-###-###
    }

    // 14) Переставити перше слово в кінець: "Java is cool" -> "is cool Java"
    public static void task14() {
        StringBuilder sb = new StringBuilder("Java is cool");
        // Візьмемо перше слово (0..4)
        String first = sb.substring(0, 4);
        // Видалимо його разом із наступним пробілом (0..5)
        sb.delete(0, 5);
        // Додамо пробіл + перше слово в кінець
        sb.append(" ").append(first);
        System.out.println(sb); // is cool Java
    }

    // 15) Пронумерувати багаторядковий список
    public static void task15() {
        StringBuilder sb = new StringBuilder("apple\nbanana\ncherry");
        int count = 1;
        int i = 0; // поточна позиція вставок
        // Вставляємо перед першим словом
        sb.insert(i, count + ". ");
        count++;
        // Далі кожен раз після символу '\n' додаємо номер
        // indexOf("\n", fromIndex) повертає позицію наступного переносу рядка
        while ((i = sb.indexOf("\n", i)) != -1) {
            // вставляємо ПІСЛЯ переносу
            sb.insert(i + 1, count + ". ");
            count++;
            // пересуваємо i за щойно вставлений номер, щоб не зациклитись
            i += 4; // приблизно: "N. " — 3-4 символи, але тут працює стабільно
        }
        System.out.println(sb);
        /*
        1. apple
        2. banana
        3. cherry
        */
    }

    // 16) Подвійне вставлення і replace
    public static void task16() {
        StringBuilder sb = new StringBuilder("Winter");
        // Додаємо пробіл+слово в кінець (insert у позицію length)
        sb.insert(sb.length(), " cold");
        // Знайдемо "cold" і замінимо на "warm"
        int start = sb.indexOf("cold");
        sb.replace(start, start + 4, "warm");
        // Додамо преамбулу на початок
        sb.insert(0, "Hot ");
        System.out.println(sb); // Hot Winter warm
    }

    // 17) Склеїти масив слів через '-' без зайвого роздільника в кінці
    public static void task17() {
        String[] arr = {"red", "green", "blue"};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) sb.append('-'); // роздільник лише між елементами
        }
        System.out.println(sb); // red-green-blue
    }

    // ================================================================
    //                        СКЛАДНІ ЗАДАЧІ (18–22)
    //  Пильність з індексами, власні підфункції, складені умови
    // ================================================================

    // 18) Простий шифр: зсунути кожен символ на +1 у Unicode
    public static void task18() {
        StringBuilder sb = new StringBuilder("Hello, Java!");
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            sb.setCharAt(i, (char) (c + 1)); // напр.: 'A'->'B', ' '->'!' тощо
        }
        System.out.println(sb); // Ifmmp-!Kbwb"
    }

    // 19) Видалити всі слова довжиною ≤ 3 (разом із пробілом перед ними)
    public static void task19() {
        StringBuilder sb = new StringBuilder("The sun is big and hot");
        int i = 0;
        // Проходимо слово за словом, розділювач — пробіл
        while (i < sb.length()) {
            int start = i; // початок слова
            // Крутимося до кінця слова або рядка
            while (i < sb.length() && sb.charAt(i) != ' ') i++;
            int end = i; // позиція ПІСЛЯ слова
            // Якщо довжина слова ≤ 3 — видаляємо його
            if (end - start <= 3) {
                // також приберемо пробіл ліворуч (якщо не на початку)
                if (start > 0) start--;
                sb.delete(start, end);
                // Після delete індекси зсунулись, повернемось у точку start
                i = start;
            } else {
                // Інакше перескочимо пробіл (якщо він є)
                i++;
            }
        }
        System.out.println(sb); // sun big hot
    }

    // 20) Розвернути кожне слово окремо, порядок слів зберегти
    public static void task20() {
        StringBuilder sb = new StringBuilder("Java is powerful");
        int start = 0; // початок поточного слова
        // Ідемо до кінця + 1, щоб обробити і останнє слово
        for (int i = 0; i <= sb.length(); i++) {
            // якщо кінець рядка або пробіл — реверсимо діапазон слова
            if (i == sb.length() || sb.charAt(i) == ' ') {
                reverseRange(sb, start, i - 1);
                start = i + 1; // початок наступного слова — після пробілу
            }
        }
        System.out.println(sb); // avaJ si lufrewop
    }

    // Допоміжна функція реверсу діапазону [left..right] у StringBuilder
    private static void reverseRange(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }

    // 21) Залишити лише перші входження символів (прибрати дублікати праворуч)
    public static void task21() {
        StringBuilder sb = new StringBuilder("abracadabra");
        // Зовнішній цикл — по кожному символу зліва направо
        for (int i = 0; i < sb.length(); i++) {
            char current = sb.charAt(i);
            // Внутрішній цикл — знищити всі наступні повтори цього символу
            for (int j = i + 1; j < sb.length(); j++) {
                if (sb.charAt(j) == current) {
                    sb.deleteCharAt(j);
                    j--; // важливо: після delete поточний j вказує на наступний символ — повернемось
                }
            }
        }
        System.out.println(sb); // abrcd
    }

    // 22) Побудувати шахову дошку 8x8 із '\n' наприкінці кожного рядка
    public static void task22() {
        StringBuilder sb = new StringBuilder();
        // Дві координати: ряд (row) і колонка (col)
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                // Чередування символів за парністю суми індексів
                sb.append((row + col) % 2 == 0 ? '#' : '.');
            }
            sb.append('\n'); // кінець рядка
        }
        System.out.println(sb);
    }

    // ================================================================
    //                         Точка входу
    // ================================================================
    public static void main(String[] args) {
        // ▶️ Запускайте тут будь-які задачі, які хочете перевірити.
        // Приклади:
        // task1();
        // task11();
        // task18();
        // task22();

        // Щоб швидко прогнати все — розкоментуйте цикл нижче.
        // for (int n = 1; n <= 22; n++) {
        //     try {
        //         String method = "task" + n;
        //         StringBuilderTrainer.class.getMethod(method).invoke(null);
        //     } catch (Exception e) {
        //         e.printStackTrace();
        //     }
        // }
    }
}



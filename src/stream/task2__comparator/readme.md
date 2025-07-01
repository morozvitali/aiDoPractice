
.sorted(Comparator.comparing(Order::counting))
виглядатиме у розгорнутому (нескороченому) вигляді, без method reference і з повною анонімною реалізацією Comparator:

.sorted(new Comparator<String>() {
@Override
public int compare(String a, String b) {
return Integer.compare(Order.counting(a), Order.counting(b));
}
})
А весь метод order(...) у нескороченому вигляді:

public static String order(String words) {
if (words == null || words.isEmpty()) return "";

    return Arrays.stream(words.split(" "))
            .sorted(new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    return Integer.compare(Order.counting(a), Order.counting(b));
                }
            })
            .collect(Collectors.joining(" "));
}
Метод counting:

public static int counting(String s) {
return Integer.parseInt(s.replaceAll("[^0-9]", ""));
}
🧠 Це корисно для повного розуміння механіки Comparator.comparing(...):
Comparator.comparing(Order::counting) — це скорочення від "створи компаратор, який порівнює значення, обраховане методом counting()".
У нескороченій формі ми самі описуємо, як порівнювати два об’єкти.
🔧 Якщо хочеш — зробимо і варіант через lambda, він посередній між скороченим і повністю несокращеним.
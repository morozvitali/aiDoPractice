
✅ Задача 00: Виведи перші кілька чисел,
поки їхня сума менша за 50

📦 Очікуваний результат:

1  
2  
3  
4  
5  
6  
7  
8  
9  
(бо після цього 1+2+…+9 = 45, а 45+10=55 → вже не підходить)

🧠 Підказка (тільки Java 9+):

IntStream.iterate(1, i -> i + 1)
.takeWhile(new IntPredicate() {
int sum = 0;
public boolean test(int i) {
sum += i;
return sum < 50;
}
})

----------- from deleted ------------
-

⭐ Задача 7 (anyMatch) (з зірочкою) : Перевірити, чи хоча б одне слово з
колекції є паліндромом (читається однаково в обидва боки)

List<String> words = List.of("racecar", "apple", "madam"); → `true`  
List<String> words = List.of("java", "stream", "code"); → `false`
Підказка:

String reversed = new StringBuilder(s).reverse().toString();
s.equals(reversed)
Потім .anyMatch(...)

    public boolean practice6 () {
        List<String> words = List.of("racecar", "apple", "madam");
    return words.stream().anyMatch(s->isPalindrom(s));
    }
    public boolean isPalindrom (String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }


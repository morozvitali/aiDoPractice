🔹 Частина 2: filter + reduce
✅ Задача 3: Знайти максимальне непарне число, якщо таке є, інакше повернути -1

int[] numbers = {2, 8, 15, 21, 4, 9};
Очікуваний результат:
21

Якщо масив такий:
int[] numbers = {2, 4, 6};
→ результат має бути -1

Підказка:
.filter(...)
.reduce(...).orElse(...)
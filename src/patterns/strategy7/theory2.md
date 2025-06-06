Стратегія — це поведінковий патерн проектування, який
визначає сімейство схожих алгоритмів і розміщує кожен з
них у власному класі. Після цього алгоритми можна заміняти
один на інший прямо під час виконання програми.



Патерн Стратегія пропонує визначити сімейство схожих
алгоритмів, які часто змінюються або розширюються, й
винести їх до власних класів, які називають стратегіями.
Замість того, щоб початковий клас сам виконував той чи
інший алгоритм, він відіграватиме роль контексту, 
посилаючись на одну зі стратегій та делегуючи їй 
виконання роботи. Щоб змінити алгоритм, вам буде 
достатньо підставити в контекст інший об’єкт-стратегію.


**Важливо, щоб всі стратегії мали єдиний інтерфейс.** 
Використовуючи цей інтерфейс, контекст буде незалежним від
конкретних класів стратегій. З іншого боку, ви зможете 
змінювати та додавати нові види алгоритмів, не чіпаючи код
контексту.

У цьому прикладі контекст використовує Стратегію для
виконання тієї чи іншої арифметичної операції.

1 // Загальний інтерфейс стратегій.
2 interface Strategy is
3 method execute(a, b)
4
5 // Кожна конкретна стратегія реалізує загальний інтерфейс у свій
6 // власний спосіб.
7 class ConcreteStrategyAdd implements Strategy is
8 method execute(a, b) is
9 return a + b
10
11 class ConcreteStrategySubtract implements Strategy is
12 method execute(a, b) is
13 return a - b
14
15 class ConcreteStrategyMultiply implements Strategy is
16 method execute(a, b) is
17 return a * b
18
19 // Контекст завжди працює зі стратегіями через загальний
20 // інтерфейс. Він не знає, яку саме стратегію йому подано.
21 class Context is
22 private strategy: Strategy
23
24 method setStrategy(Strategy strategy) is
25 this.strategy = strategy
26
27 method executeStrategy(int a, int b) is
28 return strategy.execute(a, b)
29
30
31 // Конкретна стратегія вибирається на більш високому рівні,
32 // наприклад, конфігуратором всієї програми. Готовий об'єкт-
33 // стратегія подається до клієнтського об'єкта, а потім може
34 // бути замінений іншою стратегією, в будь-який момент, «на
35 // льоту».
36 class ExampleApplication is
37 method main() is
38 // 1. Створити об'єкт контексту.
39 // 2. Ввести перше число (n1).
40 // 3. Ввести друге число (n2).
41 // 4. Ввести бажану операцію.
42 // 5. Потім, обрати стратегію:
43 if (action == addition) then
44 context.setStrategy(new ConcreteStrategyAdd())
45
46 if (action == subtraction) then
47 context.setStrategy(new ConcreteStrategySubtract())
48
49 if (action == multiplication) then
50 context.setStrategy(new ConcreteStrategyMultiply())
51
52 // 6. Виконати операцію за допомогою стратегії:
53 result = context.executeStrategy(n1, n2)
54
55 // N. Вивести результат на екран.
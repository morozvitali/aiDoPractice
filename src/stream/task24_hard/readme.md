
✅ Задача 9: Collectors.mapping()
для витягу прізвищ по групах
📋 Є список людей із групами. Отримай Map<група,
List<прізвища>>:

class Person {
String lastName;
String group;
Person(String ln, String g) {
lastName = ln;
group = g;
}
String getGroup() { return group; }
String getLastName() { return lastName; }
}

List<Person> people = List.of(
new Person("Shevchenko", "A"),
new Person("Franko", "B"),
new Person("Skovoroda", "A")
);

Map<String, List<String>> groupToLastNames =
people.stream()
.collect(Collectors.groupingBy(
Person::getGroup,
Collectors.mapping(Person::getLastName,
Collectors.toList())
));

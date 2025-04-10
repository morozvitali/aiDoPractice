🔹 Завдання:
Напиши метод hasDigit(String str), який перевіряє,
чи містить рядок хоча б одну цифру (0-9).

Приклади:
hasDigit("hello123")  -> true
hasDigit("world")     -> false
hasDigit("abc5xyz")   -> true
hasDigit("!@#$%^")    -> false

💡 Підказка:
Використай метод matches(), replaceAll(), або Pattern.matcher().find().


    public boolean hasDigit (String s) {
        return s.matches("\\d");
    }

    public boolean hasDigit2 (String s) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(s);
        return matcher.find();
    }

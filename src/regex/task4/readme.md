🔹 Наступне завдання: Валідація пароля
Напиши метод isValidPassword(String password), який перевіряє,
чи введений пароль відповідає наступним вимогам:

✅ Довжина від 8 до 20 символів
✅ Містить хоча б одну літеру в верхньому регістрі (A-Z)
✅ Містить хоча б одну літеру в нижньому регістрі (a-z)
✅ Містить хоча б одну цифру (0-9)
✅ Містить хоча б один спеціальний символ (!@#$%^&*()-+=)
✅ Не містить пробілів

📌 Приклади роботи:
isValidPassword("StrongP@ss1")   -> true
isValidPassword("weakpass")       -> false  // немає цифр та спецсимволів
isValidPassword("SHORT1!")        -> false  // замало символів
isValidPassword("longpassword123456789!") -> false  // забагато символів
isValidPassword("NoSpecialChar1") -> false  // немає спецсимволу
isValidPassword("White space 1!") -> false  // містить пробіл

💡 Підказка:
Використай matches() і Lookahead ((?=.*...)) для перевірки окремих умов.
🔍 Розбір регулярного виразу

return password.matches(
"^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()\\-+=])[^\\s]{8,20}$"
);

^	Початок рядка
(?=.*[a-z])	Має містити хоча б одну маленьку літеру (a-z)
(?=.*[A-Z])	Має містити хоча б одну велику літеру (A-Z)
(?=.*\d)	Має містити хоча б одну цифру (0-9)
(?=.*[!@#$%^&*()\-+=])	Має містити хоча б один спеціальний символ з !@#$%^&*()-+=
[^\\s]{8,20}$	Не містить пробілів, довжина від 8 до 20 символів

public class Regex3 {
public boolean isValidPassword(String password) {
return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()\\-+=])[^\\s]{8,20}$");
}


    public static void main(String[] args) {
        Regex3 reg = new Regex3();
        System.out.println(reg.isValidPassword("StrongP@ss1"));
        System.out.println(reg.isValidPassword("weakpass"));
        System.out.println(reg.isValidPassword("SHORT1!"));
        System.out.println(reg.isValidPassword("longpassword123456789!"));
        System.out.println(reg.isValidPassword("NoSpecialChar1"));
        System.out.println(reg.isValidPassword("White space 1!"));
    }
}



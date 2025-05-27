package regex.task3;

public class Regex5 {
    public boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9][a-zA-Z0-9._-]+[a-zA-Z0-9]@[^//.][a-zA-Z0-9.]+[^//.]\\.[a-zA-Z]{2,6}$");
    }

    public static void main(String[] args) {
        Regex5 validator = new Regex5();
        System.out.println(validator.isValidEmail("user@example.com"));
        System.out.println(validator.isValidEmail("john.doe-123@gmail.com"));
        System.out.println(validator.isValidEmail("jane@sub.domain.org"));
        System.out.println(validator.isValidEmail(".user@example.com"));
        System.out.println(validator.isValidEmail("user.@example.com"));
        System.out.println(validator.isValidEmail("user@.example.com"));
        System.out.println(validator.isValidEmail("user@example.com."));
        System.out.println(validator.isValidEmail("user@domain.c"));
    }

}

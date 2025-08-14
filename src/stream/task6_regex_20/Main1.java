package stream.task6_regex_20;

public class Main1 {
    public boolean practice1 (String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()\\-+=])\\S{8,20}$");
    }

    public boolean practice2 (String email) {
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$]");
    }

    public boolean practice3 (String number) {
        return number.matches("^\\+380\\d{2}\\d{3}\\d{4}$");
    }
}

package stream.task1_regex_20;

public class Main0 {
    public void practice1 (String password) {
        password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()\\-+=])\\S{8,20}$");
    }

    public void practice2 (String email) {
        email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }

    public void practice3 (String number) {
        number.matches("^\\+380\\d{2}\\d{3}\\d{4}$");
    }

    public void practice4 (String ip) {
    }

    public void practice5 (String date) {
        date.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$");
    }



}

package stream.task6_regex_20;

public class Main1 {
    public void practice1 (String password) {
        password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()\\-+=])\\S{8,20}$");
    }


}

package stream.task6_regex_20;

public class Main3 {
    public boolean practice1 (String s) {
        return s.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()+=-])\\S{8,20}");
    }

    public boolean practice2 (String s) {
        return s.matches("^[a-zA-Z0-9,>%+-]+@[a-zA-Z0-9._-][a-zA-Z]{2,6}$");
    }

}

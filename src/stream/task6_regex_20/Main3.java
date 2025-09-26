package stream.task6_regex_20;

public class Main3 {
    public boolean practice1 (String s) {
        return s.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()+=-])\\S{8,20}");
    }


}

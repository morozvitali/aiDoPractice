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

    public void practice6 (String url) {
        url.matches("^(https?:\\/\\/)?([a-zA-Z0-9.-]+)\\.([a-zA-Z]{2,6})(\\/.*)?$");
    }

    public void practice7 (String sentence) {
        sentence.matches("^[a-zA-Z]+$");
    }

    public void practice8 (String sentence) {
        sentence.matches("^\\d+$");
    }

    public void practice9 (String s) {
        s.matches("^[a-zA-Z0-9]+$");
    }

    public void practice10 (String sentence) {
        sentence.replaceAll("\\s+", "");
    }

    public void practice11 (String sentence) {
        sentence.matches("^[а-яА-ЯіїєґІЇЄҐ]+$");
    }

    public void practice12 (String sentence) {
        sentence.matches("^([^0-9]*)$");
    }

    public void practice13 (String sentence) {
        sentence.replaceAll("[^a-zA-Z0-9 ]", "");
    }

    public void practice14 (String sentence) {
        sentence.matches("^\\+\\d{1,3}$");
    }

    public void practice15 (String sentence) {
        sentence.matches("^\\S+$");
    }

    public void practice16 (String sentence) {

    }
}

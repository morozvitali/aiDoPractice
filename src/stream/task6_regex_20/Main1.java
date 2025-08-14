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

    public void practice4 (String ip) {
    }

    public boolean practice5 (String date) {
        return date.matches("^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$");
    }

    public boolean practice6 (String url) {
        return url.matches("^(https?:\\/\\/)?([a-zA-Z0-9.-]+)\\.([a-zA-Z]{2,6})(\\/.*)?$");
    }

    public boolean practice8 (String sentence) {
        return sentence.matches("^\\d+$");
    }

    public boolean practice7 (String sentence) {
        return sentence.matches("^[a-zA-Z]+$");
    }
    public boolean practice9 (String sentence) {
        return sentence.matches("^[a-zA-Z0-9]+$");
    }

    public String practice10 (String sentence) {
        return sentence.replaceAll("\\s+", "");
    }

    public boolean practice11 (String sentence) {
        return sentence.matches("^[a-яА-ЯіїєґІЇЄҐ]+$");
    }

    public boolean practice12 (String sentence) {
        return sentence.matches("^([^0-9]*)$");
    }
    
}

package stream.task6_regex_20;

public class Main2 {
public boolean practice1 (String s) {
    return s.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()\\-+=])\\S{8,20}");
}

public boolean practice2 (String s) {
    return s.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}]");
}

public boolean practice3 (String s) {
    return s.matches("^\\+380\\d{2}\\d{3}\\d{4}$");
}

public boolean practice5 (String s) {
    return s.matches("^\\d{4}-([1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$");
}

public boolean practice6 (String s) {
    return s.matches("^(https?:\\/\\/)?([a-zA-Z0-9.-]+)\\.([a-zA-Z]{2,6})(\\/.*)?$");
}

public boolean practice7 (String s) {
    return s.matches("^[a-zA-Z]+$");
}

public boolean practice8 (String s) {
    return s.matches("^\\d+$");
}

public boolean practice9 (String s) {
    return s.matches("^[a-zA-Z0-9]+$");
}

public String practice10 (String s) {
    return s.replaceAll("\\s+", "");
}

public boolean practice11 (String s) {
    return s.matches("^[a-яА-ЯіїєґІЇЄҐ]+$");
}

public boolean practice12 (String s) {
    return s.matches("^([^0-9]*)$");
}

public String practice13 (String s) {
    return s.replaceAll("[^a-zA-Z0-9 ]" , "");
}

public boolean practice14 (String s) {
    return s.matches("^\\+\\d{1,3}$");
}


}

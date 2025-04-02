package regex.task17;

public class Regex2 {
    public boolean isFileName (String sentense) {
        return sentense.matches("^[a-zA-Z0-9][a-zA-Z0-9._-]{2,49}.(txt|pdf|docx|jpg|png|zip|rar|exe)$");
    }
}

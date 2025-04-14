package regex.task17;

public class Regex4 {

    public boolean isFileName(String str) {
        return str.matches("^[a-zA-Z0-9._-]{2,49}.[txt|pdf|docx|jpg|png|zip|rar|exe]$");
    }
}

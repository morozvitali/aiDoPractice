package regex.task17;

public class Regex3 {
    public boolean fileNameValidator (String fileName) {
        return fileName.matches("^[a-zA-Z0-9][a-zA-Z0-9._-]{3,43}.(txt|pdf|docx|jpg|png|zip|rar|exe)$");
    }
}
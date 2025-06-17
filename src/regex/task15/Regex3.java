package regex.task15;

public class Regex3 {
    public String [] splitWords (String sentence) {
        return sentence.split("[\\W]+");
    }
}

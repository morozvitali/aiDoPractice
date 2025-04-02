package regex.task13;

public class Regex2 {
    public String myCleaner (String sentence) {


        return sentence.replaceAll("[^a-zA-Z0-9 ]" , "");
    }

}

package stream.task12_plus_valueOf_10;

public class Main12 {
    public long practice1 () {
        String input = "12345";
        //return Long.parseLong(input); -->int
        return Long.valueOf(input); //--> autounboxing from Integer
    }



}

package stream.Task2;

import java.util.Arrays;

public class Try2 {

    public String wordFinder (String value) {

        String firstArrayValue = value.split(" ")[0];
        return Arrays.stream(value.split(" "))
                .reduce(firstArrayValue, (a,b) -> a.length() <= b.length() ? a : b);
    }


    public static void main(String[] args) {
        String sentense = "home is where the heart is";
        Try2 try2 = new Try2();
        System.out.print(try2.wordFinder(sentense));
    }
}
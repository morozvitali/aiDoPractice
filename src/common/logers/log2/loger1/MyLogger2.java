package common.logers.log2.loger1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyLogger2 {

    private static MyLogger2 instance; // realisatiuon of singleton in private constructor
    private MyLogger2 () {
        System.out.println("Loger created in constructor");
    }

    public static MyLogger2 getInstance () {
        if (instance == null) {
            instance = new MyLogger2();
        }
        return instance;
    }

    public void log (String message, String level) {
        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logLine = String.format("[%s] [%s] [%s]", formattedDateTime, level.toUpperCase(), message);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
            writer.write(logLine);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Exception of writing in file " + e.getMessage());
        }
    }



    public static void main(String[] args) {
        common.logers.loger2.MyLogger2 myLogger2 = common.logers.loger2.MyLogger2.getInstance();
        myLogger2.log("message1", "all systems red");

        common.logers.loger2.MyLogger2 myLogger22 = common.logers.loger2.MyLogger2.getInstance();
        myLogger2.log("message2", "all systems green");
    }
}
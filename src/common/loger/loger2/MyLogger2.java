package common.loger.loger2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyLogger2 {

    private static MyLogger2 instance;

    private MyLogger2 () {
        System.out.println("Loger created");
    }

    public static MyLogger2 getInstance() {

        if (instance == null) {
            instance = new MyLogger2();
        }
        return instance;
    }

    public void log (String message, String level) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String formatedDateTime = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logLine = String.format("[%s] [%s] [%s]", formatedDateTime, level.toUpperCase(), message);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
            writer.write(logLine);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Помилка у запису " + e.getMessage());
        }
    }


    public static void main(String[] args) {
        MyLogger2 myLogger2 = MyLogger2.getInstance();
        myLogger2.log("message1", "all systems red");


        MyLogger2 myLogger22 = MyLogger2.getInstance();
        myLogger2.log("message2", "all systems green");
    }
}
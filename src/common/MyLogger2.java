package common;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyLogger2 {

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
        MyLogger2 myLogger2 = new MyLogger2();
        myLogger2.log("message", "all systems red");
    }
}
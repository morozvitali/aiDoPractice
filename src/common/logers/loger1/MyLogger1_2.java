package common.logers.loger1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyLogger1_2 {

    public void log (String message, String level) {

        LocalDateTime now = LocalDateTime.now();
        String formattedDateTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logLine = String.format("[%s] [%s] [%s]", formattedDateTime, level.toUpperCase(), message);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter ("logger.txt", true))) {
            writer.write(logLine);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Помилка запису у файл " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        MyLogger1_2 myLogger2 = new MyLogger1_2();
        myLogger2.log("Testing Of the Method", "All red");
    }
}

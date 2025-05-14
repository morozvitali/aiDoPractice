package common.loger1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyLogger1 {

    public void log(String message, String level) {

        LocalDateTime now = LocalDateTime.now(); //додали час на зараз
        String formattedDateTime = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")); // із строчки часу зробили шаблонну строчку для виводу
        String logLine = String.format("[%s] [%s] [%s]", formattedDateTime, level.toUpperCase(), message);  // сформували строчку

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt", true))) {
            writer.write(logLine);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Помилка запису у файл " + e.getMessage());
        }


    }

    public static void main(String[] args) {
        MyLogger1 myLogger = new MyLogger1();
        myLogger.log("Testing Of tje Method", "All system error");
    }
}
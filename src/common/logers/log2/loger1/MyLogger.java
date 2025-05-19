package common.logers.log2.loger1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyLogger {
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
        MyLogger myLogger = new MyLogger();
        myLogger.log("testing of logger", "all good" );
    }

}

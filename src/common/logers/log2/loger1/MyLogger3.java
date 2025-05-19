package common.logers.log2.loger1;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public enum MyLogger3 {
    INSTANCE; // singleton realisation, one instance

    private static final String FILE_NAME = "log.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm:ss");

    public void log (String message, String level) {

        String timeStamp = LocalDateTime.now().format(FORMATTER);
        String logLine = String.format("[%s] [%s] [%s]", timeStamp, level.toUpperCase(), message);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
             writer.write(logLine);
             writer.newLine();
        } catch (IOException e) {
            System.out.println("Exceptions happening ");
        }
    }
}

package common.logers.loger4.loger4_1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public enum MyLogger4_1 {
    INSTANCE;
    private static final String FILE_NAME = "log.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

    public void log(String message, LogLevel level) {
        String timeStamp = LocalDateTime.now().format(FORMATTER);
        String logLine = String.format("[%s] [%s] [%s]", timeStamp, level, message);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(logLine);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error file recording process");
        }
    }

    public static void main(String[] args) {
        MyLogger4_1.INSTANCE.log("Запуск програми", LogLevel.INFO);
        MyLogger4_1.INSTANCE.log("Попередження", LogLevel.WARNING);
        MyLogger4_1.INSTANCE.log("Помилка", LogLevel.ERROR);
        MyLogger4_1.INSTANCE.log("Debug x=42", LogLevel.DEBUG);
    }
}

enum LogLevel {
    INFO,
    WARNING,
    ERROR,
    DEBUG
}
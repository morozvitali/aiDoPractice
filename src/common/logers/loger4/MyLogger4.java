package common.logers.loger4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public enum MyLogger4 {
    INSTANCE;  // its singleton, one instance
    private static final String FILE_NAME = "log4_1.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

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
}

enum LogLevel {
    INFO,
    WARNING,
    ERROR,
    DEBUG
}

class Main {
    public static void main(String[] args) {
        MyLogger4.INSTANCE.log("Запуск програми", LogLevel.INFO);
        MyLogger4.INSTANCE.log("Попередження про оновлення", LogLevel.WARNING);
        MyLogger4.INSTANCE.log("Критична помилка під час виконання", LogLevel.ERROR);
        MyLogger4.INSTANCE.log("Debug: X=42", LogLevel.DEBUG);
    }
}
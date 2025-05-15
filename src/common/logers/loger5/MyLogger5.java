package common.logers.loger5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public enum MyLogger5 {
    INSTANCE;  // its singleton, one instance

    private static final String FILE_NAME = "log.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // мінмальний рівень для логування
    private LogLevel threhold = LogLevel.INFO;

    public void setThrehold (LogLevel threhold) {
        this.threhold = threhold;
    }

    public void log(String message, LogLevel level) {

        if (level.getPriority() < threhold.getPriority()) {
            return; // Пропускаємо лог, бо нижчий за поріг
        }

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
    DEBUG(0),
    INFO(1),
    WARNING(2),
    ERROR(3);

    private final int priority; // додали праоритет

    LogLevel(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}

class Main {
    public static void main(String[] args) {
        MyLogger5.INSTANCE.log("Запуск програми", LogLevel.INFO);
        MyLogger5.INSTANCE.log("Попередження про оновлення", LogLevel.WARNING);
        MyLogger5.INSTANCE.log("Критична помилка під час виконання", LogLevel.ERROR);
        MyLogger5.INSTANCE.log("Debug: X=42", LogLevel.DEBUG);
    }
}
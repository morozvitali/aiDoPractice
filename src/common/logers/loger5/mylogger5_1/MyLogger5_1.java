package common.logers.loger5.mylogger5_1;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public enum MyLogger5_1 {
    INSTANCE;

    private static final String FILE_NAME = "log5_1.txt";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

    // min level for logging
    private LogLevel threhold = LogLevel.INFO;

    public void setThrehold (LogLevel threhold) {
        this.threhold = threhold;
    }

    public void log (String message, LogLevel level) {


        if (level.getPriority() < threhold.getPriority()) {
            return; // skip, lowest of floor
        }

        String timeStamp = LocalDateTime.now().format(FORMATTER);
        String logLine = String.format("[%s] [%s] [%s]", timeStamp, level, message);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(logLine);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error file writing process");
        }
    }

    public static void main(String[] args) {
        MyLogger5_1.INSTANCE.log("programm running ", LogLevel.INFO);
        MyLogger5_1.INSTANCE.log("update warning", LogLevel.WARNING);
        MyLogger5_1.INSTANCE.log("critical error ", LogLevel.ERROR);
        MyLogger5_1.INSTANCE.log("debug x=42 ", LogLevel.DEBUG);
    }
}

enum LogLevel {
    DEBUG (0),
    INFO (1),
    WARNING (2),
    ERROR (3);

    private final int priority;

    LogLevel (int priority) {
        this.priority = priority;
    }

    public int getPriority () {
        return priority;
    }
}
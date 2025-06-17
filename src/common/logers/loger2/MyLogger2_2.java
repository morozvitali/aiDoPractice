package common.logers.loger2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MyLogger2_2 {
    private static MyLogger2_2 instance;
    private MyLogger2_2() {
        System.out.println("Loger created");
    }
    public static MyLogger2_2 getInstance() {
        if (instance == null) {
            instance = new MyLogger2_2();
        }
        return instance;
    }

    public void log(String message, String level) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String formatedDateTime = localDateTime.format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss"));
        String logLine = String.format("[%s] [%s] [%s]", formatedDateTime, level.toUpperCase(), message);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log2_2.txt", true))) {
            writer.write(logLine);
        } catch (IOException e) {
            System.out.println("Помилка у запису " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        MyLogger2_2 logger = MyLogger2_2.getInstance();
        logger.log("message 11", "System Halt");

        MyLogger2_2 logger2 = MyLogger2_2.getInstance();
        logger2.log("message 22", "testing");
    }

}

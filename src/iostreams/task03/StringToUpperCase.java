package iostreams.task03;

import iostreams.task02.CharacterCounter;

import java.io.*;
import java.util.function.Predicate;

public class StringToUpperCase {

    public void myToUpperCase(String path1, String path2, Predicate<String> condition) throws FileProcessingException {

        try (BufferedReader br = new BufferedReader(new FileReader(path1));
             BufferedWriter bw = new BufferedWriter(new FileWriter(path2, true))) {

            String line;
            while ((line = br.readLine()) != null) {
                if (!condition.test(line)) {
                    System.out.println("line is too short: " + line);
                    continue;
                }
                else {
                    System.out.println("Line to upper case is: " + line);
                }
                bw.write(line.toUpperCase());
                bw.newLine();
                System.out.println("перетворено і записано у файл");
            }
        } catch (FileNotFoundException e) {
            throw new FileProcessingException("Файл не знайдено");
        } catch (IOException e) {
            throw new FileProcessingException("Помилка обробки файлу");
        }
    }

    public static void main(String[] args) {
        StringToUpperCase su = new StringToUpperCase();

        Predicate <String> filter = line -> line.length() >= 10 && Character.isUpperCase(line.charAt(0));


        try {
            su.myToUpperCase("iotask03.txt", "iotask03-03.txt", filter);
            System.out.println("Успішно виконано");
        }
        catch (FileProcessingException e) {
            System.out.println("⚠ Помилка: " + e.getMessage());
        }
    }
}
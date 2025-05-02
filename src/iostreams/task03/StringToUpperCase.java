package iostreams.task03;

import java.io.*;

public class StringToUpperCase {

    public void myToUpperCase(String path1, String path2, LineFilter filter) throws FileProcessingException {

        try (BufferedReader br = new BufferedReader(new FileReader(path1));
             BufferedWriter bw = new BufferedWriter(new FileWriter(path2, true))) {

            String line;
            while ((line = br.readLine()) != null) {
                if (!filter.allow(line)) {
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
        LineFilter filter = new LenghtFilter(10);


        try {
            su.myToUpperCase("iotask03.txt", "iotask03-03.txt", filter);
            System.out.println("Успішно виконано");
        }
        catch (FileProcessingException e) {
            System.out.println("⚠ Помилка: " + e.getMessage());
        }
    }
}
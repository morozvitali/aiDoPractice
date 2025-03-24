package regex.task20;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
Main main = new Main();
        System.out.println(main.isValidDate("01/01/2024"));  // ✅ true
        System.out.println(main.isValidDate("31/12/2099"));  // ✅ true
        System.out.println(main.isValidDate("29/02/2020"));  // ✅ true (2020 – високосний)
        System.out.println(main.isValidDate("29/02/2023"));  // ❌ false (2023 не високосний)
        System.out.println(main.isValidDate("32/01/2024"));  // ❌ false (немає 32 днів)
        System.out.println(main.isValidDate("00/12/2023"));  // ❌ false (день не може бути 00)
        System.out.println(main.isValidDate("15/13/2023"));  // ❌ false (немає 13 місяця)
        System.out.println(main.isValidDate("10-10-2023"));  // ❌ false (неправильний формат, має бути `/`)
            }

    public boolean isValidDate(String date) {

        try {
            int year = Integer.parseInt(date.substring(6, 10));
            int month = Integer.parseInt(date.substring(0, 2));
            int day = Integer.parseInt(date.substring(3, 5));

            LocalDate da = LocalDate.of(year, month, day);
            System.out.println(da);


            if (da.isLeapYear()) {
                System.out.print("visokos");
            };

        } catch (DateTimeException e) {
            System.out.print("exception");
            return false;
        }

        return date.matches("^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/(19[0-9]{2}|20[0-9]{2})$");
    }
}

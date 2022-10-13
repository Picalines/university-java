package practice11;

import java.util.Calendar;
import java.util.Scanner;

public class Exercise4 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        var scanner = new Scanner(System.in);

        System.out.println("Введите дату (<год> <месяц> <день месяца> <часы> <минуты>):");
        calendar.set(Calendar.YEAR, scanner.nextInt());
        calendar.set(Calendar.MONTH, scanner.nextInt());
        calendar.set(Calendar.DAY_OF_MONTH, scanner.nextInt());
        calendar.set(Calendar.HOUR_OF_DAY, scanner.nextInt());
        calendar.set(Calendar.MINUTE, scanner.nextInt());

        System.out.println(calendar.getTime());
    }
}

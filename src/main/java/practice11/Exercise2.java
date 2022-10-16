package practice11;

import java.util.Calendar;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        var scanner = new Scanner(System.in);

        var currentTime = calendar.getTime();

        System.out.println("Введите дату (<день месяца> <месяц> <год>):");
        calendar.set(Calendar.DAY_OF_MONTH, scanner.nextInt());
        calendar.set(Calendar.MONTH, scanner.nextInt() - 1);
        calendar.set(Calendar.YEAR, scanner.nextInt());
        var userTime = calendar.getTime();

        System.out.println(switch (userTime.compareTo(currentTime)) {
            case 1 -> "Эта дата позже текущей";
            case -1 -> "Эта дата раньше текущей";
            default -> "Это та же дата";
        });
    }
}

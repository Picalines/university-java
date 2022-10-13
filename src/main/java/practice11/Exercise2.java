package practice11;

import java.util.Calendar;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        var scanner = new Scanner(System.in);

        var currentTime = System.currentTimeMillis();
        calendar.setTimeInMillis(currentTime);

        System.out.println("Введите дату (<день месяца> <месяц> <год>):");
        calendar.set(Calendar.DAY_OF_MONTH, scanner.nextInt());
        calendar.set(Calendar.MONTH, scanner.nextInt());
        calendar.set(Calendar.YEAR, scanner.nextInt());
        var userTime = calendar.getTimeInMillis();

        if (userTime > currentTime) {
            System.out.println("Эта дата позже текущей");
        }
        else if (userTime < currentTime) {
            System.out.println("Эта дата раньше текущей");
        }
        else {
            System.out.println("Это та же дата");
        }
    }
}

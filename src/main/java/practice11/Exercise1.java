package practice11;

import java.util.Calendar;

public class Exercise1 {
    public static void main(String[] args) {
        System.out.println("Костенко");

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        System.out.println("Дата получения: " + calendar.getTime());

        calendar.setTimeInMillis(System.currentTimeMillis());
        System.out.println("Дата сдачи: " + calendar.getTime());
    }
}

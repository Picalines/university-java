package practice26.exercise3;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var hashMap = new HashMap<Integer, Object>();

        for (int i = 0; i < 100; i++) {
            hashMap.put(i, "Integer #" + i);
        }

        while (true) {
            System.out.print("Enter element key (0..99) or -1 to exit:\n> ");
            int index = new Scanner(System.in).nextInt();

            if (index < 0) {
                System.out.println("[Exit]");
                return;
            }

            if (!hashMap.containsKey(index)) {
                System.out.println("No element with key " + index + " was found");
                continue;
            }

            System.out.println("Element value: " + hashMap.get(index));

            System.out.println("(removing element)");
            hashMap.remove(index);
        }
    }
}

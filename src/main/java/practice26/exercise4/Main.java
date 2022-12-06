package practice26.exercise4;

import java.util.PriorityQueue;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        var queue = new PriorityQueue<Integer>();

        System.out.println("Добавляю случайные элементы в очередь:");
        var random = new Random();

        for (int i = 0; i < 10; i++) {
            var element =random.nextInt(100);
            queue.add(element);
            System.out.println(element);
        }

        System.out.println("Достаю элементы из очереди:");
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}

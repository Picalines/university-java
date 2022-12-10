package practice32;

import java.io.*;

public class Test {
    private static final String SERIALIZATION_PATH = "objects.ser";

    public static void main(String[] args) {
        Order order = new TableOrder();
        order.add(new Dish("Meatballs", "Tasty meatballs", 500));
        order.add(new Dish("Pasta", "Tasty pasta", 400));

        var tableOrdersManager = new TableOrdersManager(5);
        tableOrdersManager.add(order, 1);

        System.out.println("Before serialization:");
        printItems(tableOrdersManager);
        System.out.println();

        try (var out = new ObjectOutputStream(new FileOutputStream(SERIALIZATION_PATH))) {
            out.writeObject(tableOrdersManager);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try (var in = new ObjectInputStream(new FileInputStream(SERIALIZATION_PATH))) {
            tableOrdersManager = (TableOrdersManager) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Deserialized:");
        printItems(tableOrdersManager);
    }

    private static void printItems(OrdersManager ordersManager) {
        int i = 0;
        for (var order : ordersManager.getOrders()) {
            System.out.print("Order #" + (i++));
            if (order == null) {
                System.out.println(" (null)");
                continue;
            }

            System.out.println(":");
            order.getItems().forEach(item -> {
                System.out.print("- ");
                System.out.println(item);
            });
        }
    }
}

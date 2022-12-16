package practice29;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        var restaurantOrder = new RestaurantOrder();
        restaurantOrder.add(new Dish(500, "Meatballs", "Tasty meatballs"));
        restaurantOrder.add(new Dish(400, "Pasta", "Tasty pasta"));

        System.out.println("Restaurant order:");
        System.out.println(Arrays.toString(restaurantOrder.itemNames()));
        var orderManager = new OrderManager();
        try {
            orderManager.add(restaurantOrder, 1);
        } catch (OrderAlreadyException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("successfully added");

        var internetOrder = new InternetOrder();
        internetOrder.add(new Dish(300, "Seafood", "Tasty seafood"));
        internetOrder.add(new Drink(400, "Water", "Not alcohol drink"));

        System.out.println("Internet order:");
        System.out.println(Arrays.toString(internetOrder.itemNames()));

        orderManager = new OrderManager();
        try {
            orderManager.add(internetOrder, "undefined");
        } catch (OrderAlreadyException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("successfully added");
    }
}

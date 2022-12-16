package practice31;

import java.util.HashMap;

public class OrderManager {
    private final HashMap<Integer, RestaurantOrder> restaurantOrders = new HashMap<>();
    private final HashMap<String, InternetOrder> internetOrders = new HashMap<>();

    public void add(RestaurantOrder order, int table) throws OrderAlreadyException {
        if (restaurantOrders.containsKey(table)) {
            throw new OrderAlreadyException(Integer.toString(table));
        }

        restaurantOrders.put(table, order);
    }

    public void addPosition(Item item, int table) throws IllegalAddressException {
        if (!restaurantOrders.containsKey(table)) {
            throw new IllegalAddressException(Integer.toString(table));
        }

        var order = restaurantOrders.get(table);
        order.add(item);
        restaurantOrders.replace(table, order);
    }

    public RestaurantOrder getOrder(int table) {
        return restaurantOrders.get(table);
    }

    public void removeOrder(int table) {
        restaurantOrders.remove(table);
    }

    public void add(InternetOrder order, String address) throws OrderAlreadyException {
        if (internetOrders.containsKey(address)) {
            throw new OrderAlreadyException(address);
        }

        internetOrders.put(address, order);
    }

    public void addPosition(Item item, String address) throws IllegalAddressException {
        if (!internetOrders.containsKey(address)) {
            throw new IllegalAddressException(address);
        }

        var order = internetOrders.get(address);
        order.add(item);
        internetOrders.replace(address, order);
    }

    public InternetOrder getOrder(String address) {
        return internetOrders.get(address);
    }

    public void removeOrder(String address) {
        internetOrders.remove(address);
    }
}

package practice32;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class TableOrdersManager implements OrdersManager, Serializable {
    private final Order[] orders;

    public TableOrdersManager(int maxTables) {
        orders = new Order[maxTables];
    }

    public void add(Order order, int tableNumber) {
        if (tableNumber >= 0 && tableNumber < orders.length && orders[tableNumber] == null) {
            orders[tableNumber] = order;
        }
    }

    public void addItem(MenuItem item, int tableNumber) {
        if (tableNumber >= 0 && tableNumber < orders.length) {
            orders[tableNumber].add(item);
        }
    }

    public Order getOrder(int tableNumber) {
        return tableNumber < 0 || tableNumber >= orders.length ? null : orders[tableNumber];
    }

    public int freeTableNumber() {
        return IntStream.range(0, orders.length)
            .filter(i -> orders[i] == null)
            .findFirst()
            .orElse(-1);
    }

    public ArrayList<Integer> freeTableNumbers() {
        var freeNumbers = new ArrayList<Integer>();
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == null) {
                freeNumbers.add(i);
            }
        }
        return freeNumbers;
    }

    public void remove(int tableNumber) {
        if (tableNumber < orders.length && tableNumber > 0) {
            orders[tableNumber] = null;
        }
    }

    public int remove(Order order) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i] == order) {
                orders[i] = null;
                return i;
            }
        }
        return -1;
    }

    public int removeAll(Order order) {
        int count = 0;
        for (int i = 0; i < orders.length; i++) {
            if (order == orders[i]) {
                orders[i] = null;
                count++;
            }
        }
        return count;
    }

    @Override
    public Order[] getOrders() {
        return orders;
    }

    @Override
    public int itemsQuantity(String itemName) {
        return Arrays.stream(orders).mapToInt(order -> order.itemsQuantity(itemName)).sum();
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        return Arrays.stream(orders).mapToInt(order -> order.itemsQuantity(item)).sum();
    }

    @Override
    public double ordersCostSummary() {
        return Arrays.stream(orders).mapToDouble(Order::totalCost).sum();
    }

    @Override
    public int ordersQuantity() {
        return orders.length;
    }
}

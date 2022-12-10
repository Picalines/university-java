package practice32;

public interface OrdersManager {
    Order[] getOrders();

    int itemsQuantity(String itemName);
    int itemsQuantity(MenuItem item);

    double ordersCostSummary();
    int ordersQuantity();
}

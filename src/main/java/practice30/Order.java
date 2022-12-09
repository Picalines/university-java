package practice30;

import java.util.ArrayList;

public interface Order {
    boolean add(MenuItem item);
    String[] itemsNames();

    boolean remove(MenuItem item);
    boolean remove(String itemName);
    int removeAll(MenuItem item);
    int removeAll(String itemName);

    int itemsQuantity();
    int itemsQuantity(MenuItem item);
    int itemsQuantity(String itemName);

    ArrayList<MenuItem> getItems();
    ArrayList<MenuItem> sortedItemsByCostDesc();

    double totalCost();

    Customer getCustomer();
    void setCustomer(Customer customer);
}

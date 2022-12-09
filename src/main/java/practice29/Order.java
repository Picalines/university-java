package practice29;

import java.util.ArrayList;

public interface Order {
    boolean add(Item item);
    boolean remove(String itemName);
    int removeAll(String itemName);
    int size();
    ArrayList<Item> toArray();
    double totalCost();
    int count(String itemName);
    String[] itemNames();
    ArrayList<Item> toArraySortedByCost();
}

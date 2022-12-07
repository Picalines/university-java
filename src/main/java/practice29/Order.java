package practice29;

public interface Order {
    boolean add(Item item);
    boolean remove(String itemName);
    int removeAll(String itemName);
    int size();
    Item[] toArray();
    double totalCost();
    int count(String itemName);
    String[] itemNames();
    Item[] toArraySortedByCost();
}

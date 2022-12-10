package practice32;

import java.io.Serializable;
import java.util.ArrayList;

public class InternetOrder implements Order, Serializable {
    private final CyclingDoubleList<MenuItem> items = new CyclingDoubleList<>();

    private Customer customer = Customer.NOT_MATURE_UNKNOWN_CUSTOMER;

    @Override
    public boolean add(MenuItem item) {
        return items.add(item);
    }

    @Override
    public String[] itemsNames() {
        var array = new String[itemsQuantity()];

        int i = 0;
        for (var item : items) {
            array[i++] = item.getName();
        }

        return array;
    }

    @Override
    public boolean remove(MenuItem item) {
        return items.remove(item);
    }

    @Override
    public boolean remove(String itemName) {
        return items.remove(item -> item.getName().equals(itemName));
    }

    @Override
    public int removeAll(MenuItem item) {
        return items.removeAll(item);
    }

    @Override
    public int removeAll(String itemName) {
        return items.removeAll(item -> item.getName().equals(itemName));
    }

    @Override
    public int itemsQuantity() {
        return items.size();
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        return items.count(item);
    }

    @Override
    public int itemsQuantity(String itemName) {
        return items.count(item -> item.getName().equals(itemName));
    }

    @Override
    public ArrayList<MenuItem> getItems() {
        return items.toArrayList();
    }

    @Override
    public ArrayList<MenuItem> sortedItemsByCostDesc() {
        var array = getItems();
        array.sort((a, b) -> -Double.compare(a.getCost(), b.getCost()));
        return array;
    }

    @Override
    public double totalCost() {
        double cost = 0;
        for (var item : items) {
            cost += item.getCost();
        }
        return cost;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}

package practice29;

import java.util.ArrayList;

public class RestaurantOrder implements Order {
    private final CyclingDoubleList<Item> items;

    public RestaurantOrder() {
        items = new CyclingDoubleList<>();
    }

    public RestaurantOrder(Item[] items) {
        this.items = new CyclingDoubleList<>(items);
    }

    @Override
    public boolean add(Item item) {
        return items.add(item);
    }

    @Override
    public boolean remove(String itemName) {
        return items.remove(item -> item.name().equals(itemName));
    }

    @Override
    public int removeAll(String itemName) {
        return items.removeAll(item -> item.name().equals(itemName));
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public ArrayList<Item> toArray() {
        return items.toArrayList();
    }

    @Override
    public double totalCost() {
        double cost = 0;
        for (var item : items) {
            cost += item.cost();
        }
        return cost;
    }

    @Override
    public int count(String itemName) {
        int count = 0;

        for (var item : items) {
            if (item.name().equals(itemName)) {
                count++;
            }
        }

        return count;
    }

    @Override
    public String[] itemNames() {
        var array = new String[size()];

        int i = 0;
        for (var item : items) {
            array[i++] = item.name();
        }

        return array;
    }

    @Override
    public ArrayList<Item> toArraySortedByCost() {
        var array = toArray();
        array.sort((a, b) -> -Double.compare(a.cost(), b.cost()));
        return array;
    }
}

package practice29;

import java.util.Arrays;
import java.util.Iterator;

public class InternetOrder implements Order, Iterable<Item> {
    private static class ListItem {
        public Item item;
        public ListItem previous;
        public ListItem next;
    }

    private ListItem firstItem;

    public InternetOrder() {
        firstItem = null;
    }

    public InternetOrder(Item[] items) {
        for (var item : items) {
            add(item);
        }
    }

    @Override
    public boolean add(Item item) {
        if (firstItem == null) {
            firstItem = new ListItem();
            firstItem.item = item;
            firstItem.previous = firstItem.next = firstItem;
            return true;
        }

        var iterator = finiteIterator();
        while (iterator.hasNext()) {
            if (iterator.next().item == item) {
                return false;
            }
        }

        var last = firstItem.previous;

        var newItem = new ListItem();
        newItem.item = item;
        newItem.next = firstItem;
        firstItem.previous = newItem;
        newItem.previous = last;
        last.next = newItem;

        return true;
    }

    @Override
    public boolean remove(String itemName) {
        if (firstItem == null) {
            return false;
        }

        if (firstItem.next == firstItem) {
            if (firstItem.item.name().equals(itemName)) {
                firstItem = null;
                return true;
            }
            return false;
        }

        var iterator = finiteIterator();
        ListItem targetItem = null;
        while (iterator.hasNext()) {
            var currentItem = iterator.next();
            if (currentItem.item.name().equals(itemName)) {
                targetItem = currentItem;
                break;
            }
        }

        if (targetItem == null) {
            return false;
        }

        if (targetItem == firstItem) {
            var prev = firstItem.previous;
            firstItem = firstItem.next;
            prev.next = firstItem;
            firstItem.previous = prev;
        } else if (targetItem.next == firstItem) {
            targetItem.previous.next = firstItem;
            firstItem.previous = targetItem.previous;
        } else {
            var temp = targetItem.next;
            targetItem.previous.next = temp;
            temp.previous = targetItem.previous;
        }

        return true;
    }

    @Override
    public int removeAll(String itemName) {
        int count = 0;
        while (remove(itemName)) {
            count++;
        }
        return count;
    }

    @Override
    public int size() {
        int count = 0;

        var iterator = finiteIterator();
        while (iterator.hasNext()) {
            count++;
            iterator.next();
        }

        return count;
    }

    @Override
    public Item[] toArray() {
        var array = new Item[size()];

        int i = 0;

        var iterator = finiteIterator();
        while (iterator.hasNext()) {
            array[i++] = iterator.next().item;
        }

        return array;
    }

    @Override
    public double totalCost() {
        double cost = 0;

        var iterator = finiteIterator();
        while (iterator.hasNext()) {
            cost += iterator.next().item.cost();
        }

        return cost;
    }

    @Override
    public int count(String itemName) {
        int count = 0;

        var iterator = finiteIterator();
        while (iterator.hasNext()) {
            if (iterator.next().item.name().equals(itemName)) {
                count++;
            }
        }

        return count;
    }

    @Override
    public String[] itemNames() {
        var array = new String[size()];

        int i = 0;

        var iterator = finiteIterator();
        while (iterator.hasNext()) {
            array[i++] = iterator.next().item.name();
        }

        return array;
    }

    @Override
    public Item[] toArraySortedByCost() {
        var array = toArray();

        Arrays.sort(array, (a, b) -> -Double.compare(a.cost(), b.cost()));

        return array;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<>() {
            private ListItem currentItem = firstItem;

            @Override
            public boolean hasNext() {
                return currentItem != null;
            }

            @Override
            public Item next() {
                var item = currentItem.item;
                currentItem = currentItem.next;
                return item;
            }
        };
    }

    public Iterator<ListItem> finiteIterator() {
        return new Iterator<>() {
            private ListItem currentItem = firstItem;
            private boolean first = true;

            @Override
            public boolean hasNext() {
                return currentItem != null && (first || currentItem != firstItem);
            }

            @Override
            public ListItem next() {
                var item = currentItem;
                currentItem = currentItem.next;
                first = false;
                return item;
            }
        };
    }

    public static void main(String[] args) {
        var order = new InternetOrder();

        var b = new Drink(11, "b", "b_desc");

        order.add(new Drink(10, "a", "a_desc"));
        order.add(b);
        order.add(new Drink(12, "c", "c_desc"));

        order.remove(b.name());

        for (var item : order) {
            System.out.println(item);
        }
    }
}

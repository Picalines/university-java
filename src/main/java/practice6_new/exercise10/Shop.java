package practice6_new.exercise10;

import practice6_new.exercise3.Nameable;
import practice6_new.exercise4.Priceable;
import practice6_new.exercise6_9.Printable;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Shop implements Printable {
    private record Item<T extends Nameable & Priceable>(T object) { }

    private final ArrayList<Item<?>> items;

    public Shop() {
        items = new ArrayList<>();
    }

    public <T extends Nameable & Priceable> void addItem(T obj) {
        items.add(new Item<>(obj));
    }

    public <T extends Nameable & Priceable> boolean removeItemIf(Predicate<T> filter) {
        for (var item : items) {
            var obj = (T)item.object;
            if (obj != null && filter.test(obj)) {
                return items.remove(item);
            }
        }

        return false;
    }

    @Override
    public void print() {
        System.out.println(items.size() + " items:");

        for (var item : items) {
            System.out.println("* \"" + item.object.getName() + "\" for " + item.object.getPrice());
            if (item.object instanceof Printable printable) {
                printable.print();
            }
        }
    }
}

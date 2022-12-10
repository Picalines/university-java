package practice32;

import java.io.Serializable;
import java.util.Iterator;

public class InternetOrdersManager implements OrdersManager, Serializable {
    private static class QueueNode implements Serializable {
        public QueueNode next;
        public QueueNode prev;
        public Order value;

        public QueueNode(QueueNode prev, Order value, QueueNode next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private QueueNode head = null;
    private QueueNode tail = null;
    int size = 0;

    @Override
    public Order[] getOrders() {
        var orders = new Order[size];
        var iterator = iterator();
        int i = 0;
        while (iterator.hasNext()) {
            orders[i++] = iterator.next().value;
        }
        return orders;
    }

    @Override
    public int itemsQuantity(String itemName) {
        int count = 0;
        var iterator = iterator();
        while (iterator.hasNext()) {
            count += iterator.next().value.itemsQuantity(itemName);
        }
        return count;
    }

    @Override
    public int itemsQuantity(MenuItem item) {
        int count = 0;
        var iterator = iterator();
        while (iterator.hasNext()) {
            count += iterator.next().value.itemsQuantity(item);
        }
        return count;
    }

    @Override
    public double ordersCostSummary() {
        int count = 0;
        var iterator = iterator();
        while (iterator.hasNext()) {
            count += iterator.next().value.totalCost();
        }
        return count;
    }

    @Override
    public int ordersQuantity() {
        int count = 0;
        var iterator = iterator();
        while (iterator.hasNext()) {
            count++;
            iterator.next();
        }
        return count;
    }

    public boolean add(Order order, Customer customer) {
        size++;
        if (head == null) {
            head = new QueueNode(null, order, null);
            tail = head;
        } else {
            tail.next = new QueueNode(tail, order, null);
            tail = tail.next;
        }
        return true;
    }

    public Order remove() {
        size--;
        var oldHead = head;
        if (head.next != null) {
            head = head.next;
        } else {
            head = null;
            tail = null;
        }
        return oldHead.value;
    }

    public Order order() {
        return head.value;
    }

    private Iterator<QueueNode> iterator() {
        return new Iterator<>() {
            private QueueNode nextNode = head;

            @Override
            public boolean hasNext() {
                return nextNode != null;
            }

            @Override
            public QueueNode next() {
                var next = nextNode;
                nextNode = nextNode.next;
                return next;
            }
        };
    }
}

package practice30;

public class QueueNode {
    public QueueNode next;
    public QueueNode prev;
    public Order value;

    public Customer customer;

    QueueNode(Order value, Customer customer, QueueNode prev) {
        this.prev = prev;
        this.value = value;
        this.customer = customer;
        next = null;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }
}

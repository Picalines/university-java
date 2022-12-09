package practice30;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

public class CyclingDoubleList<T> implements Iterable<T> {
    private static class Node<T> {
        public T value;
        public Node<T> next;
        public Node<T> previous;
    }

    private Node<T> firstNode;

    public CyclingDoubleList() {
        firstNode = null;
    }

    public boolean add(T value) {
        if (firstNode == null) {
            firstNode = new Node<>();
            firstNode.value = value;
            firstNode.previous = firstNode.next = firstNode;
            return true;
        }

        var iterator = finiteNodeIterator();
        while (iterator.hasNext()) {
            if (iterator.next().value == value) {
                return false;
            }
        }

        var last = firstNode.previous;

        var newNode = new Node<T>();
        newNode.value = value;
        newNode.next = firstNode;
        firstNode.previous = newNode;
        newNode.previous = last;
        last.next = newNode;

        return true;
    }

    public boolean remove(Predicate<T> predicate) {
        if (firstNode == null) {
            return false;
        }

        if (firstNode.next == firstNode) {
            if (predicate.test(firstNode.value)) {
                firstNode = null;
                return true;
            }
            return false;
        }

        var iterator = finiteNodeIterator();
        Node<T> targetItem = null;
        while (iterator.hasNext()) {
            var currentItem = iterator.next();
            if (predicate.test(currentItem.value)) {
                targetItem = currentItem;
                break;
            }
        }

        if (targetItem == null) {
            return false;
        }

        if (targetItem == firstNode) {
            firstNode = firstNode.next;
            firstNode.previous.next = firstNode;
        } else if (targetItem.next == firstNode) {
            targetItem.previous.next = firstNode;
            firstNode.previous = targetItem.previous;
        } else {
            targetItem.previous.next = targetItem.next;
            targetItem.next.previous = targetItem.previous;
        }

        return true;
    }

    public boolean remove(T value) {
        return remove(element -> element == value);
    }

    public int removeAll(Predicate<T> predicate) {
        int count = 0;
        while (remove(predicate)) {
            count++;
        }
        return count;
    }

    public int removeAll(T value) {
        return removeAll(element -> element == value);
    }

    public int count(Predicate<T> predicate) {
        int count = 0;

        for (T t : this) {
            if (predicate.test(t)) {
                count++;
            }
        }

        return count;
    }

    public int count(T value) {
        return count(element -> element == value);
    }

    public int size() {
        return count(element -> true);
    }

    public ArrayList<T> toArrayList() {
        var array = new ArrayList<T>(size());
        for (T item : this) {
            array.add(item);
        }
        return array;
    }

    @Override
    public Iterator<T> iterator() {
        var nodeIterator = finiteNodeIterator();
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return nodeIterator.hasNext();
            }

            @Override
            public T next() {
                return nodeIterator.next().value;
            }
        };
    }

    private Iterator<Node<T>> finiteNodeIterator() {
        return new Iterator<>() {
            private Node<T> currentNode = firstNode;
            private boolean first = true;

            @Override
            public boolean hasNext() {
                return currentNode != null && (first || currentNode != firstNode);
            }

            @Override
            public Node<T> next() {
                var node = currentNode;
                currentNode = currentNode.next;
                first = false;
                return node;
            }
        };
    }
}

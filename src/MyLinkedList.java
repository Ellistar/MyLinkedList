import java.util.LinkedList;

public class MyLinkedList<T> {
    static class Node<T> {
        T element;
        Node<T> next;

        public Node(T element) {
            this.element = element;
        }
    }

    private Node<T> first;
    private Node<T> last;
    private int size;

    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if (first == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    public T remove(int index) {
        T removeElement;
        if (index == 0) {
            removeElement = first.element;
            first = first.next;
            if (first == null) {
                last = null;
            }
        } else {
            Node<T> prev = getNodeIndex(index - 1);
            removeElement = prev.element;
            prev.next = prev.next.next;
            if (index == size - 1) {
                last = prev;
            }
        }
            size--;
            return removeElement;
        }

        public T get(int index) {
        return getNodeIndex(index).element;
        }

    public void clear() {
        for (Node<T> x = first; x != null; ) {
            Node<T> next = x.next;
            x.next = null;
            x = next;
        }
        size = 0;
        first = last = null;

    }

    public int size() {
        return size;
    }

    public Node<T> getNodeIndex(int index) {
        Node<T> current = first;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }
}

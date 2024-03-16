package collections;
public class LinkedList<T> {

    private Node<T> head;

    public void prepend(T i) {
        Node<T> node = new Node<>(i);
        if (head != null) {
            node.setNext(head);
        }
        head = node;
    }

    public void append(T i) {
        Node<T> node = new Node<>(i);

        if (head == null) {
            head = node;
        }

        Node<T> current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(node);
    }

    public void deleteWithValue(T t) {
        if (head.getData() == t) {
            head = head.getNext();
            return;
        }

        Node<T> current = head;
        while (current.getNext() != null && current.getNext().getData() != t) {
            current = current.getNext();
        }

        current.setNext(current.getNext().getNext());
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        Node<T> current = head;
        while (current != null) {
            sb.append(current).append(", ");
            current = current.getNext();
        }
        System.out.println(sb);
    }
}

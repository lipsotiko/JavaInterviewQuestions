package collections;

public class Node<T> {

    private final T data;

    private Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public String toString() {
        return data.toString();
    }

    public T getData() {
        return data;
    }
}

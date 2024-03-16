package collections;

import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void test() {
        LinkedList<String> ll = new LinkedList<>();

        ll.prepend("Hello");
        ll.prepend("World");
        ll.prepend("Neat");
        ll.append("End");
        ll.print();

        ll.deleteWithValue("World");
        ll.print();

        ll.deleteWithValue("Neat");
        ll.print();

        ll.deleteWithValue("End");
        ll.print();
    }

}

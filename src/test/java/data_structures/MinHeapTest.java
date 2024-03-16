package data_structures;


import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinHeapTest {

    @Test
    @SneakyThrows
    public void test() {
        int[] nums = {9, 4, 8, 9, 7, 10, 3, 15, 20, 13};

        MinHeap minHeap = new MinHeap();

        for(int n : nums) {
            minHeap.add(n);
        }

        minHeap.print();

        assertEquals(3, minHeap.peek());
        assertEquals(3, minHeap.poll());
        assertEquals(4, minHeap.poll());
        assertEquals(7, minHeap.poll());

        minHeap.add(3);
        assertEquals(3, minHeap.poll());
    }

}

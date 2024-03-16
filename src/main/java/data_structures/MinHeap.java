package data_structures;

import java.util.Arrays;

public class MinHeap {
    private int capacity = 10;
    private int size;
    private int[] heap = new int[capacity];

    private int getLeftChildIdx(int parentIdx) {
        return 2 * parentIdx + 1;
    }

    private int getRightChildIdx(int parentIdx) {
        return 2 * parentIdx + 2;
    }

    private int getParentIdx(int childIndex) {
        return (childIndex == 1) ? 0 : (childIndex + 1) / 2;
    }

    private boolean hasLeftChild(int idx) {
        return getLeftChildIdx(idx) < size;
    }

    private boolean hasRightChild(int idx) {
        return getRightChildIdx(idx) < size;
    }

    private boolean hasParent(int idx) {
        return getParentIdx(idx) >= 0;
    }

    private int leftChild(int idx) {
        return heap[getLeftChildIdx(idx)];
    }

    private int rightChild(int idx) {
        return heap[getRightChildIdx(idx)];
    }

    private int parent(int idx) {
        return heap[getParentIdx(idx)];
    }

    private void swap(int idxOne, int idxTwo) {
        int temp = heap[idxOne];
        heap[idxOne] = heap[idxTwo];
        heap[idxTwo] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek() throws IllegalAccessException {
        if (size == 0) throw new IllegalAccessException();
        return heap[0];
    }

    public int poll() throws IllegalAccessException {
        if (size == 0) throw new IllegalAccessException();
        int item = heap[0];
        heap[0] = heap[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item) {
        ensureExtraCapacity();
        heap[size] = item;
        size++;
        heapifyUp();
    }

    private void heapifyUp() {
        int idx = size - 1;
        while (hasParent(idx) && parent(idx) > heap[idx]) {
            swap(getParentIdx(idx), idx);
            idx = getParentIdx(idx);
        }
    }

    private void heapifyDown() {
        int idx = 0;
        while (hasLeftChild(idx)) {
            int smallerChildIdx = getLeftChildIdx(idx);
            if (hasRightChild(idx) && rightChild(idx) < leftChild(idx)) {
                smallerChildIdx = getRightChildIdx(idx);
            }

            if (heap[idx] < heap[smallerChildIdx]) {
                break;
            } else {
                swap(idx, smallerChildIdx);
            }

            idx = smallerChildIdx;
        }
    }

    public void print() {
        int idx = 0;
        int level = 1;

        StringBuilder sb = new StringBuilder();

        boolean complete = false;
        while (!complete) {
            for (int i = 0; i < level; i++) {
                if (hasParent(idx) && idx == 0) {
                    sb.append("| ").append(parent(idx)).append("    |").append("\n");
                }

                String children = "| ";

                if (hasLeftChild(idx)) {
                    if (hasLeftChild(idx)) {
                        children += leftChild(idx);
                    } else {
                        children += "  ";
                    }
                }

                children += "  ";

                if (hasRightChild(idx)) {
                    if (hasRightChild(idx)) {
                        children += rightChild(idx) + " |";
                    } else {
                        children += " |";
                    }
                }

                sb.append(children);
                idx += 1;
            }

            if (idx >= size - 1) {
                complete = true;
            }

            System.out.println(sb);

            sb = new StringBuilder();

            level = level * 2;
        }
    }
}

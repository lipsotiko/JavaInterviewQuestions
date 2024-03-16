package sorting;

public class TopDownMergeSort {

    // Visualization:
    // https://developer.nvidia.com/blog/merge-sort-explained-a-data-scientists-algorithm-guide/
    public int[] mergesort(int[] array) {
        int[] tmp = new int[array.length];
        mergesort(array, tmp, 0, array.length - 1);
        return tmp;
    }

    private void mergesort(int[] array, int[] tmp, int leftStart, int rightEnd) {
        if (leftStart >= rightEnd) {
            return;
        }

        int middle = (leftStart + rightEnd) / 2;
        mergesort(array, tmp, leftStart, middle);
        mergesort(array, tmp, middle + 1, rightEnd);
        mergeHalves(array, tmp, leftStart, rightEnd);
    }

    private void mergeHalves(int[] array, int[] tmp, int leftStart, int rightEnd) {
        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int size = rightEnd - leftStart + 1;

        int left = leftStart;
        int right = rightStart;
        int index = leftStart;

        while (left <= leftEnd && right <= rightEnd) {
            if (array[left] <= array[right]) {
                tmp[index] = array[left];
                left++;
            } else {
                tmp[index] = array[right];
                right++;
            }

            index++;
        }

        if (leftEnd - left + 1 > 0) {
            System.arraycopy(array, left, tmp, index, leftEnd - left + 1);
        }

        if (rightEnd - right + 1 > 0) {
            System.arraycopy(array, right, tmp, index, rightEnd - right + 1);
        }

        System.arraycopy(tmp, leftStart, array, leftStart, size);
    }

}

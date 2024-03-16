package sorting;

public class BubbleSort {

    public int[] sort(int[] items) {
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for(int i = 0; i < items.length - 1; i++) {
                if (items[i] > items[i + 1]) {
                    int tmp = items[i + 1];
                    items[i + 1] = items[i];
                    items[i] = tmp;
                    sorted = false;
                }
            }
        }
        return items;
    }
}

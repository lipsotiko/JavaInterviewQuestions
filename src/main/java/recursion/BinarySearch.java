package recursion;

public class BinarySearch {

    public boolean recursiveSearch(int[] numbers, int find) {
        return recursiveSearch(numbers, find, 0, numbers.length - 1);
    }

    private boolean recursiveSearch(int[] numbers, int find, int left, int right) {
        int mid = (left == 0) ? right / 2 : (right - left) / 2;
        mid = left + mid;

        if (numbers[mid] == find || numbers[left] == find || numbers[right] == find) {
            return true;
        } else if (numbers[left] > find || find > numbers[right]) {
            return false;
        } else if (numbers[mid] < find) {
            return recursiveSearch(numbers, find, mid, right);
        } else {
            return recursiveSearch(numbers, find, left, mid);
        }
    }

    public boolean iterativeSearch(int[] numbers, int find) {
        int left = 0;
        int right = numbers.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) / 2);
            if (numbers[mid] == find || numbers[left] == find || numbers[right] == find) {
                return true;
            } else if (numbers[left] > find || find > numbers[right]) {
                return false;
            } else if (numbers[mid] < find) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return false;
    }

}

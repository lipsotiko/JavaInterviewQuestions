package arrays;

public class MergeSortedArrays {

    void merge(int[] nums1, int m, int[] nums2, int n) {
        int endOfNum1 = m - 1;
        int endOfNum2 = n - 1;
        int resultIndex = m + n - 1;

        while(endOfNum2 >= 0) {
            if (endOfNum1 >= 0 && nums1[endOfNum1] >= nums2[endOfNum2]) {
                nums1[resultIndex--] = nums1[endOfNum1--];
            } else {
                nums1[resultIndex--] = nums2[endOfNum2--];
            }
        }
    }
}

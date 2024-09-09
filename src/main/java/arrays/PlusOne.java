package arrays;

public class PlusOne {

    public int[] plusOne(int[] nums) {
        if (nums[nums.length-1] == 9) {
            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == 9) {
                    nums[i] = 0;
                } else {
                    nums[i] += 1;
                    return nums;
                }
            }
            int[] bigger = new int[nums.length + 1];
            bigger[0] = 1;
            nums = bigger;
        } else {
            nums[nums.length-1] += 1;
            return nums;
        }

        return nums;
    }
}

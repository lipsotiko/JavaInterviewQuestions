package arrays;

import org.junit.Assert;
import org.junit.Test;

public class PlusOneTest {

    @Test
    public void test() {
        PlusOne po = new PlusOne();

        int[] nums = {1, 2, 3};
        int[] result = po.plusOne(nums);
        int[] expected = {1, 2, 4};
        Assert.assertArrayEquals(expected, result);

        nums = new int[]{1, 2, 9};
        result = po.plusOne(nums);
        expected = new int[]{1, 3, 0};
        Assert.assertArrayEquals(expected, result);

        nums = new int[]{1, 9, 9};
        result = po.plusOne(nums);
        expected = new int[]{2, 0, 0};
        Assert.assertArrayEquals(expected, result);

        nums = new int[]{9, 9, 9};
        result = po.plusOne(nums);
        expected = new int[]{1, 0, 0, 0};
        Assert.assertArrayEquals(expected, result);

    }
}

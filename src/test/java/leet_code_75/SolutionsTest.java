package leet_code_75;

import junit.framework.TestCase;
import org.junit.Assert;

public class SolutionsTest extends TestCase {

    Solutions sln = new Solutions();

    public void testReverseVowels() {
        assertEquals("holle", sln.reverseVowels("hello"));
        assertEquals("leotcede", sln.reverseVowels("leetcode"));
        assertEquals("ia", sln.reverseVowels("ai"));
        assertEquals("aA", sln.reverseVowels("Aa"));
        assertEquals("Marge, let's \"went.\" i awaIt news telegram.",
                sln.reverseVowels("Marge, let's \"went.\" I await news telegram."));
    }

    public void testMoveZeroes() {
        int[] nums2 = {0, 1, 0, 3, 12};
        int[] expected2 = {1, 3, 12, 0, 0};
        sln.moveZeroes(nums2);
        assertArray(expected2, nums2);

        int[] nums = {0, 0, 1};
        sln.moveZeroes(nums);
        int[] expected = {1, 0, 0};
        assertArray(expected, nums);

        int[] nums3 = {0, 1, 1, 0};
        sln.moveZeroes(nums3);
        int[] expected3 = {1, 1, 0, 0};
        assertArray(expected3, nums3);

        int[] nums4 = {4, 2, 4, 0, 0, 3, 0, 5, 1, 0};
        sln.moveZeroes(nums4);
        int[] expected4 = {4, 2, 4, 3, 5, 1, 0, 0, 0, 0};
        assertArray(expected4, nums4);
    }

    private void assertArray(int[] expected, int[] results) {
        assert expected.length == results.length;

        for (int i = 0; i < expected.length; i++) {
            assertEquals(expected[i], results[i]);
        }
    }

    public void testFindMaxAverage() {
        int[] nums = {8860,-853,6534,4477,-4589,8646,-6155,-5577,-1656,-5779,-2619,-8604,-1358,-8009,4983,7063,3104,-1560,4080,2763,5616,-2375,2848,1394,-7173,-5225,-8244,-809,8025,-4072,-4391,-9579,1407,6700,2421,-6685,5481,-1732,-8892,-6645,3077,3287,-4149,8701,-4393,-9070,-1777,2237,-3253,-506,-4931,-7366,-8132,5406,-6300,-275,-1908,67,3569,1433,-7262,-437,8303,4498,-379,3054,-6285,4203,6908,4433,3077,2288,9733,-8067,3007,9725,9669,1362,-2561,-4225,5442,-9006,-429,160,-9234,-4444,3586,-5711,-9506,-79,-4418,-4348,-5891};
        assertEquals(-594.58065, sln.findMaxAverage(nums, 93));
    }

    public void testUnderstand_maxLevelSum_iterative() {
        TreeNode root = new TreeNode();

        root.val = -100;
        root.left = new TreeNode();
        root.left.val = -200;

        root.right = new TreeNode();
        root.right.val = -300;

        root.left.left = new TreeNode();
        root.left.left.val = -20;

        root.left.right = new TreeNode();
        root.left.right.val = -5;

        root.right.left = new TreeNode();
        root.right.left.val = -10;

        assertEquals(3, sln.maxLevelSum_iterative(root));
    }

    public void testUnderstand_maxLevelSum_recursive() {
        TreeNode root = new TreeNode();

        root.val = -100;
        root.left = new TreeNode();
        root.left.val = -200;

        root.right = new TreeNode();
        root.right.val = -300;

        root.left.left = new TreeNode();
        root.left.left.val = -20;

        root.left.right = new TreeNode();
        root.left.right.val = -5;

        root.right.left = new TreeNode();
        root.right.left.val = -10;

        assertEquals(3, sln.maxLevelSum_recursive(root));

        root = new TreeNode();

        root.val = 1;
        root.left = new TreeNode();
        root.left.val = 7;

        root.right = new TreeNode();
        root.right.val = 0;

        root.left.left = new TreeNode();
        root.left.left.val = 7;

        root.left.right = new TreeNode();
        root.left.right.val = -8;

        assertEquals(2, sln.maxLevelSum_recursive(root));
    }
}

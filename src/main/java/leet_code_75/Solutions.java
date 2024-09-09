package leet_code_75;

import java.util.*;

public class Solutions {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int maxLength = Math.max(word1.length(), word2.length());

        for (int i = 0; i < maxLength; i++) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i));
            }

            if (i < word2.length()) {
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }

    public String gcdOfStrings(String str1, String str2) {
        int occurances = 0;
        String result = "";
        for (int i = 0; i < str2.length() + 1; i++) {
            String subStr = str2.substring(0, i);
            int l = str1.length() - str1.replaceAll(str2.substring(0, i), "").length();
            if (l >= occurances
                    && str1.replaceAll(subStr, "").isEmpty()
                    && str2.replaceAll(subStr, "").isEmpty()
            ) {
                result = subStr;
                occurances = l;
            }
        }
        return result;
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int greatest = 0;
        for (int j : candies) {
            if (j > greatest) {
                greatest = j;
            }
        }

        List<Boolean> results = new ArrayList<>();
        for (int candy : candies) {
            results.add(candy + extraCandies >= greatest);
        }

        return results;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }

        if (flowerbed.length == 1) {
            return n == 1 && flowerbed[0] == 0;
        }

        for (int i = 0; i < flowerbed.length; i++) {
            if (i == 0) {
                if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n -= 1;

                    if (n == 0) {
                        return true;
                    }
                }
            } else if (flowerbed.length - 1 == i) {
                if (flowerbed[i - 1] == 0 && flowerbed[i] == 0) {
                    flowerbed[i] = 1;
                    n -= 1;

                    return n == 0;
                }

                return false;
            } else if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                flowerbed[i] = 1;
                n -= 1;

                if (n == 0) {
                    return true;
                }
            }
        }

        return false;
    }


    public String reverseVowels(String s) {
        int k = s.length() - 1;

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                for (int j = k; j >= i; j--) {
                    if (isVowel(s.charAt(j))) {
                        String tmpA = s.substring(i, i + 1);
                        String tmpB = s.substring(j, j + 1);

                        s = setCharacterAtIndex(j, tmpA, s);
                        s = setCharacterAtIndex(i, tmpB, s);
                        k = j - 1;
                        break;
                    }
                }
            }
        }
        return s;
    }

    private boolean isVowel(char c) {
        return List.of('A', 'a', 'E', 'e', 'I', 'i', 'O', 'o', 'U', 'u').contains(c);
    }

    private String setCharacterAtIndex(int index, String c, String s) {
        return s.substring(0, index) + c + s.substring(index + 1);
    }

    public void moveZeroes(int[] nums) {
        int zeros = 0;
        for (int n : nums) {
            if (n == 0) {
                zeros++;
            }
        }

        while (containsZeros(nums, zeros)) {
            // if first is zero shift and continue
            while (nums[0] == 0) {
                for (int j = 0; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
            }

            if (!containsZeros(nums, zeros)) {
                break;
            }

            int nextZeroIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    nextZeroIndex = i;
                    break;
                }
            }

            for (int j = nextZeroIndex; j < nums.length - 1; j++) {
                nums[j] = nums[j + 1];
            }
        }

        for (int i = zeros; i != 0; i--) {
            nums[nums.length - i] = 0;
        }
    }

    private boolean containsZeros(int[] nums, int zeros) {
        for (int i = 0; i < nums.length - zeros; i++) {
            if (nums[i] == 0) {
                return true;
            }
        }
        return false;
    }

    public double findMaxAverage(int[] nums, int k) {
        double max = -10000000000.0;

        if (k == 1 && nums.length == 1) {
            return nums[0];
        }

        for (int i = 0; i <= nums.length - k; i++) {
            int tmp = 0;
            int tmpK = k - 1;
            while (tmpK >= 0) {
                tmp += nums[tmpK + i];
                tmpK--;
            }

            double t = (double) tmp / k;
            if (t > max) {
                max = t;
            }
        }

        return (double) Math.round(max * 100000) / 100000;
    }

    public int largestAltitude(int[] gain) {
        int maximumGain = 0, currentGain = 0;
        for (int v : gain) {
            currentGain += v;
            maximumGain = Math.max(maximumGain, currentGain);
        }
        return maximumGain;
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> num1Set = new HashSet<>();
        Set<Integer> num2Set = new HashSet<>();

        for (int n1 : nums1) {
            num1Set.add(n1);
        }

        for (int n2 : nums2) {
            num2Set.add(n2);
        }

        List<Integer> nums1Results = new ArrayList<>();
        List<Integer> nums2Results = new ArrayList<>();

        for (Integer n1 : num1Set) {
            if (!num2Set.contains(n1)) {
                nums1Results.add(n1);
            }
        }

        for (Integer n2 : num2Set) {
            if (!num1Set.contains(n2)) {
                nums2Results.add(n2);
            }
        }

        return List.of(nums1Results, nums2Results);
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> nums = new HashMap<>();

        for (int i : arr) {
            nums.merge(i, 1, Integer::sum);
        }

        Set<Integer> occurences = new HashSet<>();
        nums.forEach((k, v) -> {
            occurences.add(v);
        });

        return nums.size() == occurences.size();
    }

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty() && !t.isEmpty()) {
            return true;
        }

        for (int i = 0; i < t.length(); i++) {
            if (s.isEmpty()) {
                break;
            }

            if (s.substring(0, 1).equals(t.substring(i, i + 1))) {
                s = s.substring(1);
            }
        }

        return s.isEmpty();
    }

    public int maxDepth(TreeNode root) {
        return count(root, 0);
    }

    private int count(TreeNode root, int count) {
        if (root == null) {
            return count;
        }

        count++;

        return Math.max(count(root.left, count), count(root.right, count));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Queue<Integer> q1 = new LinkedList<>();
        doItAgain(root1, q1);

        Queue<Integer> q2 = new LinkedList<>();
        doItAgain(root2, q2);

        System.out.println(q1);
        System.out.println(q2);
        return queueCompare(q1, q2);
    }

    private void doItAgain(TreeNode root, Queue<Integer> q) {
        if (root.left == null && root.right == null) {
            q.add(root.val);
        }

        if (root.left != null) {
            doItAgain(root.left, q);
        }
        if (root.right != null) {
            doItAgain(root.right, q);
        }
    }

    private boolean queueCompare(Queue<Integer> q1, Queue<Integer> q2) {
        if (q1.size() != q2.size()) {
            return false;
        }

        while (!q1.isEmpty()) {
            int tmpA = q1.remove();
            int tmpB = q2.remove();
            if (tmpA != tmpB) {
                return false;
            }
            ;
        }

        return q2.isEmpty();
    }

    public TreeNode searchBST(TreeNode root, int val) {
        return find(root, val);
    }

    private TreeNode find(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (root.val == val) {
            return root;
        }

        if (root.val < val) {
            return find(root.right, val);
        } else {
            return find(root.left, val);
        }
    }

    public int guessNumber(int n) {
        int start = 1;
        int end = n;

        if (guess(start) == 0) {
            return start;
        }

        if (guess(end) == 0) {
            return end;
        }

        while (start <= end) {
            int mid = end - (end - start) / 2;
            int result = guess(mid);

            if (result == -1) {
                end = mid;
            } else if (result == 1) {
                start = mid;
            } else {
                return mid;
            }
        }

        return -1;
    }

    private int guess(int n) {
        int pick = 4;
        return Integer.compare(pick, n);
    }

    public int tribonacci(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return tri(n, memo);
    }

    private int tri(int n, Map<Integer, Integer> memo) {
        if (n == 0) {
            return 0;
        }
        if (n > 0 && n <= 2) {
            return 1;
        }

        if (memo.get(n) == null) {
            int result = tri(n - 1, memo) + tri(n - 2, memo) + tri(n - 3, memo);
            memo.put(n, result);
        }

        return memo.get(n);
    }

    public int pivotIndex(int[] nums) {
        for (int i = nums.length; i >= 0; i--) {
            System.out.println("idx");
            System.out.println(i);

            if (i == 0 && sum(nums, 1, nums.length) == 0) {
                return 0;
            }

            if (i == 0) {
                continue;
            }

            if (sum(nums, 0, nums.length - i) == sum(nums, nums.length + 1 - i, nums.length)) {
                return nums.length - i;
            }
        }

        return -1;
    }

    private int sum(int[] nums, int start, int end) {
        int sum = 0;
        for (int j = start; j < end; j++) {
            sum += nums[j];
        }
        return sum;
    }

    public int pivotIndex2(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }

        rightSum -= nums[0];

        if (leftSum == rightSum) {
            return 0;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            rightSum -= nums[i + 1];
            leftSum += nums[i];

            if (leftSum == rightSum) {
                return i + 1;
            }
        }

        return -1;
    }

    public int minCostClimbingStairs_top_down(int[] cost) {
        for (int i = cost.length - 3; i >= 0; i--)
            cost[i] += Math.min(cost[i + 1], cost[i + 2]);
        return Math.min(cost[0], cost[1]);
    }

    public int minCostClimbingStairs_bottom_up(int[] cost) {
        int n = cost.length;
        int[] opt = new int[n + 1];
        opt[0] = 0; // init
        opt[1] = 0;
        for (int i = 2; i <= n; ++i) {
            opt[i] = Math.min(opt[i - 1] + cost[i - 1], opt[i - 2] + cost[i - 2]);
        }
        return opt[n];
    }

    public int minCostClimbingStairs_memoized_recursion(int[] cost) {
        int n = cost.length;

        Map<Integer, Integer> memo = new HashMap<>();
        // if (n == 0 || n == 1) return 0; // this check is unnecessary, consider why?
        return minCost(n, cost, memo); // i = 0...n
    }

    private int minCost(int i, int[] cost, Map<Integer, Integer> memo) {
        Integer memoVal = memo.get(i);

        if (memoVal != null) {
            return memoVal;
        }

        if (i == 0 || i == 1) { // base case: two starting points
            return 0; // notice: 0 instead of cost[i], consider why? The cost is added in the recurrence
        }
        int f1 = minCost(i - 2, cost, memo) + cost[i - 2];
        int f2 = minCost(i - 1, cost, memo) + cost[i - 1];

        memo.put(i, Math.min(f1, f2));

        return memo.get(i);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<TreeNode> toVisit = new ArrayList<>();
        List<Integer> results = new ArrayList<>();

        toVisit.add(root);

        if (root != null) {
            results.add(root.val);
        }

        while (!toVisit.isEmpty()) {
            toVisit = printLevel(toVisit);

            TreeNode lastNode = (!toVisit.isEmpty()) ? toVisit.getLast() : null;

            if (lastNode != null) {
                results.add(lastNode.val);
            }
        }

        return results;
    }

    private List<TreeNode> printLevel(List<TreeNode> toVisit) {
        List<TreeNode> newToVisit = new ArrayList<>();

        for (TreeNode node : toVisit) {
            if (node == null) {
                continue;
            }
            if (node.left != null) {
                newToVisit.add(node.left);
            }

            if (node.right != null) {
                newToVisit.add(node.right);
            }
        }

        return newToVisit;
    }

    public int maxLevelSum_iterative(TreeNode root) {
        List<TreeNode> toVisit = new ArrayList<>();

        toVisit.add(root);

        if (root == null) {
            return 0;
        }

        int maxLevel = 1;
        if (root.left == null && root.right == null) {
            return maxLevel;
        }

        int level = 2;
        int max = root.val;

        while (true) {
            List<TreeNode> tmp = new ArrayList<>();

            for (TreeNode node : toVisit) {
                if (node.left != null) {
                    tmp.add(node.left);
                }

                if (node.right != null) {
                    tmp.add(node.right);
                }
            }

            if (tmp.isEmpty()) {
                break;
            }

            int tmpMax = 0;
            for (TreeNode node : tmp) {
                tmpMax += (node != null) ? node.val : 0;
            }

            if (tmpMax > max) {
                max = tmpMax;
                maxLevel = level;
            }

            toVisit = tmp;
            level++;
        }

        return maxLevel;
    }

    public int maxLevelSum_recursive(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        Map<Integer, Integer> mm = new HashMap<>();
        dfs(root, 0, mm);

        int tmpMaxSum = Integer.MIN_VALUE;
        int maxLevel = 1;
        for (Map.Entry<Integer, Integer> entry : mm.entrySet()) {
            if (entry.getValue() > tmpMaxSum) {
                tmpMaxSum = entry.getValue();
                maxLevel = entry.getKey() + 1;
            }
        }

        return maxLevel;
    }

    private void dfs(TreeNode node, int level,  Map<Integer, Integer> mm) {
        if (node == null) {
            return;
        }

        mm.put(level, mm.getOrDefault(level, 0) + node.val);

        level++;

        dfs(node.left, level, mm);
        dfs(node.right, level, mm);
    }

    // https://www.geeksforgeeks.org/deletion-in-binary-search-tree/
    public TreeNode deleteNode(TreeNode root, int key) {

        // Base case
        if (root == null) {
            return root;
        }

        // If key to be searched is in a subtree
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            // If root matches with the given key

            // Cases when root has 0 children or
            // only right child
            if (root.left == null) {
                return root.right;
            }

            // When root has only left child
            if (root.right == null) {
                return root.left;
            }

            // When both children are present
            TreeNode succ = getSuccessor(root);
            root.val = succ.val;
            root.right = deleteNode(root.right, succ.val);
        }
        return root;
    }

    // Note that it is not a generic inorder successor
    // function. It mainly works when the right child
    // is not empty, which is the case we need in BST
    // delete.
    static TreeNode getSuccessor(TreeNode curr) {
        curr = curr.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    int goodNodesCount = 0;
    public int goodNodes(TreeNode root) {
        countGood(root, root.val);
        return goodNodesCount;
    }

    public void countGood(TreeNode root, int previous) {
        if (root == null) {
            return;
        }

        if (root.val >= previous) {
            previous = root.val;
            goodNodesCount++;
        }

        countGood(root.left, previous);
        countGood(root.right, previous);
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int rootSum = dfs(root, targetSum);
        int leftSum = dfs(root.left, targetSum);
        int rightSum = dfs(root.right, targetSum);
        return rootSum + leftSum + rightSum;
    }

    private int dfs(TreeNode node, int targetSum) {
        if (node == null) {
            return 0;
        }

        int sum = 0;
        if (targetSum == node.val) {
            sum++;
        }

        sum += dfs(node.left, targetSum - node.val);
        sum += dfs(node.right, targetSum - node.val);
        return sum;
    }
}

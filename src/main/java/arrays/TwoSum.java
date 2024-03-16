package arrays;

public class TwoSum {
    public static int[] twoSum(int[] arr, int goal) {
        int[] arrayDiff = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            arrayDiff[i] = goal - arr[i];
        }


        for(int i = 0; i < arr.length; i++) {
            if (arr[i] + arrayDiff[i] == goal) {
                int bIdx = indexOf(arrayDiff[i], arr);
                if (i > bIdx && bIdx != -1) {
                    return new int[] {bIdx, i};
                }
            }
        }

        return new int[]{};
    }

    private static int indexOf(int v, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (v == arr[i]) {
                return i;
            }
            i++;
        }

        return -1;
    }

}

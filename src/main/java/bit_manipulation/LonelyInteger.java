package bit_manipulation;

public class LonelyInteger {

    int findLonely(int[] items) {
        int result = 0;
        for (int i : items) {
            result ^= i;
        }
        return result;
    }
}

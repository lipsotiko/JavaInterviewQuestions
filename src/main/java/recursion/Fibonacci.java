package recursion;

import java.util.*;

class Fibonacci {

    private final Set<Integer> results = new HashSet<>();
    private final Map<Integer, Integer> memo = new HashMap<>();

    int fibonacci(int n) {
        if (n <= 1) {
            results.add(n);
            return n;
        }
        int nextFibNumber = fibonacci(n - 2) + fibonacci(n - 1);
        results.add(nextFibNumber);
        return nextFibNumber;
    }

    int fibonacciMemoized(int n) {
        if (n <= 0) {
            memo.put(0, 0);
        } else if (n ==1) {
            memo.put(1, 1);
        } else if (memo.get(n) == null) {
            int nextFibNumber = fibonacciMemoized(n - 2) + fibonacciMemoized(n - 1);
            memo.put(n, nextFibNumber);
        }

        return memo.get(n);
    }

    Collection<Integer> getResults() {
        return results;
    }

    Collection<Integer> getMemoizedResults() {
        return memo.values();
    }
}

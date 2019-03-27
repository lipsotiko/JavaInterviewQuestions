package recursion;

import java.util.HashSet;
import java.util.Set;

class Fibonacci {

    private Set<Integer> results = new HashSet<>();

    int fibonacci(int nthFibNumber) {
        if(nthFibNumber <= 1) {
            results.add(nthFibNumber);
            return nthFibNumber;
        }
        int nextFibNumber = fibonacci(nthFibNumber - 2) + fibonacci(nthFibNumber - 1);
        results.add(nextFibNumber);
        return nextFibNumber;
    }

    Set<Integer> getResults() {
        return results;
    }
}

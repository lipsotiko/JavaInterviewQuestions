package recursion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FibonacciTest {

    @Test
    public void fibonacci_sequence_with_recursion() {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.fibonacci(7);

        Collection<Integer> results = fibonacci.getResults();
        assertTrue(results.contains(0));
        assertTrue(results.contains(1));
        assertTrue(results.contains(2));
        assertTrue(results.contains(3));
        assertTrue(results.contains(5));
        assertTrue(results.contains(8));
        assertTrue(results.contains(13));
    }

    @Test
    @Timeout(1)
    public void fibonacci_sequence_with_memoization() {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.fibonacciMemoized(500);

        Collection<Integer> results = fibonacci.getMemoizedResults();
        assertTrue(results.contains(0));
        assertTrue(results.contains(1));
        assertTrue(results.contains(2));
        assertTrue(results.contains(3));
        assertTrue(results.contains(5));
        assertTrue(results.contains(8));
        assertTrue(results.contains(13));
    }
}

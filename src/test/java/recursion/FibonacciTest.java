package recursion;

import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FibonacciTest {

    @Test
    public void fibonacci_sequence_with_recursion() {
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.fibonacci(6);

        Set<Integer> results = fibonacci.getResults();
        assertEquals(6, results.size());
        assertTrue(results.contains(0));
        assertTrue(results.contains(1));
        assertTrue(results.contains(2));
        assertTrue(results.contains(3));
        assertTrue(results.contains(5));
        assertTrue(results.contains(8));
    }
}

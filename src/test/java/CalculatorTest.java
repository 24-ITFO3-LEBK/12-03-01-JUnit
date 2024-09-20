import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3), "2 + 3 sollte 5 ergeben");
    }

    @Test
    public void testSubtract() {
        assertEquals(1, calculator.subtract(5, 4), "5 - 4 sollte 1 ergeben");
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3), "2 * 3 sollte 6 ergeben");
    }

    @Test
    public void testDivide() {
        assertEquals(2, calculator.divide(6, 3), "6 / 3 sollte 2 ergeben");
    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 0));
        assertEquals("Cannot divide by zero.", exception.getMessage());
    }

    @Test
    public void testGenerateFibonacciIsEmpty() {
        assertEquals(0, calculator.generateFibonacci(0).length, "Das Array von Fibonacci Zahlen ist leer");
    }

    @Test
    public void testGenerateFibonacciIsNotEmpty() {
        assertNotEquals(0, calculator.generateFibonacci(10).length, "Das Array von Fibonacci Zahlen ist nicht leer");
    }

    @Test
    public void testGenerateFibonacciWithMultipleCases() {
        // Array of test cases: {Input, ExpectedOutput}
        Object[][] testCases = {
                {1, new int[]{0}},
                {2, new int[]{0, 1}},
                {3, new int[]{0, 1, 1}},
                {4, new int[]{0, 1, 1, 2}},
                {5, new int[]{0, 1, 1, 2, 3}},
                {10, new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34}}
        };

        for (Object[] testCase : testCases) {
            int input = (int) testCase[0];
            int[] expected = (int[]) testCase[1];

            int[] result = calculator.generateFibonacci(input);

            assertArrayEquals(expected, result, "Die Fibonacci Zahlen von " + input + " sind " + Arrays.toString(expected));
        }
    }

    @Test
    public void testGenerateFibonacciTimeout() {
        assertTimeout(ofMillis(1), () -> calculator.generateFibonacci(10000), "Die Fibonacci Zahlen von 10.000 können innerhalb einer 1 Millisekunde berechnet werden");
    }
}
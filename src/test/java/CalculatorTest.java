import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void onTestStart() {
        calculator = new Calculator();
    }

    @AfterEach
    public void onTestEnd() {
        System.out.println("Test abgeschlossen");
    }

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
        assertEquals(5, calculator.divide(10, 2), "10 / 2 sollte 5 ergeben");
    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });

        assertEquals("Cannot divide by zero.", exception.getMessage());
    }

    @Test
    public void testGenerateFibonacciNotNull() {
        assertNotNull(calculator.generateFibonacci(5));
    }

    @Test
    public void testGenerateFibonacciForArg0() {
        int[] fib = calculator.generateFibonacci(0);
        assertEquals(0, fib.length);
    }

    @Test
    public void testGenerateFibonacciResult() {
        int[] fib = calculator.generateFibonacci(2);
        assertArrayEquals(fib, new int[]{0, 1});
    }

    @Test
    public void testGenerateFibonacciArray() {
        assertArrayEquals(calculator.generateFibonacci(2), new int[]{0, 1});
        assertArrayEquals(calculator.generateFibonacci(3), new int[]{0, 1, 1});
        assertArrayEquals(calculator.generateFibonacci(4), new int[]{0, 1, 1, 2});
        assertArrayEquals(calculator.generateFibonacci(5), new int[]{0, 1, 1, 2, 3});
    }

    @Test
    public void testGenerateFibonacciCheckTimeout() {
        assertTimeout(Duration.ofMillis(1000), () -> {
            calculator.generateFibonacci(100000000);
        });
    }
}
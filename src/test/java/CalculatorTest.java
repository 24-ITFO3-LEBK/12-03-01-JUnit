import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

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
            calculator.generateFibonacci(100_000_000);
        });
    }

    @Test
    void testPower() {
        assertEquals(8, calculator.power(2, 3));
    }

    @Test
    void testPowerExpZero() {
        assertEquals(1, calculator.power(5, 0));
    }

    @Test
    void testPowerNegative() {
        assertEquals(0.04, calculator.power(5, -2));
    }

    @Test
    void testFactorial() {
        assertEquals(120, calculator.factorial(5));
    }

    @Test
    void testFactorialZero() {
        assertEquals(1, calculator.factorial(0));
    }

    @Test
    public void testFactorialNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.factorial(-5);
        });
        assertEquals(exception.getMessage(), "Eingabewert darf nicht negativ sein.");
    }

    @Test
    void testGcd() {
        assertEquals(15, calculator.gcd(45, 30));
    }

    @Test
    void testIsPrime() {
        assertTrue(calculator.isPrime(3));
        assertTrue(calculator.isPrime(5));
        assertTrue(calculator.isPrime(7));
        assertTrue(calculator.isPrime(59));
        assertTrue(calculator.isPrime(33179));
    }

    @Test
    void testIsNotPrime() {
        assertFalse(calculator.isPrime(1));
        assertFalse(calculator.isPrime(60));
        assertFalse(calculator.isPrime(120000));
    }

    @Test
    void testSqrt() {
        assertEquals(3, calculator.sqrt(9));
        assertTrue(1.413 < calculator.sqrt(2) && calculator.sqrt(2) < 1.415);
    }

    @Test
    public void testSqrtNegative() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.sqrt(-5);
        });
        assertEquals(exception.getMessage(), "Negative Zahlen sind ungültig.");
    }

    @Test
    public void testSum() {
        assertEquals(60, calculator.sum(new int[]{10, 20, 30}));
    }

    @Test
    public void testAvg() {
        assertEquals(20, calculator.avg(new int[]{10, 20, 30}));
    }

    @Test
    public void testMax() {
        assertEquals(1000, calculator.max(new int[]{10, 200, 100, 5, 1000, 30}));
    }

    @Test
    public void testMin() {
        assertEquals(5, calculator.min(new int[]{10, 200, 100, 5, 1000, 30}));
    }

    @Test
    public void testOddNumbers() {
        List<Integer> list = List.of(100);
        assertEquals(list, calculator.evenNumbers(new Integer[]{19, 100, 5, 7}));
    }

    @Test
    public void testSquareRootArray() {
        List<Double> list = List.of(10.0, 6.0);
        assertEquals(list, calculator.squareRoot(new Integer[]{19, 100, 5, 7, 36}));
    }

    @Test
    public void testPowerEvenNumbers() {
        HashMap<Double,Double> map = new HashMap<>();
        map.put(100.0, 10000.0);
        assertEquals(map, calculator.powerEvenNumbers(new Integer[]{100}));
    }
}
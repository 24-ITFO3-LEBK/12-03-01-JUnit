import org.junit.jupiter.api.Test;
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
        assertEquals(6, calculator.divide(18, 3), "18 / 3 sollte 6 ergeben");
    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 0)); assertEquals("Cannot divide by zero.", exception.getMessage()); }

    @Test
    public void testFibNotNull() {
        assertNotNull(calculator.generateFibonacci(5), "Für n > 0 sollte der array nicht Null sein.");
    }
    @Test
    public void testFibEmpty() {
        assertEquals(0, calculator.generateFibonacci(0).length, "Der Array sollte leer sein.");
    }
    @Test
    public void testFibFirstTwo() {
        assertEquals(0, calculator.generateFibonacci(3)[0], "Die erste Stelle sollte 0 sein.");
        assertEquals(1, calculator.generateFibonacci(3)[1], "Die zweite Stelle sollte 1 sein.");
    }
    @Test
    public void testFibFirstFive() {
        assertArrayEquals(new int[] { 0, 1, 1, 2, 3}, calculator.generateFibonacci(5), "Das Ergebnis sollten die ersten fünf Stellen der Fibonacci-Reihe sein.");
    }
}
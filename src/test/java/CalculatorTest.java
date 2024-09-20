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
        assertEquals(2, calculator.divide(10, 5), "10 / 5 sollte 2 ergeben");
    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
        assertEquals("Cannot divide by zero.", exception.getMessage());
    }

    @Test
    public void testFibGreaterZero(){assertNotNull(calculator.generateFibonacci(6));}

    @Test
    public void testFibEqualsZero(){assertArrayEquals(new int[] {},calculator.generateFibonacci(0));}

    @Test
    public void testTwoLeadingNumbers(){assertArrayEquals(new int[] {0,1}, calculator.generateFibonacci(2));}
}

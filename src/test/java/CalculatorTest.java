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
    	assertEquals(4, calculator.divide(8, 2), "8 : 2 sollte 4 ergeben");
    }
    
    @Test
    public void testGenerateFibonacciForNull() {
    	assertFalse(calculator.generateFibonacci(1) == null);
    }
    
    @Test
    public void testGenerateFibonacciForZero() {
    	assertFalse(calculator.generateFibonacci(1).length == 0);
    }
    
    @Test
    public void testGenerateFibonacciFirstTwoValues() {
    	assertTrue(calculator.generateFibonacci(2)[0] == 0);
    	assertTrue(calculator.generateFibonacci(2)[1] == 1);
    }
}
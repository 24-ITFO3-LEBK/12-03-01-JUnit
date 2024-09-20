import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    @BeforeEach
    public void initEach(){
        Calculator calculator = new Calculator();
    }

    private final Calculator calculator = new Calculator();

    @AfterEach
    public void each(){
        System.out.println("Abgeschlossen");
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
    public void testDivision() {
        assertEquals(6, calculator.divide(18, 3), "18 / 3 sollte 6 ergeben");
    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });
        assertEquals("Cannot divide by zero.", exception.getMessage());
    }

    @Test
    public void testFibonacciEdgecases(){
        assertNotEquals(null, calculator.generateFibonacci(4), "Fibonacci nicht null");
        assertEquals(0, calculator.generateFibonacci(0).length);
        assertArrayEquals(new int[]{0,1}, calculator.generateFibonacci(2));
    }

    @Test
    public void testFibonacci(){
        assertArrayEquals(new int[]{0,1,1,2,3}, calculator.generateFibonacci(5));
        assertArrayEquals(new int[]{0,1,1,2,3,5,8}, calculator.generateFibonacci(7));
    }
}
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
        assertEquals(8, calculator.divide(40, 5), "40 / 5 sollte 8 ergeben");
    }

    @Test
    public void testGenerateFibonacciNotNull() {
        assertNotNull(calculator.generateFibonacci(3));
    }

    @Test
    public void testGenerateFibonacciEmpty() {

    }

    @Test
    public void testPower() {
        assertEquals(27, calculator.power(3, 3));
    }

    @Test
    public void testPowerNegative() {
        assertEquals(0.0625, calculator.power(2, -4));
    }

    @Test
    public void testPowerNull() {
        assertEquals(1, calculator.power(2, 0));
    }

    @Test
    public void testFactorial() {
        assertEquals(5040, calculator.factorial(7));
    }

    @Test
    public void testFactorialNull() {
        assertEquals(1, calculator.factorial(0));
    }

    @Test
    public void testGcd() {
        assertEquals(6, calculator.gcd(54, 24));
    }

    @Test
    public void testGcdPrime() {
        assertEquals(1, calculator.gcd(17, 19));
    }

    @Test
    public void testIsPrime() {
        assertTrue(calculator.isPrime(19));
    }

    @Test
    public void testIsPrimeFalse() {
        assertFalse(calculator.isPrime(22));
    }

    @Test
    public void testSqrt() {
        assertEquals(3.0, calculator.sqrt(9), 0.0001);
    }

    @Test
    public void testSqrtNegative() {
       // assertEquals(3, calculator.sqrt(-9));
    }
}
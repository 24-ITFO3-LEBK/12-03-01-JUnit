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
        assertEquals(1, calculator.divide(3, 3), "3 / 3 sollte 1 ergeben");
        assertEquals(0, calculator.divide(3, 0), "3 / 0 sollte 0 ergeben");
    }

    @Test
    public  void testGenerateOfFibonacci() {

        //assertArrayEquals(5, );
        //assertArrayEquals(int[], calculator.generateFibonacci() != null);
        assertNotNull(calculator.generateFibonacci(5));

    }

    @Test
    public  void testGenerateOfFibonacciEmpty() {

        assertNotNull(calculator.generateFibonacci(5));

    }

    @Test
    public void testPower() {
        assertEquals(16 ,calculator.power(2, 4));
    }

    @Test
    public void testPowerNegative() {
        assertEquals(0.0625 ,calculator.power(2, -4));
    }

    @Test
    public void testPowerNull() {
        assertEquals(1, calculator.power(2, 0));
    }

    @Test
    public void testFactorial() {
        assertEquals(120, calculator.factorial(5));
    }

    @Test
    public void testFactorialNull() {
        assertEquals(1, calculator.factorial(0));
    }

    @Test
    public void testgcdCalculation() {
        assertEquals(6, calculator.gcdCalculation(54, 24));
    }

    @Test
    public void testgcdCalculation2() {
        assertEquals(1, calculator.gcdCalculation(17, 13));
    }

//    @Test
//    public void testisPrime() {
////        assertFalse(true, calculator.gcdCalculation(11));
//    }
}

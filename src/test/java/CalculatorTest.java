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
    
    @Test
    public void testGenerateFibonacciFirstFiveValues() {
    	assertArrayEquals(calculator.generateFibonacci(5), new int[] {0,1,1,2,3});
    }
    
    @Test
    public void testPowerPos() {
    	assertEquals(8, calculator.power(2, 3), "2³ sollte 8 ergeben");
    }
    
    @Test
    public void testPowerNeg() {
    	assertEquals(0.25, calculator.power(2, -2), "2 hoch -2 sollte 0.25 ergeben");
    }
    
    @Test
    public void testPowerZero() {
    	assertEquals(0, calculator.power(2, 0), "2 hoch 0 sollte 0 ergeben");
    }
    
    @Test
    public void testFactorialZero() {
    	assertEquals(1, calculator.factorial(0), "0! sollte 1 ergeben");
    }
    
    @Test
    public void testFactorialSmallNum() {
    	assertEquals(120, calculator.factorial(5), "5! sollte 120 ergeben");
    }
    
    @Test
    public void testFactorialBigNum() {
    	assertEquals(2432902008176640000L, calculator.factorial(20), "20! sollte 2432902008176640000 ergeben");
    }
    
    @Test
    public void testGCDNum() {
    	assertEquals(6, calculator.gcd(54, 24), "Größte Teilbare zahl für beide Zahlen (54 & 24) sollte 6 sein");
    }
    
    @Test
    public void testGCDPrimeNum() {
    	assertEquals(1, calculator.gcd(47, 29), "Größte Teilbare zahl für beide Zahlen (47 & 29) sollte 1 sein");
    }
    
    @Test
    public void testIsPrimeTrue() {
    	assertTrue(calculator.isPrime(11));
    }
    
    @Test
    public void testIsPrimeFalse() {
    	assertFalse(calculator.isPrime(99));
    }
    
    @Test
    public void testSquareRootFirst() {
    	assertEquals(3, calculator.sqrt(9), 0.0001, "9 durch Wurzel sollte 3 ergeben");
    }
    
    @Test
    public void testSquareRootSec() {
    	assertEquals(5, calculator.sqrt(25), 0.0001, "25 durch Wurzel sollte 5 ergeben");
    }
    
    @Test
    public void testSquareRootNeg() {
    	assertEquals(-1, calculator.sqrt(-10), 0.0001, "10 sollte -1 wiedergeben");
    }
}
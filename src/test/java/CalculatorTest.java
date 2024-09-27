import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void init() {
        System.out.println("Test wird gestartet");
        calculator = new Calculator();
    }

    @AfterEach
    void endTest() {
        System.out.println("Test beendet");
        calculator = null;
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
        assertEquals(6, calculator.divide(30, 5), "30 / 5 sollte 6 ergeben");
    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.divide(2, 0));
        String actuallyMessages = exception.getMessage();
        assertTrue(actuallyMessages.contains(Calculator.CANNOT_DIVIDE_BY_ZERO));
    }

    @Test
    public void testEmptyFibilist() {
        //Return a adress that has a empty list.
        //assertEquals(new ArrayList<>(),calculator.generateFibonacci(0),"should return empty list");
        //assertEquals(actually,calculator.generateFibonacci(0),"should return empty list");
        //To actaully test it you have to do somehting like this
        int[] actually = calculator.generateFibonacci(0);
        assertEquals(0, actually.length, "should return empty list");
    }

    @Test
    public void testGenerateFibonacciList() {
        int n = 6;
        int[] actuallyList = calculator.generateFibonacci(n);
        assertEquals(n, actuallyList.length, "a not empty list is returned");
    }

    @Test
    public void testFibonacci() {
        int[] actually = {0, 1, 1, 2, 3, 5};
        int n = 6;
        int[] expectedList = calculator.generateFibonacci(n);
        for (int i = 0; i < n; i++) {
            assertEquals(actually[i], expectedList[i], "should be" + actually[i]);
        }
    }

    @Test
    public void testGenerateSpeedOfFibonacciList() {
        int n = 100;
        for (int i = 0; i < n; i++) {
            int finalI = i;
            assertTimeout(Duration.ofSeconds(1), () -> {
                calculator.generateFibonacci(finalI);
            });
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10, 20})
    void testParameterizedFiboTest(int n) {
        int[] actually = calculator.generateFibonacci(n);
        assertEquals(n, actually.length, "Die Anzahl der Elemente = Länge der Liste");
    }

    @ParameterizedTest
    @ValueSource(ints = 10)
    void testParameterizedFiboTestWithOneValue(int n) {
        int[] expected = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34};
        int[] actualList = calculator.generateFibonacci(n);
        assertEquals(actualList.length, expected.length, "Gleiche Menge an Elementen");
        for (int i = 0; i < n; i++) {
            assertEquals(actualList[i], expected[i], "should be" + actualList[i]);
        }
    }

    @Test
    public void testPotenz() {
        assertEquals(8, calculator.potenz(2, 3), "2^3 = 8");
    }

    @Test
    public void testPotenzZero() {
        assertEquals(1, calculator.potenz(5, 0), "5^0 = 1");
    }

    @Test
    public void testNegativePotenz() {
        assertEquals(0.125, calculator.potenz(2, -3), "2^-3 = 0.125");
    }

    @Test
    public void testFakultaet() {
        assertEquals(120, calculator.factorial(5), "!5 = 120");
    }

    @Test
    public void testFakultaet2() {
        assertEquals(3628800, calculator.factorial(10), "!10 = 3.628.800");
    }

    @Test
    public void testFakultaetNull() {
        assertEquals(1, calculator.factorial(0), "!0 = 1");
    }

    @Test
    public void testGGT() {
        assertEquals(6, calculator.gcd(54,24), "der ggt ist 6");
    }
    public void testGGT2() {
        assertEquals(54, calculator.gcd(54,432), "der ggt ist 54");
    }
    public void testGGT3() {
        assertEquals(1, calculator.gcd(54,33), "der ggt ist 1");
    }

    @Test
    public void testIsPrime() {
        assertTrue( calculator.isPrime(11), "wahr");
    }
    @Test
    public void testIsNotPrime() {
        assertFalse( calculator.isPrime(4), "wahr");
    }
    @Test
    public void testIsPrimeTwo() {
        assertTrue( calculator.isPrime(97), "wahr");
    }
    @Test
    public void testIsPrime3() {
        assertTrue( calculator.isPrime(3), "wahr");
    }
    @Test
    public void testIsPrime4() {
        assertTrue( calculator.isPrime(2), "wahr");
    }
}
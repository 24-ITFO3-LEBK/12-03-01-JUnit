import org.junit.jupiter.api.*;
import java.time.Duration;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void createNewTestObject() {
        calculator = new Calculator();
        System.out.println("Starting test");
    }

    @AfterEach
    public void finishTest() {
        System.out.println("Finished test");
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
    public void testDivide_ShouldReturnExpectedResult()
    {
        int expectedResult = 5;
        assertEquals(expectedResult, calculator.divide(10, 2), "10 / 2 should return 5");
    }

    @Test
    public void testDivideWithZero_ShouldThrow()
    {
        Class<IllegalArgumentException> expectedException = IllegalArgumentException.class;
        assertThrowsExactly(expectedException, () -> calculator.divide(10, 0), "Number can not be divided by 0");
    }

    @Test
    public void testGenerateFibonacci_ShouldReturnExpectedResult() {
        int[] testResult = calculator.generateFibonacci(5);
        int[] expectedResult = { 0, 1, 1, 2, 3 };
        assertNotNull(testResult);
        assertArrayEquals(testResult, expectedResult);
    }

    @Test
    public void testGenerateFibonacci_WithZero_ShouldReturnEmptyResult() {
        int[] testResult = calculator.generateFibonacci(0);
        int[] expectedResult = {};
        assertArrayEquals(testResult, expectedResult);
    }

    @Test
    public void testGenerateFibonacci_WithHighNumber_ShouldReturnExpectedResultWithinTime() {
        int[] expectedResult = { 0, 1, 1, 2, 3};
        Duration expectedDuration = Duration.ofSeconds(1);

        assertTimeout(expectedDuration, () -> {
            int[] testResult = calculator.generateFibonacci(100);
            int[] slicedTestResult = Arrays.copyOfRange(testResult, 0, 5);
            assertArrayEquals(slicedTestResult, expectedResult);
        });
    }

    @Test
    public void testPower_ShouldReturnExpectedResults() {
        assertEquals(8, calculator.power(2, 3));
        assertEquals(1, calculator.power(5, 0));
        assertEquals(0.125, calculator.power(2, -3));
    }

    @Test
    public void testFactorial_ShouldReturnExpectedResults() {
        assertEquals(120, calculator.factorial(5));
        assertEquals(3_628_800, calculator.factorial(10));
    }

    @Test
    public void testGcd_ShouldReturnExpectedResults() {
        assertEquals(6, calculator.gcd(54, 24));
        assertEquals(1, calculator.gcd(17, 13));
    }

    @Test
    public void isPrime_ShouldReturnExpectedResults() {
        assertTrue(calculator.isPrime(2));
        assertTrue(calculator.isPrime(11));
        assertFalse(calculator.isPrime(4));
        assertFalse(calculator.isPrime(9));
    }

    @Test
    public void sqrt_ShouldReturnExpectedResults() {
        assertEquals(3.0, calculator.sqrt(9));
        assertEquals(1.4, calculator.sqrt(2));
    }

    @Test
    public void sqrt_WithNegativeInput_ShouldThrow() {
        Class<IllegalArgumentException> expectedException = IllegalArgumentException.class;
        assertThrows(expectedException, () -> calculator.sqrt(-1));
    }
}
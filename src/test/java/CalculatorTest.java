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
}
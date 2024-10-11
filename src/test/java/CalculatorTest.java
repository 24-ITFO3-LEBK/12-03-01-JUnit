import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


public class CalculatorTest {

    private  Calculator calculator;

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

    @Test
    public void testCheckWholeFib(){
        assertArrayEquals(new int[] {0,1,1,2,3,5,},calculator.generateFibonacci(6));
        assertArrayEquals(new int[] {0,1,1,2,3,5,8,13},calculator.generateFibonacci(8));
        assertArrayEquals(new int[] {0,1,1,2,3,5,8,13,21,34},calculator.generateFibonacci(10));
        assertArrayEquals(new int[] {0,1,1},calculator.generateFibonacci(3));
        assertArrayEquals(new int[] {0},calculator.generateFibonacci(1));
    }

    @Test
    public void testRuntime(){
        assertTimeout(Duration.ofMillis(1000), () -> { calculator.generateFibonacci(100000000); });
    }

    @Test
    public void testSumme(){
        assertEquals(120, calculator.summe(new int[]{20, 40, 60}));
    }

    @Test
    public void testDurchschnitt(){
        assertEquals(40, calculator.durchschnitt(new int[]{20, 40, 60}));
    }

    @Test
    public void testMaximum(){
        assertEquals(60, calculator.summe(new int[]{20, 40, 60}));
    }

    @Test
    public void testMinimum(){
        assertEquals(20, calculator.summe(new int[]{20, 40, 60}));
    }

    @BeforeEach
    public void onTestStart(){
        calculator = new Calculator();
    }

    @AfterEach
    public void onTestFinished(){
        System.out.print("Test abgeschlossen \n");
    }

}

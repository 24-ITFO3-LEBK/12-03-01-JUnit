import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {

    private Calculator calculator;

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
    public void testNotEquals(){
        assertNotEquals(2,calculator.subtract(5,4));
    }

    @Test
    public void testDivideThrowsException(){
        assertThrows(IllegalArgumentException.class,()->calculator.divide(6,0));
    }

    @Test
    public void testDivide(){
          assertEquals(2,calculator.divide(10,5));
    }

    @Test
    public void testDivideThrowsNoException(){
         assertDoesNotThrow(()->calculator.divide(6,2));
    }

    @Test
    public void testGenerateFibonacciNGreaterZero(){
        assertNotNull(calculator.generateFibonacci(5));

    }

    @Test
    public void testGenerateFibonacciNIsZero(){
        boolean isEmpty = isEmpty(calculator.generateFibonacci(0));
        assertTrue(isEmpty);
    }

    private boolean isEmpty(int[] array){
        return array.length == 0;
    }

    @Test
    public void testGenerateFibonacciFirstTwoValues(){
        int[] fib = calculator.generateFibonacci(5);
                assertEquals(0,fib[0]);
                assertEquals(1,fib[1]);
    }

    @Test
    public void testGenerateFibonacciArrayEquals(){
        int[] expectedArray = new int[]{0,1,1,2,3};
        assertArrayEquals(expectedArray,calculator.generateFibonacci(5));

    }

    @Test
    public void testGenerateFibonacciTimeout(){
        assertTimeout(Duration.ofSeconds(1),()-> calculator.generateFibonacci(3000));
    }

    @BeforeEach
    public void beforeEachMethod(){
         calculator = new Calculator();
    }

    @AfterEach
    public void afterEachMethod(){
       System.out.println("Test abgeschlossen");
    }

}
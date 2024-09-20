import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

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
    public void testDivide(){
        assertEquals(2,calculator.divide(6,3), "6 / 3 sollte 2 ergeben");
        assertEquals(5,calculator.divide(55,11), "55 / 11 sollte 5 ergeben");
    }

    @Test
    public void testGenerateFibonacci() {
        //Aufgabe 1
        assertNotNull(calculator.generateFibonacci(1));
        assertArrayEquals(calculator.generateFibonacci(0), new int[0]);
        assertArrayEquals(calculator.generateFibonacci(2), new int[]{0, 1});
        //Aufgabe 2
        assertArrayEquals(calculator.generateFibonacci(5), new int[]{0, 1, 1, 2, 3});
        assertArrayEquals(calculator.generateFibonacci(10), new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34});
        assertArrayEquals(calculator.generateFibonacci(4), new int[]{0, 1, 1, 2});
        assertArrayEquals(calculator.generateFibonacci(1), new int[]{0});
        assertArrayEquals(calculator.generateFibonacci(-1), new int[]{});
        //Aufgabe 3
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            calculator.generateFibonacci(100000000);
        });
    }
    //Aufgabe 4
    @BeforeEach
    public void newCalc(){
        calculator = new Calculator();
    }

    @AfterEach
    public void testEnd(){
        System.out.println("Test abgeschlossen");
    }

}
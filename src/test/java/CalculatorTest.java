import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private  Calculator calculator = new Calculator();

    @BeforeEach
    public void resetTestInstance(){
        calculator=new Calculator();
    }
    @AfterEach
    public void testLog(){
        System.out.println("Test abgeschlossen");
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
    public void testDivideZero(){assertThrows(IllegalArgumentException.class,()-> calculator.divide(2, 0));}

    @Test
    public void testDivide() {assertEquals(3, calculator.divide(9, 3), "9 / 3 sollte 3 ergeben");}

    @Test
    public void testFibonacci() {
        // Array für n == 0 leer
        assertTrue(calculator.generateFibonacci(0).length == 0);
        //generierte Array für n > 0 nicht null
        assertNotNull(calculator.generateFibonacci(5));
        // die ersten beiden Werte der Fibonacci-Reihe korrekt sind
        assertArrayEquals(calculator.generateFibonacci(2), new int[]{0, 1});

        //unterschiedliche Werte von n zu ueberpruefen
        assertArrayEquals(calculator.generateFibonacci(1),new int[]{0});
        assertArrayEquals(calculator.generateFibonacci(4),new int[]{0,1,1,2});
        assertArrayEquals(calculator.generateFibonacci(5),new int[]{0,1,1,2,3});

        //Fibonacci-Zahlen für groeßere Werte von n innerhalb einer vernuenftigen Zeitspanne erfolgt
        assertTimeout(Duration.ofSeconds(10),() ->calculator.generateFibonacci(100));
    }


}
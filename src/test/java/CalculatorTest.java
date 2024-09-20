import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator;
    @BeforeEach
    void init(){
        calculator = new Calculator();
    }

    @AfterEach
    void teardown() {
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
    public void testDivide() {
        assertEquals(2, calculator.divide(10, 5), "10/5 sollte 2 ergeben");
    }

    @Test
    public void testDivideException() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(3,0), "Division durch Null soll einen Fehler werfen.");
    }

    @Test
    public void testFibNotNull() {
        assertTrue(calculator.generateFibonacci(1).length > 0, "Die Fibunaccifolge sollte nicht leer sein.");
    }

    @Test
    public void testFibNull() {
        assertEquals( 0, calculator.generateFibonacci(0).length, "Die Fibunaccifolge sollte nicht leer sein.");
    }

    @Test
    public void testFirstTwoValues(){
        int[] fibunacci = calculator.generateFibonacci(2);
        assertEquals(fibunacci[0], 0, "Der erste Wert der Fibunaccireihe sollte Null sein");
        assertEquals(fibunacci[1], 1, "Der zweite Wert der Fibunaccireihe sollte Eins sein");
    }

    @Test
    public void testFibAll(){
        int[] fibunacci = calculator.generateFibonacci(45000);
        for(int i = fibunacci.length-1; i>1; i--){
            assertEquals(fibunacci[i-1]+fibunacci[i-2],fibunacci[i]);
        }
    }

    @Test
    public void fibRuntimeTest(){
        assertTimeout(Duration.ofSeconds(1), ()->calculator.generateFibonacci(45000), "Hohe Zahlen sollten innerhalb von einer Sekunde zur Fibonaccireihe umgewandelt werden");    }
    }
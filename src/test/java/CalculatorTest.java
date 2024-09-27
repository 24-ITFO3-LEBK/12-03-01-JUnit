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

    @Test
    public void testPower(){
        assertEquals(32,calculator.power(2,5),"2 ^ 5 sollte 32 ergeben");
        assertEquals(1,calculator.power(15,0),"15 ^ 0 sollte 1 ergeben");
        assertEquals(0.25,calculator.power(2,-2),"2 ^ (-2) sollte 0.25 ergeben");
    }

    @Test
    public void testFac(){
        assertEquals(120,calculator.fac(5), "Die Fakultät von 5 sollte 120 sein");
        assertEquals(1,calculator.fac(0), "Die Fakultät von 0 sollte 1 sein");
        assertNull(calculator.fac(-5), "Die Fakultät von -5 sollte NULL sein");
    }

    @Test
    public void testGcd(){
        assertEquals(6,calculator.gcd(54,24),"Der ggt von 54 und 24 sollte 6 sein");
        assertEquals(50,calculator.gcd(-100,50),"Der ggt von -100 und 50 sollte 50 sein");
        assertEquals(1,calculator.gcd(17,3),"Der ggt von 17 und 3 sollte 1 sein");
        assertEquals(50,calculator.gcd(50,50),"Der ggt von 50 und 50 sollte 50 sein");
    }

    @Test
    public void testIsPrime(){
        assertFalse(calculator.isPrime(-5),"-5 sollte keine Primzahl sein");
        assertFalse(calculator.isPrime(-6),"-6 sollte keine Primzahl sein");
        assertFalse(calculator.isPrime(0),"0 sollte keine Primzahl sein");
        assertFalse(calculator.isPrime(1),"1 sollte keine Primzahl sein");
        assertFalse(calculator.isPrime(9),"9 sollte keine Primzahl sein");
        assertTrue(calculator.isPrime(2),"2 sollte eine Primzahl sein");
        assertTrue(calculator.isPrime(23),"23 sollte eine Primzahl sein");
    }

    @Test
    public void testSqrt(){
        assertNull(calculator.sqrt(-1),"Die Quadratwurzel von -1 sollte NULL sein");
        assertEquals(3.0, calculator.sqrt(9),0.001);
    }
    //Aufgabe 4
    @BeforeEach
    public void newCalc(){
        calculator = new Calculator();
    }

    @AfterEach
    public void testEnd() {
        System.out.println("Test abgeschlossen");
    }

}
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Test
    public void powerTest(){
        assertEquals(calculator.power(2,3), 8.0);
        assertEquals(calculator.power(5,0), 1.0);
        assertEquals(calculator.power(2, -3), 0.125);}

    @Test
    public void factorialTest(){
        assertEquals(calculator.factorial(5), 120);
        assertEquals(calculator.factorial(0), 1);
    }

    @Test
    public void gcdTest(){
        assertEquals(6, calculator.gcd(54, 24));
        assertEquals(1, calculator.gcd(7, 13));
    }

    @Test
    public void isPrimeTest(){
        assertFalse(calculator.isPrime(54));
        assertTrue(calculator.isPrime(7));
    }

    @Test
    public void summeTest(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(6, calculator.summe(list));
    }

    @Test
    public void durchschnittTest() {
        List<Integer> zahlen = List.of(10, 20, 30, 40, 50);
        double erwarteterDurchschnitt = 30.0;
        double result = calculator.durchschnitt(zahlen);
        assertEquals(erwarteterDurchschnitt, result, 0.001, "Der Durchschnitt sollte 30.0 sein.");
    }

    @Test
    public void testFindMaxMitWerten() {
        List<Integer> zahlen = List.of(3, 10, 5, 8, 15);
        int erwartetesMax = 15;
        int result = Calculator.findMax(zahlen);
        assertEquals(erwartetesMax, result, "Der Maximalwert sollte 15 sein.");
    }

    @Test
    public void testFindMin() {
        List<Integer> zahlen = List.of(3, 10, 5, 8, 15);
        int erwartetesMin = 3;
        int result = Calculator.findMin(zahlen);
        assertEquals(erwartetesMin, result, "Der Minimalwert sollte 3 sein.");
    }

    @Test
    public void testFilterGeradeZahlen() {
        List<Integer> zahlen = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> erwarteteGeradeZahlen = List.of(2, 4, 6);
        List<Integer> result = Calculator.filterGeradeZahlen(zahlen);
        assertEquals(erwarteteGeradeZahlen, result, "Die gefilterten Zahlen sollten [2, 4, 6] sein.");
    }

    @Test
    public void testBerechneQuadratwurzelGeraderZahlen() {
        List<Integer> zahlen = List.of(1, 2, 3, 4, 5, 6);
        List<Double> erwarteteQuadratwurzeln = List.of(Math.sqrt(2), Math.sqrt(4), Math.sqrt(6));
        List<Double> result = Calculator.berechneQuadratwurzelGeraderZahlen(zahlen);
        assertEquals(erwarteteQuadratwurzeln, result, "Die Quadratwurzeln sollten [sqrt(2), sqrt(4), sqrt(6)] sein.");
    }

    @Test
    public void testGeradeZahlenUndQuadrate() {
        List<Integer> zahlen = List.of(1, 2, 3, 4, 5, 6);
        Map<Integer, Integer> erwartetesErgebnis = Map.of(
                2, 4,
                4, 16,
                6, 36
        );
        Map<Integer, Integer> result = Calculator.geradeZahlenUndQuadrate(zahlen);
        assertEquals(erwartetesErgebnis, result, "Die Map sollte die geraden Zahlen und ihre Quadrate enthalten.");
    }
    }


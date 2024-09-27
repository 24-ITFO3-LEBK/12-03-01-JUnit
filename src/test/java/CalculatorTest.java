import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static java.time.Duration.ofMillis;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private Calculator calculator = new Calculator();

    @BeforeEach
    void createNewCalculator() {
        calculator = new Calculator();
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
        assertEquals(2, calculator.divide(6, 3), "6 / 3 sollte 2 ergeben");
    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 0));
        assertEquals("Cannot divide by zero.", exception.getMessage());
    }

    @Test
    public void testGenerateFibonacciIsEmpty() {
        assertEquals(0, calculator.generateFibonacci(0).length, "Das Array von Fibonacci Zahlen ist leer");
    }

    @Test
    public void testGenerateFibonacciIsNotEmpty() {
        assertNotEquals(0, calculator.generateFibonacci(10).length, "Das Array von Fibonacci Zahlen ist nicht leer");
    }

    static Stream<Arguments> fibonacciTestCases() {
        return Stream.of(
                Arguments.of(0, new int[]{}),
                Arguments.of(1, new int[]{0}),
                Arguments.of(2, new int[]{0, 1}),
                Arguments.of(3, new int[]{0, 1, 1}),
                Arguments.of(4, new int[]{0, 1, 1, 2}),
                Arguments.of(5, new int[]{0, 1, 1, 2, 3}),
                Arguments.of(10, new int[]{0, 1, 1, 2, 3, 5, 8, 13, 21, 34})
        );
    }

    @ParameterizedTest(name = "Generate Fibonacci for {0}")
    @MethodSource("fibonacciTestCases")
    void testGenerateFibonacciWithMultipleCases(int input, int[] expected) {
        int[] result = calculator.generateFibonacci(input);

        assertArrayEquals(expected, result, "Die Fibonacci Zahlen von " + input + " sind " + Arrays.toString(expected));
    }

    @Test
    public void testGenerateFibonacciTimeout() {
        assertTimeout(ofMillis(1), () -> calculator.generateFibonacci(10000), "Die Fibonacci Zahlen von 10.000 können innerhalb einer 1 Millisekunde berechnet werden");
    }

    // Zuerst habe ich den Testcase für 2^3 und 2^0 hinzugefügt
    // Dann habe ich die power Funktion angelegt und beide Tests dadurch abgedeckt
    // Danach habe ich noch den Case für 2^-3 hinzugefügt
    @Test
    public void testPower() {
        assertEquals(8, calculator.power(2, 3), "2^3 sollte 8 ergeben");
        assertEquals(1, calculator.power(2, 0), "2^0 sollte 1 ergeben");
        assertEquals(0.125, calculator.power(2, -3), "2^-3 sollte 0,125 ergeben");
    }

    // Auch hier hab ich erst die beiden Testcases für 1! und 5! angelegt und dann die Funktion angelegt
    // Zum Schluss habe ich noch einen Test für eine möglichst große Zahl hinzugefügt
    @Test
    public void testFactorial() {
        assertEquals(1, calculator.factorial(0), "Die Fakultät von 0 sollte 1 ergeben");
        assertEquals(120, calculator.factorial(5), "Die Fakultät von 5 sollte 120 ergeben");
        assertEquals(3628800, calculator.factorial(10), "Die Fakultät von 10 sollte 3628800 ergeben");
    }

    // Hier habe ich erst alle Testcases angelegt und hinterher den Code geschrieben, um die Tests auf grün zu bekommen
    @Test
    public void testGcd() {
        assertEquals(6, calculator.gcd(54, 24), "Der größte gemeinsame Teiler von 54 und 24 ist 6");
        assertEquals(6, calculator.gcd(24, 54), "Der größte gemeinsame Teiler von 24 und 54 ist 6");
        assertEquals(1, calculator.gcd(17, 13), "Der größte gemeinsame Teiler von 54 und 24 ist 1, da es Primzahlen sind");
        assertNull(calculator.gcd(20, 0), "Der größte gemeinsame Teiler von 20 und 0 ist null, da es keinen gemeinsamen Teiler gibt");
    }

    @AfterEach
    void afterEachTest(TestInfo testInfo) {
        System.out.println("Test abgeschlossen: " + testInfo.getDisplayName());
    }
}
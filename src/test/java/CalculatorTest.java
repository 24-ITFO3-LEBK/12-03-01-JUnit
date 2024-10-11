import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

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
    public void testdivide() {
        assertEquals(2, calculator.divide(8, 4), "8 / 4 sollte 2 ergeben");
    }

    @Test
    public void testgenerateFibonacci() { assertArrayEquals(new int[]{0,1,1,2,3}, calculator.generateFiboacci(5), "stimm so");}

    @Test
    public void testfibaufnull() {assertNotNull(calculator.generateFiboacci(0));}


    @Test
    public void fibtestduration() {
        assertTimeout(Duration.ofMillis(5000), () -> {
            calculator.generateFiboacci(100);
        });}

    @Test
    public void  Powertestpositive()
    {
        assertEquals(16, calculator.powercalc(2,4));
    }

    @Test
    public void  Powertestnull()
    {
        assertEquals(1, calculator.powercalc(5,0));
    }

    @Test
    public void  Powertestnegative()
    {
        assertEquals(-8, calculator.powercalc(-2,3));
    }

    @Test
    public void  Factestnull()
    {
        assertEquals(1, calculator.factorial(0));
    }


    @Test
    public void  facttest()
    {
        assertEquals(120, calculator.factorial(5));
    }

    @Test
    public void gcd()
    {
        assertEquals(6, calculator.gcd(54, 24));
    }

    @Test
    public void primetest()
    {
        assertTrue(calculator.isPrime(11));
    }

    @Test
    public void primetestfalse()
    {
        assertFalse(calculator.isPrime(6));
    }

    @Test
    public void squaretest() throws Exception {
        assertEquals(3 ,calculator.sqrt(9));
    }

    @Test
    public void squaretestex() throws Exception {
        assertEquals(3 ,calculator.sqrt(-9));
    }


    @Test
    public void squaretestpi() throws Exception {
        assertEquals(1.41, calculator.sqrt(2), 0.2);
    }

    @Test
    public void summetest()
    {
        List<Integer> actual = Arrays.asList(1,2,3,4,7,3);
        assertEquals(20, calculator.CalcSumme( actual ));
    }

    @Test
    public void avrgtest()
    {
        List<Integer> actual = Arrays.asList(1,3,3,1,3,1);
        assertEquals(2.0, calculator.CalcDurch( actual ));
    }

    @Test
    public void MinTest()
    {
        List<Integer> actual = Arrays.asList(1,2,3,4,7,3);
        assertEquals(1 , calculator.CalcMin( actual ));
    }

    @Test
    public void MaxTest()
    {
        List<Integer> actual = Arrays.asList(1,2,3,4,7,3);
        assertEquals(7 , calculator.CalcMax( actual ));
    }
    @Test
    public void EvenTest()
    {
        List<Integer> actual = Arrays.asList(1,2,3,4,7,3);
        List<Integer> actual2 = Arrays.asList(2,4);
        assertEquals(actual2 , calculator.CalcEven( actual ));
    }
}
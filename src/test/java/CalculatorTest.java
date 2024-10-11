import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
        assertEquals(0, calculator.generateFibonacci(0).length);
        //generierte Array für n > 0 nicht null
        assertNotNull(calculator.generateFibonacci(5));
        // die ersten beiden Werte der Fibonacci-Reihe korrekt sind
        assertArrayEquals(calculator.generateFibonacci(2), new int[]{0, 1});

        //unterschiedliche Werte von n zu ueberpruefen
        assertArrayEquals(calculator.generateFibonacci(1),new int[]{0});
        assertArrayEquals(calculator.generateFibonacci(4),new int[]{0,1,1,2});
        assertArrayEquals(calculator.generateFibonacci(5),new int[]{0,1,1,2,3});

        //Fibonacci-Zahlen für groeßere Werte von n innerhalb einer vernuenftigen Zeitspanne erfolgt
        assertTimeout(Duration.ofSeconds(1),() ->calculator.generateFibonacci(100));
    }

    @Test
    public void testExpo() {assertEquals(8, calculator.power(2, 3));}
    @Test
    public void testFacto() {assertEquals(120, calculator.factorial(5));}
    @Test
    public void testFactoNull() {assertEquals(1, calculator.factorial(0));}
    @Test
    public void testggt() {assertEquals(6, calculator.gcd(54, 24));
                           assertEquals(1, calculator.gcd(17, 13));}

    @Test
    public void testPrime(){assertTrue(calculator.isPrime(11));}
    @Test
    public void testPrimeOne(){assertFalse(calculator.isPrime(1));}
    @Test
    public void testNotPrime(){assertFalse(calculator.isPrime(9));}
    @Test
    public void testsqrt(){assertEquals(3.0, calculator.sqrt(9), 0.0001);}
    @Test
    public void testsqrtNegative(){assertThrows(IllegalArgumentException.class,()->calculator.sqrt(-1));}
    List<Integer>b = Arrays.asList(1,2,3,4);
    @Test
    public void testSumOfAll(){assertEquals(10, calculator.sumOfAll(b));}

    @Test
    public void testAverageOfAll(){assertEquals(2.5, calculator.averageOfAll(b));}

    @Test
    public void testMax(){assertEquals(4, calculator.getMaxValue(b));}
    @Test
    public void testMin(){assertEquals(1, calculator.getMinValue(b));}
    @Test
    public void testEven(){assertEquals(Arrays.asList(2,4), calculator.getEvenList(b));}

    @Test
    public void testEvenRoot(){assertEquals(Arrays.asList(2.0,4.0), calculator.getEvenListRoot(Arrays.asList(4,16)));}

    @Test
    public void testEvenRootPower(){assertEquals(Map.of(2,4,4,16), calculator.getEvenSquareMap(Arrays.asList(2,4)));}
}
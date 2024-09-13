import org.junit.jupiter.api.Test;
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
}
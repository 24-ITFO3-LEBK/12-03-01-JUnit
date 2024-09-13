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
    public void testdivide() {
        assertEquals(2, calculator.divide(8, 4), "8 / 4 sollte 2 ergeben");
    }

    @Test
    public void testdivideex() {
        assertEquals(2, calculator.divide(4, 0), "4 / 0 sollte exception ergeben");
    }

}
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
    public void testDivideShouldReturnExpectedResult()
    {
        int expectedResult = 5;
        assertEquals(expectedResult, calculator.divide(10, 2), "10 / 2 should return 5");
    }

    @Test
    public void testDivideWithZeroShouldThrow()
    {
        Class<IllegalArgumentException> expectedException = IllegalArgumentException.class;
        assertThrowsExactly(expectedException, () -> calculator.divide(10, 0), "Number can not be devided by 0");
    }
}
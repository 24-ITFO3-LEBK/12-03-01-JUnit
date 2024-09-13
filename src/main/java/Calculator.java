public class Calculator {
    final static String CANNOT_DIVIDE_BY_ZERO = "Cannot divide by zero.";

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException(CANNOT_DIVIDE_BY_ZERO);
        }
        return (double) a / b;
    }
}
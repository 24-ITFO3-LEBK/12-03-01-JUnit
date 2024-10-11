import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

public class Calculator {
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
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        return (double) a / b;
    }

    public int[] generateFibonacci(int n) {
        if (n <= 0) return new int[] {};
        int[] fib = new int[n];
        fib[0] = 0;
        if (n > 1) {
            fib[1] = 1;
            for (int i = 2; i < n; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }
        return fib;
    }

    public double power(int base, int exponent) {
        return Math.pow(base, exponent);
    }

    public int factorial(int n) {
        int currentFactorial = 1;
        for (; n >= 1; n--) {
            currentFactorial *= n;
        }

        return currentFactorial;
    }

    public int gcd(int lhs, int rhs) {
        int currentDivider = Math.min(lhs, rhs);
        for (; currentDivider > 1; currentDivider--) {
            if (lhs % currentDivider == 0 && (rhs & currentDivider) == 0)
                break;
        }

        return currentDivider;
    }

    public boolean isPrime(int n) {
        for (int divider = n - 1; divider > 1; divider--) {
            if (n % divider == 0)
                return false;
        }

        return true;
    }

    public double sqrt(double n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative values are not allowed");
        }

        double result = Math.sqrt(n);
        return Math.round(result * 10d) / 10d;
    }

    public int sum(List<Integer> numbers)  {
        Stream<Integer> stream = numbers.stream();
        return stream
                .reduce(Integer::sum)
                .orElseThrow(() -> new IllegalArgumentException("List must not be empty"));
    }

    public double avg(List<Integer> numbers)  {
        Stream<Integer> stream = numbers.stream();
        return stream
                .mapToInt(Integer::intValue).average()
                .orElseThrow(() -> new IllegalArgumentException("List must not be empty"));
    }

    public int max(List<Integer> numbers) {
        Stream<Integer> stream = numbers.stream();
        return stream
                .reduce(Integer::max)
                .orElseThrow(() -> new IllegalArgumentException("List must not be empty"));
    }

    public int min(List<Integer> numbers) {
        Stream<Integer> stream = numbers.stream();
        return stream
                .reduce(Integer::min)
                .orElseThrow(() -> new IllegalArgumentException("List must not be empty"));
    }

    public List<Integer> even(List<Integer> numbers) {
        Stream<Integer> stream = numbers.stream();
        return stream.filter(n -> n % 2 == 0).collect(Collectors.toList());
    }
}
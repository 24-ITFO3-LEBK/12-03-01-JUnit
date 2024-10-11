import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        if (n < 0) {
            return new int[]{};
        }
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

    public double power(int a, int b) {
        return Math.pow(a, b);
    }

    public int factorial(int a) {
        int result = 1;
        for (int i = 2; i <= a; i++) {
            result *= i;
        }

        return result;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return this.gcd(b, a%b);
    }

    public boolean isPrime(int a) {
        if (a <= 1) {
            return false;
        }
        for (int i = 2; i < a; i++) {
            if (a % i == 0)
                return false;
        }

        return true;
    }

    public double sqrt(double n) {
        if (n < 0) {

        }
        return Math.sqrt(n);
    }

    /**
     * Gibt die Summe aller Integer im Array zurück
     *
     * @param numberArr / Int Array
     * @return int
     */
    public int sum(Integer[] numberArr) {
        int sum;
        List<Integer> numberList = Arrays.asList(numberArr);
        Stream<Integer> stream = numberList.stream();
        sum = stream.reduce(0, Integer::sum);
        return sum;
    }

    /**
     * Gibt den Durchschnitt aller Integer im Array zurück
     *
     * @param numberArr / Int Array
     * @return double
     */
    public double avg(Integer[] numberArr) {
        List<Integer> numberList = Arrays.asList(numberArr);
        Stream<Integer> stream = numberList.stream();
        IntSummaryStatistics stats = stream.mapToInt((x) -> x).summaryStatistics();
        return stats.getAverage();
    }

    /**
     * Gibt das Maximum aller Integer im Array
     *
     * @param numberArr / Int Array
     * @return int
     */
    public int max(Integer[] numberArr) {
        List<Integer> numberList = Arrays.asList(numberArr);
        Stream<Integer> stream = numberList.stream();
        IntSummaryStatistics stats = stream.mapToInt((x) -> x).summaryStatistics();
        return stats.getMax();
    }

    /**
     * Gibt das Minimum aller Integer im Array zurück
     *
     * @param numberArr / Int Array
     * @return int
     */
    public int min(Integer[] numberArr) {
        List<Integer> numberList = Arrays.asList(numberArr);
        Stream<Integer> stream = numberList.stream();
        IntSummaryStatistics stats = stream.mapToInt((x) -> x).summaryStatistics();
        return stats.getMin();
    }

    /**
     * Entfernt alle ungeraden Zahlen aus einem Array
     *
     * @param numberArr / Int Array
     * @return List<Integer>
     */
    public List<Integer> filterEvenNumbers(Integer[] numberArr) {
        List<Integer> numberList = Arrays.asList(numberArr);
        Stream<Integer> stream = numberList.stream();
        return stream.filter(n -> n % 2 == 0).collect(Collectors.toList());
    }

    /**
     * Entfernt alle ungeraden Zahlen aus einem Array
     * wobei die Zahl der Schlüssel und das Quadrat der Wert wird
     *
     * @param numberArr / Int Array
     * @return List<Integer>
     */
    public List<Integer> filterEvenNumbersSquared(Integer[] numberArr) {
        List<Integer> numberList = Arrays.asList(numberArr);
        Stream<Integer> stream = numberList.stream();
        return stream.filter(n -> n % 2 == 0).map(n -> n * n).collect(Collectors.toList());
    }
}
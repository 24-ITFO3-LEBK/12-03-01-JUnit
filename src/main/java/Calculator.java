import java.util.*;
import java.util.stream.IntStream;
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
        if (n <= 0) return new int[]{};
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
        int fact = 1;

        for (int i = 1; i <= a; i++) {
            fact *= i;
        }

        return fact;
    }

    public Double gcd(int a, int b) {
        if (a == 0 || b == 0) {
            return null;
        }

        int biggerNumber = Math.max(a, b);

        for (int i = biggerNumber; i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                return (double) i;
            }
        }

        return null;
    }

    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public double sqrt(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number have to be positiv.");
        }

        return Math.sqrt(n);
    }

    /**
     * Returns the sum of elements in this list. Use the BinaryOperator for
     * this operation which is equal to the IntStream Interface
     *
     * @return the sum of elements in this list
     */
    public int sum(List<Integer> list) {
        Stream<Integer> stream = list.stream();

        return stream.reduce(0, Integer::sum);
    }

    /**
     * @return the average of elements in this array
     */
    public double average(int[] list) {
        IntStream stream = Arrays.stream(list);

        OptionalDouble average = stream.average();

        if (average.isEmpty()) {
            throw new RuntimeException("Error while calculation average");
        }

        return average.getAsDouble();
    }

    /**
     * @return the maximum value of the elements in this list
     */
    public double max(List<Integer> list) {
        Stream<Integer> stream = list.stream();

        return stream.max(Comparator.comparingInt(a -> a)).orElseThrow();
    }

    /**
     * @return the minimum value of the elements in this list
     */
    public double min(List<Integer> list) {
        Stream<Integer> stream = list.stream();

        return stream.min(Comparator.comparingInt(a -> a)).orElseThrow();
    }

    /**
     * @return the filtered list of even values in the given list
     */
    public List<Integer> filterEven(List<Integer> list) {
        Stream<Integer> stream = list.stream();

        return stream.filter(a -> a % 2 == 0).toList();
    }

    /**
     * @return the mapped list with the positiv square roots of the values in the given list
     */
    public List<Double> mapToSqrt(List<Integer> list) {
        Stream<Integer> stream = list.stream();

        return stream.map(this::sqrt).toList();
    }

    /**
     * @return the map with the number as key and the squared number as value
     */
    public Map<Integer, Double> mapToSquares(List<Integer> list) {
        Stream<Integer> stream = list.stream();

        HashMap<Integer, Double> map = new HashMap<>();

        stream.forEach(n -> map.put(n, power(n, 2)));

        return map;
    }
}
import java.util.List;
import java.util.Map;
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

    public int power(int base, int exponent) {
        return (int) Math.pow(base, exponent);
    }


    public int factorial(int n) {
        int sum = 1;
        if (n == 0) {
            return 1;
        }
        for (int i = n; i > 1; i--) {
            sum = sum * i;
        }

        return sum;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public boolean isPrime(int a) {
        if (a <= 1) {
            return false;
        }
        for (int i = 2; i < a / 2; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static double sqrt(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Negative Numbers are not possible!");
        }
        return Math.sqrt(i);
    }

    public int sumOfAll(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    public double averageOfAll(List<Integer> numbers) {
        double sum = numbers.stream().reduce(0, Integer::sum);
        return sum / numbers.size();
    }

    public int getMaxValue(List<Integer> numbers) {
        return numbers.stream().reduce(Integer::max).get();
    }

    public int getMinValue(List<Integer> numbers) {
        return numbers.stream().reduce(Integer::min).get();
    }

    public List<Integer> getEvenList(List<Integer> numbers) {
        return numbers.stream().filter((n -> n % 2 == 0)).collect(Collectors.toList());
    }

    public List<Double> getEvenListRoot(List<Integer> numbers) {
        Stream<Integer> list = numbers.stream().filter((n -> n % 2 == 0));
        return list.map(Calculator::sqrt).collect(Collectors.toList());
    }

    public Map<Integer, Integer> getEvenSquareMap(List<Integer> numbers) {
        Stream<Integer> listEven = numbers.stream().filter((n -> n % 2 == 0));
        return listEven.collect(Collectors.toMap(v -> v, v -> power(v, 2)));
    }
}
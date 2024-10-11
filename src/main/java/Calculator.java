import java.util.*;
import java.util.stream.Collectors;

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

    public int[] generateFibonacci(int n){
        if (n <= 0) return new int[]{};
        int[] fib = new int [n];
        fib[0] = 0;
        if (n > 1) {
            fib[1] = 1;
            for (int i = 2; i < n; i++) {
                fib[i] = fib[i - 1] + fib[i -2];
            }
        }
        return fib;
    }

    public double power(int base, int exponent) {
        return Math.pow(base, exponent);
    }

    public int factorial(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Eingabewert darf nicht negativ sein.");
        } else if (num == 0) return 1;
        int sum = 0;
        while (num > 1) {
            if (sum == 0) {
                sum = num * (num - 1);
            } else {
                sum = sum * (num - 1);
            }
            num--;
        }
        return sum;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public boolean isPrime(int num) {
        if (num == 0 || num == 1) {
            return false;
        } else if (num == 3) {
            return true;
        }
        int divisor = num / 2;
        boolean isPrime = false;
        while (divisor > 1) {
            if (num % divisor != 0) {
                isPrime = true;
                divisor--;
            } else {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public double sqrt(double i) {
        if (i < 0) {
            throw new IllegalArgumentException("Negative Zahlen sind ungültig.");
        }
        return Math.sqrt(i);
    }

    public int summe(int[] ganzzahlen){
        return Arrays.stream(ganzzahlen).sum();
    }

    public OptionalDouble durchschnitt(int[] ganzzahlen){
        return Arrays.stream(ganzzahlen).average();
    }

    public OptionalInt maximalwert(int[] ganzzahlen){
        return Arrays.stream(ganzzahlen).max();
    }

    public OptionalInt minimalwert(int[] ganzzahlen){
        return Arrays.stream(ganzzahlen).min();
    }

    public List<Integer> geradeZahlen(Integer[] ganzzahlen) {
        return Arrays.stream(ganzzahlen).filter(n -> n % 2 == 0).collect(Collectors.toList());
    }

    public double[] sqrt2(double[] ganzzahlen){
        return Arrays.stream(ganzzahlen).filter(n -> n % 2 == 0).map(this::sqrt).toArray();
    }

    public Map<Double, Double> quadratGeradeZahlen(Integer[] ganzzahlen) {
        List<Integer> integerList = geradeZahlen(ganzzahlen);
        return integerList.stream().collect(Collectors.toMap(
                Integer::doubleValue, n -> power(n,2)
        ));
    }
}
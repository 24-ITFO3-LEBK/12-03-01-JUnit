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
}
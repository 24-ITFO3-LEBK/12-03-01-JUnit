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

    public double divide(int a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException(CANNOT_DIVIDE_BY_ZERO);
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

    public double potenz(double a, int b) {
        double erg;
        if (b == 0) erg = 1;
        else if (b < 0) {
            int posPotenz = b * -1;
            erg = divide(1, potenz(a, posPotenz));
        } else {
            erg = a;
            for (int i = 1; i < b; i++) {
                erg *= a;
            }
        }
        return erg;
    }

    public int factorial(int i) {
        int erg = 1;
        for (int j = 0; j < i; j++) {
            erg = erg * (j+1);
        }
        return erg;
    }


    public int gcd(int a, int b) {
        int i;
        if (a < b)
            i = a;
        else
            i = b;
        for (i = i; i > 1; i--) {
            if (a % i == 0 && b % i == 0)
                return i;
        }
        return 1;
    }

    public boolean isPrime(double a) {
        if (a < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }
}
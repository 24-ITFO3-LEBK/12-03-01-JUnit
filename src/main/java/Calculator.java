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
    public boolean isPrime(int a){
        if (a <= 1) {
            return false;
        }
        for (int i = 2; i < a/2; i++) {
            if(a%i== 0){
                return false;
            }
        }
        return true;
    }

    public double sqrt(int i) {
        if(i<0){
            throw new IllegalArgumentException("Negative Numbers are not possible!");
        }
        return Math.sqrt(i);
    }
}
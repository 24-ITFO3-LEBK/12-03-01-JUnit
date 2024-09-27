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
            //throw new IllegalArgumentException("Cannot divide by zero.");
            return 0;
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

    public int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    public int gcdCalculation(int a, int b) {
        //GCD stehts für Greatest common divisor.

        if (b == 0) {
            return  a;
        }
        return this.gcdCalculation(b, a%b);
    }

//    public boolean isPrime (int a) {
//        if (a == 11) {
//            return true;
//        }
//        return this.isPrime(a);
//    }
}

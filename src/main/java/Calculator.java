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

    public int[] generateFiboacci(int n)
    {
        if (n <= 0) return new int[]{};
        int[] fib = new int[n];
        fib[0] = 0;
        if (n > 1)
        {
            fib[1] = 1;
            for (int i = 2; i < n; i++)
            {
                fib[i]  = fib[i - 1] + fib[i - 2];
            }
        }
        return fib;
    }

    public double powercalc(double a, double b)
    {
        return Math.pow(a , b);
    }

    public double factorial(int number)
    {
        long result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        return result;
    }

    public int gcd(int nummer1, int nummer2)
    {
        if (nummer2 == 0)
        {
            return nummer1;
        }
        return gcd(nummer2, nummer1 % nummer2);
    }

    public boolean isPrime(int a) {
        if(a < 2) {
            return false;
        }
        for(int i = 2; i < a; i++) {
            if(a % i == 0)
                return false;
        }
        return true;
    }

    public double sqrt(double n) throws Exception {
        if (n > 0)
        {
            return Math.sqrt(n);
        }
        else {
            System.out.println("Zahl darf nicht negativ sein");
            throw new Exception("Zahl darf nicht negativ sein");
        }
    }


    
    
}

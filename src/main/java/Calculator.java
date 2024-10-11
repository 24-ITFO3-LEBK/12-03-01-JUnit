import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalInt;
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

    public double divide(int a, int b) throws IllegalArgumentException{
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
        return (double) a / b;
    }

    public int[] generateFibonacci(int n){
        if(n<= 0) return  new int[]{};
        int[] fib = new int[n];
        fib[0] = 0;
        if(n>1){
            fib[1] = 1;
            for (int i = 2; i<n; i++){
                fib[i] = fib[i-1] + fib[i-2];
            }
        }
        return fib;
    }

    public double power(int base, int exponent){
        return Math.pow(base, exponent);
    }

    public int factorial(int n){
        int result = 1;
        while (n > 0){
            result = result * n;
            n--;
        }
        return result;
    }

    public int gcd(int a, int b){
        int c;
        while (a != b) {
            if (a < b) {
                c = a;
                a = b;
                b = c;
            }
            a = a - b;
        }
        return b;}

    public boolean isPrime(int n){
        if (n <= 1)
            return false;
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
        return true;
    }
}
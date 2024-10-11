import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

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
        if(n<= 0) return new int[]{};
        int[] fib = new int[n];
        fib[0]= 0;
        if(n>1){
            fib[1]= 1;
            for(int i = 2; i<n;i++){
                fib[i] = fib[i-1] + fib[i-2];
            }
        }
        return fib;
    }

    public double power(int base ,int exp){
      double power = 1;

        if(exp == 0){
            return 1;
        } else if(exp >0){
            // for-Schleife muss mit 1 gestartet werden
            for(int i = 1; i <= exp;i++){
              power = power * base;
            }
            return power;

        }else{
            //wenn exp negativ, dann mit -1 multiplizieren f. for Schleife
            exp = exp * (-1);
            for(int i = 1; i <= exp;i++){
                power = power * base;
            }
            return 1/power;
        }

    }

    public int factorial(int n){
     int factorial = 1;
        if(n == 0){
            return 1;
        } else{
            for(int i = 1; i<= n; i++){
              factorial = factorial * i;
            }
        }
        return factorial;
    }

    public int gcd(int a, int b){
        //rekursive Variante genommen,
        if( b == 0){
            return a;
        }
        return gcd(b,a % b);
    }

    public boolean isPrime(int n){

        for(int i = 1;i <= n ; i++){
            if(i != 1 && i != n){
                if((n%i) == 0){
                    return false;
                }
            }
        }
        return true;
    }

    public int sumWithStreams(int[] numbersToAdd){
        return Arrays.stream(numbersToAdd).sum();
    }

    public int findMaxValue(int[] numbers){
         return Arrays.stream(numbers).max().orElseThrow();
    }

    public int findMinValue(int[] numbers){
        return Arrays.stream(numbers).min().orElseThrow();
    }

    public int average(int[] numbers){
        return Arrays.stream(numbers).sum() / numbers.length;
    }

    public List<Integer> evenNumbers(int[] numbers){
        return Arrays.stream(numbers).filter(n -> n % 2 == 0).boxed().collect(toList());
    }

}
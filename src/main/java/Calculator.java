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
        if(n<=0) return new int[]{};
        int[] fib = new int[n];
        fib[0]=0;
        if(n>1){
            fib[1] = 1;
            for(int i = 2; i < n; i++){
                fib[i] = fib[i-1] + fib[i-2];
            }
        }
        return fib;
    }

    // Hatte zuerst gedacht, dass bei einem negativen Exponenten
    // eine Wurzel gezogen werden muss. Das hat nicht funktioniert.
    // Dann ist mir eingefallen, dass x^(-y) ja nur 1/(x^y) ist, dann war es einfach
    public double power(double base, int expo){
        boolean neg = false;
        if (expo < 0){
            expo *= -1;
            neg = true;
        }
        double res = 1;
        for(int i = 0; i < expo; i++){
            res *= base;
        }
        if(neg) return 1 / res;
        else return res;
    }

    //First try
    public Integer fac(int n){
        if(n<0) return null;
        int res = 1;
        for(int i = 1; i <= n; i++){
            res *= i;
        }
        return res;
    }

    //Hat erst nicht funktioniert, musste den Code nochmal anpassen
    public int gcd(int a, int b){
        int invDiv = 1;
        int div;
        while(true){
            if(a % invDiv == 0){
                div = a / invDiv;
                if(b % div == 0){
                    if(div<0) return div*-1;
                    else return div;
                }
            }
            invDiv++;
        }
    }

    //First try
    public boolean isPrime(int num){
        if(num <= 1) return false;
        for(int i = 2; i < num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }

    //Anforderung erfüllt
    public Double sqrt(double num){
        if(num < 0) return null;
        return Math.sqrt(num);
    }

}
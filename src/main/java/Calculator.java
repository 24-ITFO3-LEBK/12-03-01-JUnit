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
    	if(n <= 0) return new int[] {};
    	int[] fib = new int[n];
    	fib[0] = 0;
    	if(n > 1) {
    		fib[1] = 1;
    		for(int i = 2; i < n; i++) {
    			fib[i] = fib[i - 1] + fib[i - 2];
    		}
    	}
    	return fib;
    }
    
    public double power(int base, int exponent) {
    	double returnValue = base;
    	int posExponent = 0;
    	
    	if(exponent >= 0) {
    		posExponent = exponent;
    	} else {
    		posExponent = exponent * (-1);
    	}
    	
    	if (exponent == 0) {
    		returnValue = 0;
    	} else {
    		for(int i = posExponent - 1; i > 0; i--) {
	    		returnValue = returnValue * base;
	    	}
    		
    		if (exponent < 0) {
    			returnValue = 1 / returnValue;
    		}
    	}
    	
    	return returnValue;
    }
    
    public long factorial(int n) {
    	long returnValue = 1;
    	
    	for(int i = 2; i <= n; i++) {
    		returnValue = returnValue * i;
    	}
    	
    	return returnValue;
    }
    
    public int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        
        return a;
    }
    
    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public double sqrt(double n) {
        if (n < 0) {
            return -1;
        }
        return Math.sqrt(n);
    }
}
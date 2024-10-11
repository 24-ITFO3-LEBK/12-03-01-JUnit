import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.OptionalInt;
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
        filter();
        return Math.sqrt(n);
    }

    public static void filter(){

        List<Integer> zahlen = Arrays.asList(1,2,3,4,5,6);
        List<Integer> geradeZahlen = zahlen.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());

        System.out.println(geradeZahlen); // Ausgabe [4,16,36]
    }









    public int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }


    public double average(int[] numbers) {
        return Arrays.stream(numbers).average().orElse(0.0);
    }


    public int max(int[] numbers) {
        return Arrays.stream(numbers).max().getAsInt();
    }


    public int min(int[] numbers) {
        return Arrays.stream(numbers).min().getAsInt();
    }


    public List<Integer> filterEvens(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .boxed() // konvertiert int zu Integer
                .collect(Collectors.toList());
    }

    // Beispiel für die Methoden
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int[] numbers = {1, 2, 3, 4, 5, 6};

        System.out.println("Summe: " + calculator.sum(numbers));
        System.out.println("Durchschnitt: " + calculator.average(numbers));
        System.out.println("Maximalwert: " + calculator.max(numbers));
        System.out.println("Minimalkwert: " + calculator.min(numbers));
        System.out.println("Gerade Zahlen: " + calculator.filterEvens(numbers));
    }
}

/*
*Aufgabenstellung:

Implementieren Sie folgende Methoden in der Calculator-Klasse unter Verwendung von Streams, die ein Array an Ganzzahlen entgegennimmt:
Summe: Berechne die Summe aller Zahlen in der Liste.
Durchschnitt: Berechne den Durchschnitt aller Zahlen in der Liste.
Maximalwert: Finde den höchsten Wert in der Liste.
Minimalkwert: Finde den niedrigsten Wert in der Liste.
Filtern: Erstelle eine Liste von geraden Zahlen aus der ursprünglichen Liste.


Zusatzaufgaben:
a) Modifizieren Sie die Calculator-Klasse so, dass sie auch die Berechnung von quadratischen Wurzeln der geraden Zahlen ermöglicht. Nutzen Sie dafür Streams und map.
b) Implementiere eine Methode, die die geraden Zahlen und deren Quadrate in einem Map speichert, wobei die Zahl der Schlüssel und das Quadrat der Wert ist.


Dokumentation:
Dokumentieren Sie Ihren Code in Form eines Kommentars in Ihrer Methode
Schreiben Sie Tests, um die verschiedenen Methoden zu überprüfen


Hinweise:
Nutzen Sie die Java Stream API (java.util.stream), um die Aufgaben zu lösen.
Denken Sie an die Verwendung von Collectors für die Aggregation von Ergebnissen.
Bei Fragen zur Implementierung oder zu den Konzepten, scheue Sie nichtdavor, nach Hilfe zu fragen.
* */
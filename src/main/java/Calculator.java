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

    // Methode, die die Summe aller Zahlen in der Liste berechnet
    public int summe(List<Integer> list) {
        // Variable für die Summe (wird hier eigentlich nicht genutzt)
        int sum = 0;

        // Erstelle einen Stream aus der Liste
        Stream<Integer> stream = list.stream();

        // Wandelt den Stream in einen IntStream um und summiert alle Werte
        return stream.mapToInt(Integer::intValue).sum();
    }

    // Methode, die den Durchschnitt aller Zahlen in der Liste berechnet
    public double durchschnitt(List<Integer> zahlen) {
        // Berechnet den Durchschnitt als OptionalDouble
        OptionalDouble durchschnitt = zahlen.stream()
                .mapToInt(Integer::intValue) // Konvertiere Integer in int
                .average(); // Berechnet den Durchschnitt

        // Gibt den Durchschnitt zurück, oder 0.0 falls die Liste leer ist
        return durchschnitt.orElse(0.0);
    }

    // Methode, die den maximalen Wert in der Liste findet
    public static int findMax(List<Integer> zahlen) {
        // Findet den maximalen Wert als OptionalInt
        OptionalInt max = zahlen.stream()
                .mapToInt(Integer::intValue) // Konvertiere Integer in int
                .max(); // Berechnet das Maximum

        // Gibt den Maximalwert zurück, oder wirft eine Ausnahme, wenn die Liste leer ist
        return max.orElseThrow(() -> new IllegalArgumentException("Liste ist leer"));
    }

    // Methode, die den minimalen Wert in der Liste findet
    public static int findMin(List<Integer> zahlen) {
        // Findet den minimalen Wert als OptionalInt
        OptionalInt min = zahlen.stream()
                .mapToInt(Integer::intValue) // Konvertiere Integer in int
                .min(); // Berechnet das Minimum

        // Gibt den Minimalwert zurück, oder wirft eine Ausnahme, wenn die Liste leer ist
        return min.orElseThrow(() -> new IllegalArgumentException("Liste ist leer"));
    }

    // Methode, die nur die geraden Zahlen aus der Liste filtert
    public static List<Integer> filterGeradeZahlen(List<Integer> zahlen) {
        // Filtert den Stream, sodass nur die geraden Zahlen übrig bleiben
        return zahlen.stream()
                .filter(n -> n % 2 == 0) // Filtert gerade Zahlen
                .collect(Collectors.toList()); // Sammle sie in einer Liste
    }

    // Methode, die die Quadratwurzeln der geraden Zahlen in der Liste berechnet
    public static List<Double> berechneQuadratwurzelGeraderZahlen(List<Integer> zahlen) {
        // Filtert die geraden Zahlen und berechnet ihre Quadratwurzeln
        return zahlen.stream()
                .filter(n -> n % 2 == 0) // Filtere gerade Zahlen
                .map(n -> Math.sqrt(n))  // Berechne die Quadratwurzel
                .collect(Collectors.toList()); // Sammle die Ergebnisse in einer Liste
    }

    // Methode, die eine Map erstellt, bei der der Schlüssel eine gerade Zahl
    // und der Wert das Quadrat dieser Zahl ist
    public static Map<Integer, Integer> geradeZahlenUndQuadrate(List<Integer> zahlen) {
        // Filtert die geraden Zahlen und speichert sie in einer Map
        return zahlen.stream()
                .filter(n -> n % 2 == 0) // Filtere gerade Zahlen
                .collect(Collectors.toMap(n -> n, n -> n * n)); // Zahl als Schlüssel, Quadrat als Wert
    }
}
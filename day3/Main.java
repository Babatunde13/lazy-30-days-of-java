package day3;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int n = 100;
        Fibonacci fib = new Fibonacci(n);
        fib.setFib();
        fib.displayFibonacci();
    }
}

final class Fibonacci {
    long n;
    long[] fib;
    HashMap<Long, Long> fibMap;

    public Fibonacci(int n) {
        this.n = n;
        this.fib = new long[n];
        this.fibMap = new HashMap<>();
    }

    public long calculateFibForNumber(long number) {
        if (number < 0) {
            throw new ArithmeticException("Number must be greater than 0");
        }

        if (number == 0 || number == 1) {
            this.fibMap.put(number, number);
            return number;
        }
        if (this.fibMap.containsKey(number)) {
            return this.fibMap.get(number);
        }

        long fibNumber = calculateFibForNumber(number - 1) + calculateFibForNumber(number - 2);
        fibNumber = Math.abs(fibNumber);
        this.fibMap.put(number, fibNumber);
        return fibNumber;
    }

    public void setFib() {
        for (int i = 0; i < this.n; i++) {
            this.fib[i] = calculateFibForNumber(i);
        }
    }

    public void displayFibonacci() {
        System.out.println("The first " + n + " Fibonacci numbers are: ");
        System.out.print("[");
        for (int i = 0; i < n; i++) {
            System.out.print(fib[i]);
            if (i < n - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

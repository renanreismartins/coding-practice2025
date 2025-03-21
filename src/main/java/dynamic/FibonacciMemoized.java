package dynamic;

import java.util.HashMap;

public class FibonacciMemoized {

    static long fib(int n, HashMap<Integer, Long> memo) {
        if (memo.containsKey(n)) return memo.get(n);

        if (n <= 2) return 1;

        memo.put(n, fib(n - 2, memo) + fib(n - 1, memo));
        return memo.get(n);
    }

    public static void main(String[] args) {
        System.out.println("fib(1): " + fib(1, new HashMap<>()));
        System.out.println("fib(2): " + fib(2, new HashMap<>()));
        System.out.println("fib(3): " + fib(3, new HashMap<>()));
        System.out.println("fib(9): " + fib(9, new HashMap<>()));
        System.out.println("fib(55): " + fib(55, new HashMap<>()));
    }

}
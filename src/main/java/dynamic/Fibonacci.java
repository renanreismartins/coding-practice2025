package dynamic;

public class Fibonacci {

    static long fib(int n) {
        if (n <= 2) {
            return 1;
        }

        return fib(n - 2) + fib(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("fib(1): " + fib(1));
        System.out.println("fib(2): " + fib(2));
        System.out.println("fib(3): " + fib(3));
        System.out.println("fib(9): " + fib(9));
    }
}
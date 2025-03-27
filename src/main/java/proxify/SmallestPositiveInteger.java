package proxify;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/*
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].



Compilation successful.

Example test:   [1, 3, 6, 4, 1, 2]
Output:
[1, 1, 2, 3, 4, 6]
WRONG ANSWER (got 1 expected 5)

Example test:   [1, 2, 3]
Output:
[1, 2, 3]
WRONG ANSWER (got 1 expected 4)
 */
public class SmallestPositiveInteger {

    public static int smallest(int[] A) {
        List<Integer> numbers = Arrays.stream(A)
                .boxed()
                .distinct()
                .filter(n -> n > 0)
                .toList();

        if (numbers.isEmpty()) return 1;
        if (numbers.getFirst() > 1) return 1;

        List<Integer> naturals = IntStream.range(1, 1_000_000).boxed().toList();
        return compare(numbers, naturals, 1);
    }

    static int compare(List<Integer> numbers, List<Integer> naturals, int counter) {
        if (numbers.isEmpty()) return counter;
        if (!numbers.getFirst().equals(naturals.getFirst())) return counter;

        return compare(numbers.subList(1, numbers.size()), naturals.subList(1, naturals.size()), ++counter);
    }

    public static void main(String[] args) {
        System.out.println("smallest([0]): 1 = " + smallest(new int[]{0}));
        System.out.println("smallest([0, 0]): 1 = " + smallest(new int[]{0, 0}));
        System.out.println("smallest([1]): 2 = " + smallest(new int[]{1}));
        System.out.println("smallest([1, 1]): 2 = " + smallest(new int[]{1, 1}));
        System.out.println("smallest([2]): 1 = " + smallest(new int[]{2}));
        System.out.println("smallest([70]): 1 = " + smallest(new int[]{70}));

        System.out.println("----");
        System.out.println("smallest([0, 1]): 2 = " + smallest(new int[]{0, 1}));
        System.out.println("smallest([1, 2]): 3 = " + smallest(new int[]{1, 2}));
        System.out.println("smallest([1, 3]): 2 = " + smallest(new int[]{1, 3}));
        System.out.println("smallest([1, 2, 3]): 4 = " + smallest(new int[]{1, 2, 3}));
        System.out.println("smallest([1, 2, 3, 6]): 4 = " + smallest(new int[]{1, 2, 3, 6}));
        System.out.println("smallest([80, 90]): 1 = " + smallest(new int[]{80, 90}));


        System.out.println("----");
        System.out.println("smallest([-10, -2]): 1 = " + smallest(new int[]{-10, -9}));
        System.out.println("smallest([-10, 3]): 1 = " + smallest(new int[]{-10, 3}));
        System.out.println("smallest([-10, 1]): 2 = " + smallest(new int[]{-10, 1}));
    }
}

package dynamic;

import java.util.List;

public class CanSumSemiFunctional {

    static boolean canSum(int target, List<Integer> numbers) {
        if (target < 0) return false;
        if (target == 0) return true;
        if (numbers.isEmpty()) return false;

        for (Integer number : numbers) {
            return canSum(target - number, numbers.subList(1, numbers.size()));
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("canSum(-3, [1]): " + canSum(-3, List.of(1)));
        System.out.println("canSum(0, [1]): " + canSum(0, List.of(1)));
        System.out.println("canSum(1, []): " + canSum(1, List.of()));
        System.out.println("canSum(2, [2]): " + canSum(2, List.of(2)));
        System.out.println("canSum(2, [1]): " + canSum(2, List.of(1)));
        System.out.println("canSum(3, [2, 1]): " + canSum(3, List.of(2, 1)));
        System.out.println("canSum(7, [5, 3, 4, 7]): " + canSum(7, List.of(5, 3, 4, 7)));
    }
}

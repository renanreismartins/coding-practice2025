package dynamic;

import java.util.HashMap;
import java.util.List;

public class CanSumMemoized {

    static boolean canSum(int target, List<Integer> numbers, HashMap<Integer, Boolean> memo) {
        if (target < 0) return false;
        if (target == 0) return true;
        if (numbers.isEmpty()) return false;
        if (memo.containsKey(target)) return memo.get(target);

        boolean canSum = canSum(target - numbers.getFirst(), numbers, memo)
                || canSum(target, numbers.subList(1, numbers.size()), memo);

        memo.put(target, canSum);
        return memo.get(target);
    }

    public static void main(String[] args) {
        System.out.println("canSum(-3, [1]): " + canSum(-3, List.of(1), new HashMap<>()));
        System.out.println("canSum(0, [1]): " + canSum(0, List.of(1), new HashMap<>()));
        System.out.println("canSum(1, []): " + canSum(1, List.of(), new HashMap<>()));
        System.out.println("canSum(2, [2]): " + canSum(2, List.of(2), new HashMap<>()));
        System.out.println("canSum(2, [1]): " + canSum(2, List.of(1), new HashMap<>()));
        System.out.println("canSum(3, [2, 1]): " + canSum(3, List.of(2, 1), new HashMap<>()));
        System.out.println("canSum(7, [5, 3, 4, 7]): " + canSum(7, List.of(5, 3, 4, 7), new HashMap<>()));
        System.out.println("canSum(300, [7, 14]): " + canSum(300, List.of(7, 14), new HashMap<>()));
    }
}

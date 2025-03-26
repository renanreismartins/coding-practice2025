package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CanSum {

    static boolean canSum(int target, List<Integer> numbers) {
        if (target < 0) return false;
        if (target == 0) return true;
        if (numbers.isEmpty()) return false;

        return canSum(target - numbers.getFirst(), numbers)
                || canSum(target, new ArrayList<>(numbers.subList(1, numbers.size())));
    }

    static List<Integer> list(Integer... numbers) {
        return new ArrayList<>(Arrays.asList(numbers));
    }

    public static void main(String[] args) {
        System.out.println("canSum(-3, [1]): " + canSum(-3, list(1)));
        System.out.println("canSum(0, [1]): " + canSum(0, list(1)));
        System.out.println("canSum(1, []): " + canSum(1, list()));
        System.out.println("canSum(2, [2]): " + canSum(2, list(2)));
        System.out.println("canSum(2, [1]): " + canSum(2, list(1)));
        System.out.println("canSum(3, [2, 1]): " + canSum(3, list(2, 1)));
        System.out.println("canSum(7, [5, 3, 4, 7]): " + canSum(7, list(5, 3, 4, 7)));
    }
}

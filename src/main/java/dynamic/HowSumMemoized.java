package dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static java.util.Collections.emptyList;

public class HowSumMemoized {

    public static List<Integer> howSum(int target, List<Integer> numbers, HashMap<Integer, List<Integer>> memo) {
        if (memo.containsKey(target)) return memo.get(target);
        if (target == 0) return emptyList();
        if (target < 0) return null;

        for (Integer number : numbers) {
            memo.put(target, howSum(target - number, numbers, memo));
            List<Integer> results = memo.get(target);
            if (results != null) {
                return append(results, number);
            }
        }

        return null;
    }

    private static <T> List<T> append(List<T> al, T t) {
        List<T> bl = new ArrayList<>(al);
        bl.add(t);
        return Collections.unmodifiableList(bl);
    }

    public static void main(String[] args) {
        System.out.println("howSum(-3, [1]): " + howSum(-3, List.of(1), new HashMap<>()));
        System.out.println("howSum(0, [1]): " + howSum(0, List.of(1), new HashMap<>()));
        System.out.println("howSum(1, []): " + howSum(1, List.of(), new HashMap<>()));
        System.out.println("howSum(1, [1]): " + howSum(1, List.of(1), new HashMap<>()));
        System.out.println("howSum(2, [2]): " + howSum(2, List.of(2), new HashMap<>()));
        System.out.println("howSum(2, [1]): " + howSum(2, List.of(1), new HashMap<>()));
        System.out.println("howSum(3, [2, 1]): " + howSum(3, List.of(2, 1), new HashMap<>()));
        System.out.println("howSum(7, [5, 3, 4, 7]): " + howSum(7, List.of(5, 3, 4, 7), new HashMap<>()));
    }
}

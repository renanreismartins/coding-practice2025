package dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.emptyList;

public class BestSum {

    public static List<Integer> bestSum(int target, List<Integer> numbers) {
        if (target == 0) return emptyList();
        if (target < 0) return null;

        List<Integer> smallest = null;

        for (Integer number : numbers) {
            List<Integer> result = bestSum(target - number, numbers);
            if (result != null) {
                List<Integer> finalResult = append(result, number);
                if (smallest == null || result.size() < smallest.size()) {
                    smallest = finalResult;
                }
            }
        }

        return smallest;
    }

    private static <T> List<T> append(List<T> al, T t) {
        List<T> bl = new ArrayList<>(al);
        bl.add(t);
        return Collections.unmodifiableList(bl);
    }

    public static void main(String[] args) {
        System.out.println("bestSum(-3, [1]): " + bestSum(-3, List.of(1)));
        System.out.println("bestSum(0, [1]): " + bestSum(0, List.of(1)));
        System.out.println("bestSum(1, []): " + bestSum(1, List.of()));
        System.out.println("bestSum(1, [1]): " + bestSum(1, List.of(1)));
        System.out.println("bestSum(2, [2]): " + bestSum(2, List.of(2)));
        System.out.println("bestSum(2, [1]): " + bestSum(2, List.of(1)));
        System.out.println("bestSum(3, [2, 1]): " + bestSum(3, List.of(2, 1)));
        System.out.println("bestSum(7, [5, 3, 4, 7]): " + bestSum(7, List.of(5, 3, 4, 7)));
    }
}

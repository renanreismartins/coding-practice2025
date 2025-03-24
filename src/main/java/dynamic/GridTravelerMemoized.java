package dynamic;

import java.util.HashMap;

public class GridTravelerMemoized {

    static int possiblePaths(int rows, int cols, HashMap<Pair, Integer> memo) {
        if (rows == 0 || cols == 0) return 0;
        if (rows == 1 && cols == 1) return 1;
        if (memo.containsKey(new Pair(rows, cols))) return memo.get(new Pair(rows, cols));

        memo.put(new Pair(rows, cols),
                possiblePaths(rows - 1, cols, memo)
                + possiblePaths(rows, cols - 1, memo)
        );

        return memo.get(new Pair(rows, cols));
    }

    public record Pair(int rows, int cols){}

    public static void main(String[] args) {
        System.out.println("possiblePaths(1, 1): " + possiblePaths(1, 1, new HashMap<>()));
        System.out.println("possiblePaths(2, 1): " + possiblePaths(2, 1, new HashMap<>()));
        System.out.println("possiblePaths(3, 1): " + possiblePaths(3, 1, new HashMap<>()));
        System.out.println("possiblePaths(2, 3): " + possiblePaths(2, 3, new HashMap<>()));
        System.out.println("possiblePaths(15, 15): " + possiblePaths(15, 15, new HashMap<>()));
    }
}

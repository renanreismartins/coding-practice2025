package dynamic;

public class GridTraveler {

    static int possiblePaths(int rows, int cols) {
        if (rows == 0 || cols == 0) return 0;
        if (rows == 1 && cols == 1) return 1;

        return possiblePaths(rows - 1, cols)
                + possiblePaths(rows, cols - 1);
    }

    public static void main(String[] args) {
        System.out.println("possiblePaths(1, 1): " + possiblePaths(1, 1));
        System.out.println("possiblePaths(2, 1): " + possiblePaths(2, 1));
        System.out.println("possiblePaths(3, 1): " + possiblePaths(3, 1));
        System.out.println("possiblePaths(2, 3): " + possiblePaths(2, 3));
    }
}

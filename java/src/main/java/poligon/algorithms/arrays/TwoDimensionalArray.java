package poligon.algorithms.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class TwoDimensionalArray {

    private static final String sampleInput =
            "1 1 1 0 0 0\n" +
            "0 1 0 0 0 0\n" +
            "1 1 1 0 0 0\n" +
            "0 0 2 4 4 0\n" +
            "0 0 0 2 0 0\n" +
            "0 0 1 2 4 0";

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int[][] matrix = readArray(scanner, 6, 6);
            //printArray(matrix);
            int sum = Integer.MIN_VALUE;
            for (int y = 0; y < 4; ++y) {
                for (int x = 0; x < 4; ++x) {
                    sum = Math.max(sum, sumHourglass(matrix, y, x));
                }
            }
            System.out.println(sum);
        }
    }

    private static int[][] readArray(Scanner scanner, int rows, int cols) {
        int[][] array = new int[rows][cols];
        for (int y = 0; y < rows; ++y) {
            for (int x = 0; x < cols; ++x) {
                array[y][x] = scanner.nextInt();
            }
        }
        return array;
    }

    private static int sumHourglass(int[][] matrix, int y, int x) {
        return matrix[y][x] + matrix[y][x+1] + matrix[y][x+2]
                + matrix[y+1][x+1]
                + matrix[y+2][x] + matrix[y+2][x+1] + matrix[y+2][x+2];
    }

    private static void printArray(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}

package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EP04MaximalSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        String[] size = reader.readLine().split("\\s+");
        
        int[][] matrix = new int[Integer.parseInt(size[0])][Integer.parseInt(size[1])];

        for (int row = 0; row < matrix.length; row++) {
            String[] numbers = reader.readLine().split("\\s+");
            for (int col = 0; col < numbers.length; col++) {
                int num = Integer.parseInt(numbers[col]);

                matrix[row][col] = num;
            }
        }

        int bestSum = Integer.MIN_VALUE;
        int bestRow = 0;
        int bestCol = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {

                int sum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row][col + 2] + matrix[row + 1][col] +
                        matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (sum > bestSum) {
                    bestSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }

        System.out.println("Sum = " + bestSum);
        System.out.println(String.format("%d %d %d\n%d %d %d\n%d %d %d",
                matrix[bestRow][bestCol],
                matrix[bestRow][bestCol + 1],
                matrix[bestRow][bestCol + 2],
                matrix[bestRow + 1][bestCol],
                matrix[bestRow + 1][bestCol + 1],
                matrix[bestRow + 1][bestCol + 2],
                matrix[bestRow + 2][bestCol],
                matrix[bestRow + 2][bestCol + 1],
                matrix[bestRow + 2][bestCol + 2]));
    }
}

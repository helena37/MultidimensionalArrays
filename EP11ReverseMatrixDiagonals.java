package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class EP11ReverseMatrixDiagonals {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        String[] matrixSizes = reader.readLine().split("\\s+");

        int rows = Integer.parseInt(matrixSizes[0]);
        int cols = Integer.parseInt(matrixSizes[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            int[] numbers = Arrays
                    .stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col < numbers.length; col++) {
                int currentNumber = numbers[col];
                matrix[row][col] = currentNumber;
            }
        }

        int row = rows - 1;
        int col = cols - 1;

        while (row >= 0) {

            int r = row;
            int c = col;

            while (c < cols && r >= 0) {
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();

            col--;

            if (col == -1) {
                col = 0;
                row--;
            }
        }
    }
}

package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EP03DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        int size = Integer.parseInt(reader.readLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < matrix.length; row++) {
            String[] numbers = reader.readLine().split("\\s+");

            for (int col = 0; col < numbers.length; col++) {
                int number = Integer.parseInt(numbers[col]);
                matrix[row][col] = number;
            }
        }

        int sum1 = 0;
        int sum2 = 0;

        if (matrix.length % 2 != 0) {
            int index = matrix.length / 2;
            sum2 += matrix[index][index];
        }
            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[0].length; col++) {
                    for (int i = 0; i < size; i++) {
                        if (row == col && col == i) {
                            sum1 += matrix[row][col];
                        } else if (row == i && col == size - 1 - i) {
                            sum2 += matrix[row][col];
                        }
                    }
                }
            }

        int result = Math.abs(sum1 - sum2);

        System.out.println(result);
    }
}

package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EP01FillTheMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        String[] input = reader.readLine().split(", ");
        int[][] matrix = new int[Integer.parseInt(input[0])][Integer.parseInt(input[0])];
        int numberToFill = 0;

        if (input[1].equals("A")) {

            for (int col = 0; col < matrix[0].length; col++) {

                for (int row = 0; row < matrix.length; row++) {
                    numberToFill++;
                    matrix[row][col] = numberToFill;
                }
            }
        } else if (input[1].equals("B")) {

            for (int col = 0; col < matrix[0].length; col++) {

                if (col % 2 == 0) {
                    for (int row = 0; row < matrix.length; row++) {
                        numberToFill++;
                        matrix[row][col] = numberToFill;
                    }
                } else {
                    for (int row = matrix.length - 1; row >= 0; row--) {

                        numberToFill++;
                        matrix[row][col] = numberToFill;
                    }
                }
            }
        }


        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EP02MatrixOfPalindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        String[] matrixSize = reader.readLine().split("\\s+");
        String[][] matrix = new String[Integer.parseInt(matrixSize[0])][Integer.parseInt(matrixSize[1])];
        char charTofill = 96;

        for (int col = 0; col < matrix[0].length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                charTofill++;

                String strToFill = "";
                if (col == 0) {
                   strToFill = String.valueOf(charTofill) +
                            String.valueOf(charTofill) + String.valueOf(charTofill);
                    matrix[row][col] = strToFill;
                } else {
                    strToFill = String.valueOf(charTofill) +
                            String.valueOf((char)(charTofill + col)) + String.valueOf(charTofill);
                    matrix[row][col] = strToFill;
                }
            }
            charTofill = 96;
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {

                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

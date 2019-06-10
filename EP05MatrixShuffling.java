package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EP05MatrixShuffling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        String[] size = reader.readLine().split("\\s+");

        String[][] matrix = new String[Integer.parseInt(size[0])][Integer.parseInt(size[1])];

        for (int row = 0; row < matrix.length; row++) {
            String[] data = reader.readLine().split("\\s+");
            for (int col = 0; col < data.length; col++) {
                String currentData = data[col];
                matrix[row][col] = currentData;
            }
        }

        String command = "";

        while (!"END".equals(command = reader.readLine())) {

            String[] commandLine = command.split("\\s");

            if (commandLine[0].equals("swap")
                    && commandLine.length == 5
                    && Integer.parseInt(commandLine[1]) < matrix.length
                    && Integer.parseInt(commandLine[1]) >= 0
                    && Integer.parseInt(commandLine[2]) < matrix.length
                    && Integer.parseInt(commandLine[2]) >= 0
                    && Integer.parseInt(commandLine[3]) < matrix.length
                    && Integer.parseInt(commandLine[3]) >= 0
                    && Integer.parseInt(commandLine[4]) < matrix.length
                    && Integer.parseInt(commandLine[4]) >= 0) {

                int row1 = Integer.parseInt(commandLine[1]);
                int col1 = Integer.parseInt(commandLine[2]);

                int row2 = Integer.parseInt(commandLine[3]);
                int col2 = Integer.parseInt(commandLine[4]);

                String first = matrix[row1][col1];
                String second = matrix[row2][col2];

                matrix[row1][col1] = second;
                matrix[row2][col2] = first;

                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[0].length; j++) {
                        System.out.print(matrix[i][j] + " ");
                    }
                    System.out.println();
                }

            } else {
                System.out.println("Invalid input!");
            }
        }
    }
}

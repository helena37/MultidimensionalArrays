package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class EP07Crossfire {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        String[] rowsCols = reader.readLine().split("\\s+");

        int rowsSize = Integer.parseInt(rowsCols[0]);
        int colsSize = Integer.parseInt(rowsCols[1]);

        ArrayList<ArrayList<Integer>> matrix = generateMatrix(rowsSize, colsSize);

        String input = "";

        while (!"Nuke it from orbit".equals(input = reader.readLine())) {
            int[] tokens = Arrays
                    .stream(reader.readLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int row = tokens[0];
            int col = tokens[1];
            int radius = tokens[2];

            for (int r = row - radius; r <= row + radius; r++) {
                if (isInBounds(matrix, r, col)) {
                    matrix.get(r).set(col, 0);
                }
            }
            for (int c = col - radius; c <= col + radius; c++) {
                if (isInBounds(matrix, row, c)) {
                    matrix.get(row).set(c, 0);
                }
            }

            for (int r = 0; r < matrix.size(); r++) {
               matrix.set(r, matrix.get(r)
                        .stream()
                        .filter(element -> element != 0)
                        .collect(Collectors.toCollection(ArrayList::new)));

               if (matrix.get(r).size() == 0) {
                   matrix.remove(r);
                   r--;
               }

            }
        }

        printMatrix(matrix);
    }

    private static boolean isInBounds(ArrayList<ArrayList<Integer>> matrix, int row, int col) {

        return row >= 0 &&
                row < matrix.size() &&
                col >= 0 &&
                col < matrix.get(row).size();

    }

    private static void printMatrix(ArrayList<ArrayList<Integer>> matrix) {
        for (int r = 0; r < matrix.size(); r++) {
            for (int c = 0; c < matrix.get(r).size(); c++) {
                System.out.print(matrix.get(r).get(c) + " ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> generateMatrix(int rowsSize, int colsSize) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();

        int value = 1;

        for (int r = 0; r < rowsSize; r++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int c = 0; c < colsSize; c++) {
                row.add(value);
                value++;
            }
            matrix.add(row);
        }
        return matrix;
    }
}

package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class EP06StringMatrixRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        List<String> inputStrings = new ArrayList<>();
        String command = "";

        while (true) {
            String input = reader.readLine();

            if (input.equals("END")) {
                break;
            } else if (input.contains("Rotate")) {
                command = input;
                continue;
            }

            inputStrings.add(input);
        }

        int rowSize = 0;

        for (String inputString : inputStrings) {
            if (inputString.length() > rowSize) {
                rowSize = inputString.length();
            }
        }

        char[][] matrix = new char[inputStrings.size()][rowSize];


            for (int row = 0; row < matrix.length; row++) {
                String currentWord = inputStrings.get(row);
                for (int col = 0; col < rowSize; col++) {
                    if (currentWord.length() - 1 < col) {
                        matrix[row][col] = ' ';
                    } else {
                        matrix[row][col] = currentWord.charAt(col);
                    }
                }
            }

                int index = command.indexOf("(");

                int number = Integer.parseInt(command.substring(index + 1, command.length() - 1));
                number %= 360;

                if (number == 0) {
                    command = "Rotate(0)";
                } else if (number == 90) {
                    command = "Rotate(90)";
                } else if (number == 180) {
                    command = "Rotate(180)";
                }

            switch (command) {
                case "Rotate(0)":
                    for (int row = 0; row < matrix.length; row++) {
                        for (int col = 0; col < matrix[0].length; col++) {
                            System.out.print(matrix[row][col]);
                        }
                        System.out.println();
                    }
                    break;
                case "Rotate(270)":
                    for (int col = matrix[0].length - 1; col >= 0; col--) {
                        for (int row = 0; row < matrix.length; row++) {
                            System.out.print(matrix[row][col]);
                        }
                        System.out.println();
                    }
                    break;

                case "Rotate(180)":
                    for (int row = matrix.length - 1; row >= 0; row--) {
                        for (int col = matrix[0].length - 1; col >= 0; col--) {
                            System.out.print(matrix[row][col]);
                        }
                        System.out.println();
                    }
                    break;
                case "Rotate(90)":
                    for (int col = 0; col < matrix[0].length; col++) {
                        for (int row = matrix.length - 1; row >= 0; row--) {
                            System.out.print(matrix[row][col]);
                        }
                        System.out.println();
                    }
                    break;
            }
    }
}

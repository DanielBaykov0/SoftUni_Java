import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] matrix;
    static long jediSum = 0L;
    static int rows;
    static int cols;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = reader.readLine().split(" ");
        rows = Integer.parseInt(dimensions[0]);
        cols = Integer.parseInt(dimensions[1]);

        matrix = new int[rows][cols];
        buildMatrix();

        while (true) {
            String input = reader.readLine();
            if (input.equals("Let the Force be with you")) break;

            String[] coordinates = input.split(" ");
            int jediRow = Integer.parseInt(coordinates[0]);
            int jediCol = Integer.parseInt(coordinates[1]);

            coordinates = reader.readLine().split(" ");
            int evilRow = Integer.parseInt(coordinates[0]);
            int evilCol = Integer.parseInt(coordinates[1]);

            // process the dark path
            if (evilRow >= rows) {
                int shiftValue = evilRow - rows + 1;
                evilRow -= shiftValue;
                evilCol -= shiftValue;
            }

            if (evilCol >= cols) {
                int shiftValue = evilCol - cols + 1;
                evilRow -= shiftValue;
                evilCol -= shiftValue;
            }

            while (evilRow >= 0 && evilCol >= 0) {
                matrix[evilRow][evilCol] = 0;
                evilRow--;
                evilCol--;
            }

            //process the jedi path
            if (jediRow >= rows) {
                int shiftValue = jediRow - rows + 1;
                jediRow -= shiftValue;
                jediCol += shiftValue;
            }

            if (jediCol < 0) {
                int shiftValue = Math.abs(jediCol);
                jediRow -= shiftValue;
                jediCol += shiftValue;
            }

            while (jediRow >= 0 && jediCol < cols) {
                jediSum += matrix[jediRow][jediCol];
                jediRow--;
                jediCol++;
            }
        }

        System.out.println(jediSum);
    }

    private static void buildMatrix() {
        int counter = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = counter++;
            }
        }
    }
}
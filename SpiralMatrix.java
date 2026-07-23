public class SpiralMatrix {
    public static void printSpiral(int matrix[][]) {
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length - 1;
        int endCol = matrix[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // top
            // j = startCol -> endCol
            for (int j = startCol; j <= endCol; j++) {
                System.out.print(matrix[startRow][j] + " ");
            }

            // right
            // i = startRow + 1 -> endRow
            for (int i = startRow + 1; i <= endRow; i++) {
                System.out.print(matrix[i][endCol] + " "); // FIX 3: Removed the stray '9'
            }

            // bottom
            // j = endCol - 1 -> startCol
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) {
                    break;
                }
                System.out.print(matrix[endRow][j] + " ");
            }

            // left
            // i = endRow - 1 -> startRow + 1
            // In your original code, the loop variable was 'j' but you used 'i' in the print statement.
            for (int i = endRow - 1; i >= startRow + 1; i--) { // The loop variable can be 'i' or 'j', but it must be consistent.
                if (startCol == endCol) {
                    break;
                }
                System.out.print(matrix[i][startCol] + " "); // FIX 2: Used the correct loop variable 'i'
            }

            // FIX 1: Moved these boundary updates INSIDE the while loop
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
        System.out.println(); // For a clean new line at the end
    }

    public static void main(String args[]) {
        int matrix[][] = { 
            { 1, 2, 3, 4 }, 
            { 5, 6, 7, 8 }, 
            { 9, 10, 11, 12 }, 
            { 13, 14, 15, 16 } 
        };
        printSpiral(matrix);
    }
}
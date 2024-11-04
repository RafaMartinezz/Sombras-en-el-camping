import java.util.Scanner;

/**
 * A camping management tool to detect shaded areas around trees.
 * Each adjacent parcel to a tree (either horizontally, vertically, or
 * diagonally) is counted as shaded if it is empty.
 * This tool uses a grid to represent the camping area, with specific
 * coordinates for tree locations.
 */
public class App {

    /**
     * Calculates the shaded area around a given tree location in the matrix.
     * For each adjacent empty parcel to a tree, it marks it as shaded and counts
     * it.
     *
     * @param matriz     2D integer array representing the camping grid.
     *                   1 indicates a tree, 0 indicates an empty parcel, and 2
     *                   indicates a shaded parcel.
     * @param filaArb    The row position of the tree in the grid.
     * @param columnaArb The column position of the tree in the grid.
     * @return The total number of new shaded parcels created around this tree.
     */
    static int buscadorSombras(int[][] matriz, int filaArb, int columnaArb) {
        int totalSombras = 0; // Tracks shaded parcels around the tree

        // Iterate through neighboring cells within bounds
        for (int f = Math.max(0, filaArb - 1); f < Math.min(matriz.length, filaArb + 2); f++) {
            for (int c = Math.max(0, columnaArb - 1); c < Math.min(matriz[f].length, columnaArb + 2); c++) {
                if (matriz[f][c] == 1) {
                    continue; // Skip cells that already have trees
                }
                if (matriz[f][c] == 0) {
                    totalSombras += 1; // Count the cell as shaded
                    matriz[f][c] = 2; // Mark as shaded to avoid recounting
                }
            }
        }
        return totalSombras;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // Read initial dimensions and number of trees
        int columnas = teclado.nextInt();
        int filas = teclado.nextInt();
        int arboles = teclado.nextInt();

        // Process input until a zero dimension is entered (terminates input)
        while (columnas != 0 || filas != 0 || arboles != 0) {
            // Create arrays for the grid and tree coordinates
            int[][] parcelas = new int[filas][columnas];
            int[] coordArboles = new int[arboles * 2];

            // Populate the tree coordinates array from user input
            for (int a = 0; a < coordArboles.length; a++) {
                coordArboles[a] = teclado.nextInt() - 1; // Store each coordinate, adjusting for 0-based index
            }

            // Mark tree positions in the grid
            for (int a = 0; a < coordArboles.length - 1; a += 2) {
                parcelas[coordArboles[a + 1]][coordArboles[a]] = 1;
            }

            // Calculate and sum shaded areas around each tree
            int sombrasCamping = 0;
            for (int a = 0; a < coordArboles.length - 1; a += 2) {
                sombrasCamping += buscadorSombras(parcelas, coordArboles[a + 1], coordArboles[a]);
            }

            // Print the total shaded area for the current grid
            System.out.println(sombrasCamping);

            // Read new grid dimensions for the next iteration or termination
            columnas = teclado.nextInt();
            filas = teclado.nextInt();
            arboles = teclado.nextInt();
        }

        teclado.close();
    }
}

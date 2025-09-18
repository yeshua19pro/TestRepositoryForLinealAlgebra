/**
 * La clase Tools contiene métodos matemáticos útiles 
 * para trabajar con matrices cuadradas en Java.
 * 
 * Incluye un métodos para calcular funciones y propiedades de las matrices
 *
 * 
 * @author Miguel Angel
 */
public class Tools {

    /**
     * Calcula el determinante de una matriz cuadrada de forma recursiva,
     * utilizando el método de cofactores (expansión por la primera fila).
     * 
     * @param A matriz cuadrada de enteros (int[][]).
     *           Debe ser de tamaño n x n.
     * @return el valor entero del determinante de la matriz.
     * 
     */
    public static int determinante(int[][] A) {
        int n = A.length;
        if (n == 1) {
            return A[0][0]; // Caso base con metodo Gaussiano visto en la guia: matriz 1x1
        }
        int det = 0;
        // Recorremos cada elemento de la primera fila
        for (int j = 0; j < n; j++) {
            // Construcción de la submatriz
            int[][] sub = new int[n-1][n-1];
            for (int i = 1; i < n; i++) {
                int colSub = 0;
                for (int k = 0; k < n; k++) {
                    if (k == j) continue; // Saltamos la columna j
                    sub[i-1][colSub++] = A[i][k];
                }
            }
            // Calculamos el signo (+ o -) según la posición
            int signo = (j % 2 == 0) ? 1 : -1;
            // Acumulamos el resultado usando recursividad
            det += A[0][j] * signo * determinante(sub);
        }
        return det;
    }

    /**
     * Imprime la diagonal transversal (o secundaria) de una matriz cuadrada.
     * 
     * La diagonal transversal va desde la esquina superior derecha 
     * hasta la esquina inferior izquierda.
     * 
     * @param matriz matriz cuadrada de enteros (int[][]).
     *               Debe ser de tamaño n x n.
     * 
     */
    public static void Transversal(int[][] matriz) {
        int n = matriz.length;
        System.out.print("Transversal: ");
        for (int i = 0; i < n; i++) {
            System.out.print(matriz[i][n - 1 - i] + " ");
        }
    }
        /**
     * Muestra una matriz en formato de tabla.
     * Incluido por @author Miguel para facilitar la visualización de matrices en los teoremas.
     * @param matriz matriz cuadrada
     */
    public static void mostrarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.printf("%4d", valor);
            }
            System.out.println();
        }
    }

}

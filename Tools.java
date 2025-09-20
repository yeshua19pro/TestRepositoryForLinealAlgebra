import java.util.Scanner;
/**
 * La clase Tools contiene métodos matemáticos útiles para trabajar con matrices cuadradas en Java.
 * <p>
 * Incluye utilidades para calcular el determinante mediante cofactores, mostrar matrices, obtener
 * transpuestas, submatrices, cofactores y adjuntas, así como para imprimir la diagonal transversal. Y
 * estos metodos son utilizados en diferentes implementaciones de los teoremas.
 *
 * @author Miguel Angel, Sophia Narvaez
 */
public class Tools {

    /**
     * Calcula el determinante de una matriz cuadrada de forma recursiva,
     * utilizando el método de cofactores (expansión por la primera fila).
     *
     * @param A matriz cuadrada de enteros (int[][]). Debe ser de tamaño n x n.
     * @return el valor entero del determinante de la matriz.
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
            int[][] sub = new int[n - 1][n - 1];
            for (int i = 1; i < n; i++) {
                int colSub = 0;
                for (int k = 0; k < n; k++) {
                    if (k == j) continue; // Saltamos la columna j
                    sub[i - 1][colSub++] = A[i][k];
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
     * <p>
     * La diagonal transversal va desde la esquina superior derecha
     * hasta la esquina inferior izquierda.
     *
     * @param matriz matriz cuadrada de enteros (int[][]). Debe ser de tamaño n x n.
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
     *
     * @param matriz matriz cuadrada (nxn).
     */
    public static void mostrarMatriz(int[][] matriz) {
        int n = matriz.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Calcula la transpuesta de una matriz cuadrada.
     * La transpuesta se obtiene intercambiando filas por columnas.
     *
     * @param A matriz cuadrada de enteros (int[][]). Debe ser de tamaño n x n.
     * @return la matriz transpuesta como nuevo arreglo bidimensional (int[][]).
     */
    public static int[][] transpuesta(int[][] A) {
        int n = A.length;
        int[][] At = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                At[j][i] = A[i][j];
            }
        }
        return At;
    }

    /**
     * Calcula una submatriz eliminando una fila y columna espeificas
     *
     * @param matriz  matriz original
     * @param fila    fila que se elimina
     * @param columna columna que se elimina
     * @return la submatriz resultante int [][]
     */
    //Submatriz de un elemento en fila i columna j
    public static int[][] subMatriz(int[][] matriz, int fila, int columna) {
        int n = matriz.length;
        int[][] matrizMenor = new int[n - 1][n - 1];
        int filaSubmatriz = 0;

        for (int i = 0; i < n; i++) {
            if (i == fila) continue;
            int columnaSubmatriz = 0;
            for (int j = 0; j < n; j++) {
                if (j == columna) continue;
                matrizMenor[filaSubmatriz][columnaSubmatriz++] = matriz[i][j];
            }
            filaSubmatriz++;
        }
        return matrizMenor;
    }

    /**
     * Calcula la matriz de cofactores
     *
     * @param matriz matriz cuadrada original
     * @return matriz de cofactores int[][]
     */
    public static int[][] cofactores(int[][] matriz) {
        int n = matriz.length;
        int[][] cofactores = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[][] matrizMenor = subMatriz(matriz, i, j);

                //aqui se usa metodo determinante de Tools
                int signo = (i + j) % 2 == 0 ? 1 : -1;
                cofactores[i][j] = signo * Tools.determinante(matrizMenor);
            }
        }
        return cofactores;
    }

    /**
     * Calcula la matriz adjunta (transpuesta de la matriz cofactores)
     * La adjunta se obtiene como la transpuesta de la matriz de cofactores
     *
     * @param matriz matriz original
     * @return matriz adjunta int[][]
     */
    public static int[][] adjunta(int[][] matriz) {
        //aqui se usa metodo transpuesta de Tools
        return Tools.transpuesta(cofactores(matriz));

    }
}
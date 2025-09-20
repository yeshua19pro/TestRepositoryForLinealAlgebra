import java.util.Scanner;
/**
 * <p>Teorema 3.7 - Algebra lineal</p>
 * Se representa de forma interactiva, este teorema establece que el determinante de una matriz triangular
 * (superior o inferior) es igual al producto de los elementos de su diagonal principal. Además, guía al usuario
 * mostrando la matriz, el producto de la diagonal y el determinante calculado.</p>
 *
 * <p>La clase extiende {@link Teoremas} y emplea métodos de la clase {@link Tools}para mostrar
 * matrices y calcular determinantes. Se incluyen verificaciones para determinar si la matriz es
 * triangular superior, triangular inferior o ninguna de las dos, y se compara el producto de
 * la diagonal con el determinante obtenido.</p>
 */
public class Teorema37 extends Teoremas {
    Scanner sc = new Scanner(System.in);
    /**
     * <p>Constructor de la clase Teorema37.</p>
     * Crea una nueva instancia del teorema 3.7 con la matriz proporcionada.
     *
     * @param matriz Matriz cuadrada (nxn) sobre la cual se aplicará el teorema.
     */
    public Teorema37(int[][] matriz) {
        super(matriz);
    }
    /**
     * <p>El procedimiento de la demostración consiste en:</p>
     * <ol>
     *  <li>Mostrar la matriz original ingresada.</li>
     *  <li>Verificar si la matriz es triangular superior o triangular inferior.</li>
     *  <li>Calcular el producto de los elementos de la diagonal principal.</li>
     *  <li>Calcular el determinante de la matriz mediante {@link Tools#determinante(int[][])}.</li>
     *  <li>Comparar ambos valores y comprobar la validez del Teorema 3.7.</li>
     * </ol>
     */
    @Override
    public void aplicar() {
        int n = matriz.length;

        // Imprimir matriz
        System.out.println("Matriz:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%6d", matriz[i][j]);
            }
            System.out.println();
        }

        // Comprobar si es triangular superior o inferior
        boolean triangularSuperior = true;
        boolean triangularInferior = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) { // entrada por encima de la diagonal
                    if (matriz[i][j] != 0) {
                        // Para ser triangular inferior, todo arriba de la diagonal debe ser 0
                        triangularInferior = false;
                    }
                } else if (i > j) { // entrada por debajo de la diagonal
                    if (matriz[i][j] != 0) {
                        // Para ser triangular superior, todo abajo de la diagonal debe ser 0
                        triangularSuperior = false;
                    }
                }
            }
        }

        // Calcular producto de la diagonal principal
        long productoDiagonal = 1;
        for (int i = 0; i < n; i++) {
            productoDiagonal *= matriz[i][i];
        }

        // Calcular determinante con Tools (devuelve int en tu Tools; lo convertimos a long para comparar)
        int detInt = Tools.determinante(matriz);
        long det = detInt;

        System.out.println();
        if (triangularSuperior) {
            System.out.println("La matriz es triangular superior.");
        } else if (triangularInferior) {
            System.out.println("La matriz es triangular inferior.");
        } else {
            System.out.println("La matriz NO es triangular (ni superior ni inferior).");
        }
        System.out.println("(Presiona Enter para continuar)");
        sc.nextLine();

        System.out.println("Producto de la diagonal principal: " + productoDiagonal);
        System.out.println("Determinante : " + det);
        System.out.println("(Presiona Enter para continuar)");
        sc.nextLine();

        // Verificación del teorema (solo tiene sentido comprobar igualdad si es triangular)
        if (triangularSuperior || triangularInferior) {
            if (productoDiagonal == det) {
                System.out.println("Se cumple el Teorema 3.7: el determinante es igual al producto de la diagonal principal.");
            } else {
                System.out.println("No coincide el producto diagonal con el determinante. Revisa el cálculo o la matriz.");
            }
        } else {
            System.out.println("Nota: El Teorema 3.7 se aplica a matrices triangulares. Aquí solo mostramos el producto diagonal y el determinante para comparación.");
        }
    }
}


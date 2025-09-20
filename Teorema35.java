import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * <p>Teorema 3.5 - Algebra lineal</p>
 * Se representa de forma interactiva, este teorema establece que el determinante de una matriz cuadrada (nxn)
 * si se multiplica una fila de una matriz cuadrada por un escalar, el determinante de la nueva matriz es
 * igual al determinante original multiplicado por ese escalar.
 *
 * <p>La clase extiende {@link Teoremas} y emplea métodos de la clase {@link Tools}
 * para mostrar matrices y calcular determinantes. Durante la ejecución, se solicita
 * al usuario elegir una fila y un escalar, se genera una nueva matriz,
 * y se comprueba el enunciado del teorema mediante la comparación de determinantes.</p>
 *
 * @author Miguel Angel
 */
public class Teorema35 extends Teoremas {
    Scanner sc = new Scanner(System.in);
    private int fila;
    private int escalar;
    /**
     * <p>Constructor de la clase Teorema35.</p>
     * Crea una nueva instancia del Teorema 3.5 con la matriz dada,
     * solicitando la fila y el escalar a utilizar.
     *
     * @param matriz Matriz cuadrada (nxn) en la cual se aplicará el teorema.
     */
    public Teorema35(int[][] matriz) {
        super(matriz); // Llama al constructor de la clase padre
        solicitarFila();
        solicitarEscalar();
    }

    /**
     * <p>El procedimiento de la demostración consiste en:</p>
     * <ol>
     *  <li>Solicitar al usuario una fila de la matriz y un escalar.</li>
     *  <li>Mostrar la matriz original.</li>
     *  <li>Multiplicar la fila seleccionada por el escalar.</li>
     *  <li>Mostrar la nueva matriz.</li>
     *  <li>Calcular y mostrar los determinantes de ambas matrices.</li>
     *  <li>Confirmar si se cumple el Teorema 3.5.</li>
     * </ol>
     */
    @Override
    public void aplicar() {
        int n = matriz.length;

        // Copiar matriz
        int[][] copia = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                copia[i][j] = matriz[i][j];
            }
        }

        // Multiplicar la fila
        for (int j = 0; j < n; j++) {
            copia[fila][j] *= escalar;
        }

        // Mostrar resultados
        System.out.println("Matriz original:");
        Tools.mostrarMatriz(matriz);
        System.out.println("(Presiona Enter para continuar)");
        sc.nextLine();

        System.out.println("\nMatriz con la fila " + (fila + 1) + " multiplicada por " + escalar + ":");
        Tools.mostrarMatriz(copia);
        System.out.println("(Presiona Enter para continuar)");
        sc.nextLine();

        // Determinantes
        int detOriginal = Tools.determinante(matriz);
        int detNueva = Tools.determinante(copia);

        System.out.println("\nDeterminante original: " + detOriginal);
        System.out.println("Determinante nueva: " + detNueva);
        System.out.println("¿Se cumple el teorema 3.5? " + (detNueva == detOriginal * escalar));
    }

    // Metodos internos (solicitar la fila y el escalar)
    /**
     * <p>Solicita al usuario que ingrese la fila a multiplicar.</p>
     * <p>Se asegura de que el índice ingresado sea válido.</p>
     */
    private void solicitarFila() {
        Scanner sc = new Scanner(System.in);
        int n = matriz.length;
        System.out.println("Bienvenido al Teorema 3.5!");
        System.out.println("El Teorema 3.5 establece que si se multiplica una fila o columna de una matriz cuadrada por un numero real , el determinante de la nueva matriz sera igual al determinante original multiplicaada por el mismo numero real.");
        while (true) {
            try {
                System.out.print("Ingrese la fila a multiplicar (1 a " + n + "): ");
                fila = sc.nextInt() - 1; // convertir a índice 0-based
                if (fila < 0 || fila >= n) {
                    System.out.println("Error: La fila debe estar entre 1 y " + n + ".");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                sc.next(); // limpiar buffer
            }
        }
    }
    /**
     * <p>Solicita al usuario que ingrese un escalar válido.</p>
     */
    private void solicitarEscalar() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Ingrese el escalar para multiplicar la fila " + (fila + 1) + ": ");
                escalar = sc.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                sc.next(); // limpiar buffer
            }
        }
    }
}

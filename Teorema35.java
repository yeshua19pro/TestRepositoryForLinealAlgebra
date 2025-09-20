import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * La clase {@code Teorema35} implementa el teorema 3.5 de determinantes,
 * que establece que si se multiplica una fila de una matriz cuadrada por un escalar,
 * el determinante de la nueva matriz es igual al determinante original multiplicado por ese escalar.
 * 
 * Esta clase extiende la clase {@code Teoremas} y permite aplicar la operación sobre una fila específica
 * de una matriz cuadrada, mostrando la matriz original, la matriz modificada, ambos determinantes
 * y verificando si se cumple el teorema.
 * 
 * @author Miguel Angel
 * @see Teoremas
 * @see Tools
 */
public class Teorema35 extends Teoremas {

    Scanner sc = new Scanner(System.in);
    private int fila;
    private int escalar;

    /**
     * Constructor para inicializar el teorema 3.5
     * @param matriz matriz cuadrada
     */
    public Teorema35(int[][] matriz) {
        super(matriz); // Llama al constructor de la clase padre
        solicitarFila();
        solicitarEscalar();
    }

    /**
     * Solicita al usuario que ingrese la fila a multiplicar
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
     * Solicita al usuario que ingrese un escalar válido
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
}

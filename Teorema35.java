
/**
 * La clase {@code Teorema35} implementa el teorema 3.5 de determinantes,
 * que establece que si se multiplica una fila de una matriz cuadrada por un escalar,
 * el determinante de la nueva matriz es igual al determinante original multiplicado por ese escalar.
 * 
 * Esta clase extiende la clase {@code Teoremas} y permite aplicar la operación sobre una fila específica
 * de una matriz cuadrada, mostrando la matriz original, la matriz modificada, ambos determinantes
 * y verificando si se cumple el teorema.
 * 
 * <p>
 * Uso principal:
 * <ul>
 *   <li>Multiplicar una fila de una matriz cuadrada por un escalar.</li>
 *   <li>Comparar el determinante de la matriz original y la modificada.</li>
 *   <li>Verificar el cumplimiento del teorema 3.5.</li>
 * </ul>
 * </p>
 * 
 * @author Miguel Angel
 * @see Teoremas
 * @see Tools
 */
public class Teorema35 extends Teoremas {

    private int fila;
    private int escalar;

    /**
     * Constructor para inicializar el teorema 3.5
     *
     * @param matriz  matriz cuadrada
     * @param fila    número de fila a multiplicar (0 = primera fila)
     * @param escalar número por el que se multiplica la fila
     */
    public Teorema35(int[][] matriz, int fila, int escalar) {
        super(matriz); // Llama al constructor de la clase padre
        this.fila = fila;
        this.escalar = escalar;
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

        System.out.println("\nMatriz con la fila " + (fila + 1) + " multiplicada por " + escalar + ":");
        Tools.mostrarMatriz(copia);

        // Determinantes
        int detOriginal = Tools.determinante(matriz);
        int detNueva = Tools.determinante(copia);

        System.out.println("\nDeterminante original: " + detOriginal);
        System.out.println("Determinante nueva: " + detNueva);
        System.out.println("¿Se cumple el teorema 3.5? " + (detNueva == detOriginal * escalar));
    }
}

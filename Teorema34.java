
/**
 * Clase que demuestra el Teorema 3.4.
 * Teorema 3.4: Si una matriz tiene una fila o una columna de ceros,
 * su determinante es igual a 0.
 * 
 * Extiende la clase {@link Teoremas}.
 * Autor: Nancy
 */
import java.util.Scanner;
public class Teorema34 extends Teoremas {

    /**
     * Constructor de la clase Teorema34.
     * Inicializa la matriz que se evaluará según el teorema.
     *
     * @param matriz Matriz cuadrada que se usará para la demostración.
     */
    public Teorema34(int[][] matriz) {
        super(matriz);
    }

    /**
     * Aplica el Teorema 3.4 a la matriz.
     * <p>
     * Este método realiza los siguientes pasos:
     * <ul>
     *   <li>Muestra la matriz al usuario.</li>
     *   <li>Verifica si alguna fila o columna contiene únicamente ceros.</li>
     *   <li>Calcula el determinante usando {@link Tools#determinante(int[][])}.</li>
     *   <li>Muestra por consola si se cumple o no el Teorema 3.4.</li>
     * </ul>
     * </p>
     */
    @Override
    public void aplicar() {
        int n = matriz.length;
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al programa del Teorema 3.4");
        System.out.println("El teorema 3.4 establece que si una matriz tiene una fila o una columna de ceros, su determinante es igual a cero.");
        System.out.println("Empecemos por visualizar tu matriz:");
        Tools.mostrarMatriz(matriz);
        System.out.println("(Presiona Enter para continuar)");
        sc.nextLine();

        boolean tieneColumnaCeros = false;
        for (int j = 0; j < n; j++) {
            boolean columnaCeros = true;
            for (int i = 0; i < n; i++) {
                if(matriz[i][j]!= 0) {
                    columnaCeros = false;
                    break;
                }
            }
            if(columnaCeros) {
                tieneColumnaCeros = true;
                break;
            }
        }

        boolean tieneFilaCeros = false;
        for (int i = 0; i < n; i++) {
            boolean filaCeros = true;
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] != 0) {
                    filaCeros = false;
                    break;
                }
            }
            if (filaCeros) {
                tieneFilaCeros = true;
                break;
            }
        }

        int det = Tools.determinante(matriz);
        System.out.println("Determinante de la matriz: " + det);
        System.out.println("Ahora verificaremos si hay una fila o columna de ceros en la matriz...");
        System.out.println("(Presiona Enter para continuar)");
        sc.nextLine();

        if ((tieneFilaCeros || tieneColumnaCeros) && det == 0) {
            System.out.println("Se cumple el Teorema 3.4: Determinante = 0 al presentarse una fila o columna de ceros");
        } else if ((tieneFilaCeros || tieneColumnaCeros) && det != 0) {
            System.out.println("El Teorema 3.4 no se cumple");
        } else {
            System.out.println("El determinante es distinto de cero y no hay fila o columna de ceros");
            System.out.println("Por lo tanto no se cumple el Teorema 3.4");
        }
    }
}

import java.util.Scanner;
/**
 * <p>Teorema 3.3 - Algebra lineal</p>
 * Se representa de forma interactiva, este teorema establece que el determinante de una matriz cuadrada (nxn)
 * tiene dos filas idénticas, entonces su determinante es igual a cero.
 *
 * <p>La clase extiende {@link Teoremas} y utiliza métodos de la clase {@link Tools}
 * para mostrar matrices y calcular determinantes. Incluye un método auxiliar para verificar si existen
 * filas repetidas dentro de la matriz y asi comprobar el teorema.</p>
 *
 * @author Sara
 */

 //Test de subida sin error
public class Teorema33 extends Teoremas{
    Scanner sc = new Scanner(System.in);
    /**
     * <p>Constructor de la clase Teorema33.</p>
     * Crea una nueva instancia del teorema 3.3 con la matriz dada.
     *
     * @param matriz Matriz cuadrada (nxn) en la cual se aplicará el teorema.
     */
    public Teorema33(int[][] matriz) {
        super(matriz);
    }

    /**
     * <p>El procedimiento de la demostracion consiste en:</p>
     * <ol>
     *  <li>Explicar el enunciado del teorema.</li>
     *  <li>Verificar si la matriz contiene dos filas idénticas.</li>
     *  <li>Si existen filas idénticas, mostrar que el determinante es cero.</li>
     *  <li>Si no existen, calcular y mostrar el determinante real de la matriz.</li>
     * </ol>
     */
    @Override
    public void aplicar() {
        System.out.println("Bienvenido al Teorema 3.3!");
        System.out.println("El Teorema 3.3 propone que si una matriz tiene dos filas iguales, su determinante es 0 \n(enter para continuar)");
        System.out.println("Ahora verificaremos si tiene dos filas identicas");
        System.out.println("(Presiona Enter para continuar)");
        sc.nextLine();
        if (verificarFilas(matriz)) {
            System.out.println("Determinante = 0 (Teorema 3.3 si se cumple. La matriz tiene dos filas iguales)");
        } else {
            System.out.println("No tiene dos filas identicas... El teorema 3.3 no se cumple.");
            int det = Tools.determinante(matriz);
            System.out.println("Su determinante es = " + det);
        }
    }

    // Metodo interno (verificacion de filas)
    /**
     * Verifica si la matriz tiene dos filas idénticas.
     *
     * @param matriz la matriz a verificar
     * @return true si hay dos filas idénticas, false en caso contrario
     */
    public static boolean verificarFilas(int[][] matriz) {
        int n = matriz.length;

        // Comparar cada fila i con cada fila j (donde j > i)
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                boolean igual = true;

                // Compara cada uno
                for (int k = 0; k < n; k++) {
                    if (matriz[i][k] != matriz[j][k]) {
                        igual = false; // Si al comparar son distintos, ya no son iguales y tendra determinante != 0
                        break;
                    }
                }
                // Si después de recorrer todas las columnas siguen iguales, entramos al teorema
                if (igual) {
                    return true;
                    //Si es verdadero, en el main se mostrara que es igual a 0.
                }
            }
        }
        return false;
    }
}


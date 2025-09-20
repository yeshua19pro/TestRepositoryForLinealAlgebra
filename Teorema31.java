import java.util.Scanner;
/**
 * <p>Teorema 3.1 - Algebra lineal</p>
 * Se representa de forma interactiva, este teorema establece que el determinante de una matriz cuadrada (nxn)
 * es igual al determinante de su matriz transpuesta.
 *
 * <p>La clase extiende {@link Teoremas} y emplea métodos de la clase {@link Tools}
 * para mostrar matrices, calcular determinantes y obtener la transpuesta.
 * Durante la ejecución del codigo, se guía al usuario paso a paso mediante un menu para comprobar el enunciado
 * del teorema.</p>
 *
 * @author Sunny
 */
public class Teorema31 extends Teoremas {
    Scanner sc = new Scanner(System.in);
    /**
     * <p>Constructor de la clase Teorema31.</p>
     * Crea una nueva instancia del teorema 3.1 con la matriz dada.
     *
     * @param matriz Matriz cuadrada (nxn) en la cual se aplicará el teorema.
     */
    public Teorema31(int[][] matriz) {
        super(matriz);
    }

    /**
     * <p>El procedimiento de la demostracion consiste en:</p>
     * <ol>
     *   <li>Mostrar la matriz original.</li>
     *   <li>Calcular y mostrar su determinante.</li>
     *   <li>Obtener y mostrar la matriz transpuesta.</li>
     *   <li>Calcular y mostrar el determinante de la transpuesta.</li>
     *   <li>Confirmar la igualdad de ambos determinantes.</li>
     * </ol>
     */
    @Override
    public void aplicar() {
        System.out.println("Bienvenido al Teorema 3.1!");
        System.out.println("El Teorema 3.1 propone que el determinante de una matriz nxn es iugal a el determiante de su transpuesta  \n(enter para continuar)");
        sc.nextLine();

        System.out.println("Vamos a empezar por visualizar tu matriz:");
        Tools.mostrarMatriz(matriz);
        System.out.println("(enter para continuar)");
        sc.nextLine();

        System.out.println("Y ahora caculemos el determinante de tu matriz...");
        int det = Tools.determinante(matriz);
        System.out.println("Determinante: " + det);
        System.out.println("(enter para continuar)");
        sc.nextLine();

        System.out.println("Ahora visualicemos la transpuesta de tu matriz:");
        System.out.println("Transpuesta:");
        int[][] At = Tools.transpuesta(matriz);
        Tools.mostrarMatriz(At);
        System.out.println("(enter para continuar)");
        sc.nextLine();

        System.out.println("Y ahora caculemos el determinante de la transpuesta...");
        int detAt = Tools.determinante(At);
        System.out.println("Determinante de la transpuesta: " + detAt);
        System.out.println("(enter para continuar)");
        sc.nextLine();

        System.out.println("Como pudiste observar el determinante de tu matriz es: " + det + " y el determinante de su transpuesta es: " + detAt + " por lo tanto, el Teorema 3.1 se cumple!");
    }
}

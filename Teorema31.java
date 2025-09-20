import java.util.Scanner;

/**
 * La clase {@code Teorema31} implementa la demostración interactiva del Teorema 3.1 de álgebra lineal,
 * el cual establece que el determinante de una matriz cuadrada es igual al determinante de su transpuesta.
 * 
 * <p>Esta clase extiende la clase {@code Teoremas} y utiliza métodos auxiliares de la clase {@code Tools}
 * para mostrar matrices, calcular determinantes y obtener la transpuesta de una matriz.
 * 
 * <p>Durante la ejecución del método {@code aplicar()}, se guía al usuario paso a paso a través de la visualización
 * de la matriz original, el cálculo de su determinante, la obtención de la transpuesta y el cálculo del determinante
 * de la transpuesta, comprobando así el enunciado del teorema.
 * 
 * <p>Se utiliza {@code Scanner} para pausar la ejecución y permitir la interacción del usuario en cada paso.
 * 
 * @author Sunny
 */
public class Teorema31 extends Teoremas {
    Scanner sc = new Scanner(System.in);
    public Teorema31(int[][] matriz) {
        super(matriz);
    }

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
        System.out.println("Ahora visualisemos la transpuesta de tu matriz:");
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

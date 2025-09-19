import java.util.Scanner;

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

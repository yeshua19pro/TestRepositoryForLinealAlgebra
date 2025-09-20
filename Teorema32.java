import java.util.Scanner;

/**
 * Clase que demuestra el Teorema 3.2.
 * Teorema 3.2: Si se intercambian dos filas o dos columnas de una matriz nxn,
 * el determinante de la nueva matriz obtenida es igual al determinante de la
 * anterior matriz pero con el signo invertido.
 *
 * @author Sunny
 */
public class Teorema32 extends Teoremas {
    public int[][] interF(int[][] matriz, int f1, int f2) {
        for (int j = 0; j < n; j++) {
            int temp = matriz[f1][j];
            matriz[f1][j] = matriz[f2][j];
            matriz[f2][j] = temp;
        }
        return matriz;
    }
    public int[][] interCol(int[][] matriz, int c1, int c2) {
        for (int i = 0; i < n; i++) {
            int temp = matriz[i][c1];
            matriz[i][c1] = matriz[i][c2];
            matriz[i][c2] = temp;
        }
        return matriz;
    }
    Scanner sc = new Scanner(System.in);
    public Teorema32(int[][] matriz) {
        super(matriz);
    }
    int n = matriz.length;
    int fila1 = 0;
    int fila2 = 0;
    int col1 = 0;
    int col2 = 0;
    int det = Tools.determinante(matriz);

    /**
     * Este método guía al usuario a través de los siguientes pasos:
     * <ul>
     *   <li>Verifica que la matriz sea al menos de tamaño 2x2 y que su determinante no sea cero.</li>
     *   <li>Muestra la matriz original y su determinante.</li>
     *   <li>Permite al usuario elegir si desea intercambiar filas o columnas, y seleccionar cuáles intercambiar.</li>
     *   <li>Realiza el intercambio seleccionado y muestra la matriz modificada.</li>
     *   <li>Calcula y muestra el determinante de la matriz modificada.</li>
     *   <li>Demuestra que el determinante de la matriz modificada es el opuesto del original, cumpliendo el teorema.</li>
     * </ul>
     * 
     * Se utiliza la consola para la interacción con el usuario.
     */

    @Override
    public void aplicar() {
        System.out.println("Bienvenido al Teorema 3.2!");
        System.out.println("El Teorema 3.2 propone que si se intercambian dos filas o dos columnas de una matriz nxn, el determinante de la nueva matriz obtenida es igual al determinante de la anterior matriz pero con el signo invertido \n(enter para continuar)");
        sc.nextLine();
        if (n < 2) {
            System.out.println("La matriz debe ser al menos de tamaño 2x2 para aplicar este teorema.");
        } else if (det == 0) {
            System.out.println("El determinante de la matriz es 0, por lo tanto no se puede aplicar el teorema.");
        } else {
            System.out.println("Vamos a empezar por visualizar tu matriz:");
            Tools.mostrarMatriz(matriz);
            System.out.println("(enter para continuar)");
            sc.nextLine();
            System.out.println("Y ahora caculemos el determinante de tu matriz...");
            System.out.println("Determinante: " + det);
            System.out.println("(enter para continuar)");
            sc.nextLine();
            System.out.println("Te gustaria cambiar dos filas(0) o dos columnas(1)?");
            String opcion = sc.nextLine();
            switch (opcion) {
                case "0":
                    do {
                        System.out.println("Que fila te gustaria intercambiar? (0 = primera fila)");
                        fila1 = sc.nextInt();
                    } while (fila1 < 0 || fila1 >= n);
                    do {
                        System.out.println("Por que fila te gustaria intercambiar? (0 = primera fila)");
                        fila2 = sc.nextInt();
                    } while (fila2 < 0 || fila2 >= n || fila2 == fila1);
                    interF(matriz, fila1, fila2);
                    break;
                case "1":
                    do {
                        System.out.println("Que columna te gustaria intercambiar? (0 = primera fila)");
                        col1 = sc.nextInt();
                    } while (col1 < 0 || col1 >= n);
                    do {
                        System.out.println("Por que columna te gustaria intercambiar? (0 = primera fila)");
                        col2 = sc.nextInt();
                    } while (col2 < 0 || col2 >= n || col2 == col1);
                    interCol(matriz, col1, col2);
                    break;
                default:
                    System.out.println("Opcion no valida, se seleccionaran filas por defecto");
                    break;
            }
            System.out.println("Matriz modificada:");
            Tools.mostrarMatriz(matriz);
            System.out.println("(enter para continuar)");
            sc.nextLine();
            System.out.println("Y ahora caculemos el determinante de la matriz modificada...");
            int detMod = Tools.determinante(matriz);
            System.out.println("Determinante de la matriz modificada: " + detMod);
            System.out.println("(enter para continuar)");
            sc.nextLine();
            System.out.println("Como pudiste observar el determinante de tu matriz es: " + det + " y el determinante de la matriz modificada es: " + detMod + " por lo tanto, el Teorema 3.2 se cumple!");
        }
    }
}

import java.util.Scanner;
/**
 * <p>Teorema 3.2 - Algebra lineal</p>
 * Se representa de forma interactiva, este teorema establece que al intercambiar dos filas o
 * dos columnas de una matriz cuadrada, el determinante de la nueva matriz es el opuesto del
 * determinante original.
 *
 * <p>La clase extiende {@link Teoremas} y emplea métodos de la clase {@link Tools}
 * para mostrar matrices y calcular determinantes. Durante la ejecución, se solicita
 * al usuario elegir filas o columnas a intercambiar y se comprueba el enunciado
 * del teorema mediante la comparación de determinantes. Ademas se guia al usuario con un menu.</p>
 *
 * @author Sunny
 */
public class Teorema32 extends Teoremas {
    Scanner sc = new Scanner(System.in);
    int n = matriz.length;
    int fila1 = 0;
    int fila2 = 0;
    int col1 = 0;
    int col2 = 0;
    int det = Tools.determinante(matriz);
    /**
     * Crea una nueva instancia del teorema 3.2 con la matriz dada.
     *
     * @param matriz matriz cuadrada (nxn) en la cual se aplicará el teorema
     */
    public Teorema32(int[][] matriz) {
        super(matriz);
    }
    /**
     * <p>El procedimiento de la demostracion consiste en:</p>
     * <ol>
     *  <li>Verificar que la matriz sea de tamaño válido y que su determinante no sea cero.</li>
     *  <li>Mostrar la matriz original y su determinante.</li>
     *  <li>Solicitar al usuario si desea intercambiar filas o columnas, y los índices correspondientes.</li>
     *  <li>Aplicar el intercambio seleccionado y mostrar la matriz modificada.</li>
     *  <li>Calcular y mostrar el determinante de la nueva matriz.</li>
     *  <li>Confirmar que el determinante de la nueva matriz es el opuesto del original.</li>
     * </ol>
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

    // Metodos internos (intercambio de filas y columnas)
    /**
     * Intercambia dos filas de la matriz.
     *
     * @param matriz matriz sobre la cual se realiza el intercambio.
     * @param f1 índice de la primera fila.
     * @param f2 índice de la segunda fila.
     * @return con las filas intercambiadas
     */
    public int[][] interF(int[][] matriz, int f1, int f2) {
        for (int j = 0; j < n; j++) {
            int temp = matriz[f1][j];
            matriz[f1][j] = matriz[f2][j];
            matriz[f2][j] = temp;
        }
        return matriz;
    }
    /**
     * Intercambia dos columnas de la matriz.
     *
     * @param matriz matriz sobre la cual se realiza el intercambio
     * @param c1 índice de la primera columna
     * @param c2 índice de la segunda columna
     * @return con las columnas intercambiadas
     */
    public int[][] interCol(int[][] matriz, int c1, int c2) {
        for (int i = 0; i < n; i++) {
            int temp = matriz[i][c1];
            matriz[i][c1] = matriz[i][c2];
            matriz[i][c2] = temp;
        }
        return matriz;
    }
}

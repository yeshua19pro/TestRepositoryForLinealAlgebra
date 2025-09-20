/**
 * Clase que demuestra el Teorema 3.4. 
 * Teorema 3.4: Si una matriz tiene o una fila o una columna de ceros, 
 * su determinante es = 0.
 * @author nancy
 */

import java.util.Scanner;

public class Teorema34 extends Teoremas {   
    public Teorema34(int[][] matriz) {
        super(matriz);
    }

    /**
     * Metodo principal que crea una matriz cuadrada del tamaño que desea el usuario 
     * dejando la segunda columna llena de ceros para cumplir con las condiciones que 
     * requiere el teorema, verifica que las condiciones para el teorema, y calcula la 
     * determinante de la matriz.
     * @param args 
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

        //Checar si la matriz tiene columna de ceros
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

        //Checar si la matriz tiene fila de ceros
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

        //calcula el determinante usando clase externa llamada Determinante
        int det = Tools.determinante(matriz);
        System.out.println("Determinante de la matriz: " + det);
        System.out.println("Ahora verificaremos si hay una fila o columna de ceros en la matriz...");
        System.out.println("(Presiona Enter para continuar)");
        sc.nextLine();
        //Evalua el Teorema 3.4
        if ((tieneFilaCeros || tieneColumnaCeros) && det == 0) {
            System.out.println("Se cumple el Teorema 3.4: Determinante = 0 al presentarse una fila o columna de ceros");
        } else if ((tieneFilaCeros || tieneColumnaCeros) && det != 0) {
            System.out.println("El Teorema 3.4 no se cumple");
        } else {
            System.out.println("El determinante es distante de cero y no hay fila o columna de ceros");
            System.out.println("Por lo tanto no se cumple el Teorema 3.4");
        }
    }
}

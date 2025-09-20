import java.util.Scanner;

/**
 * La clase Teorema33 implementa el Teorema 3.3 de álgebra lineal, el cual establece que
 * si una matriz tiene dos filas idénticas, su determinante es igual a 0.
 * 
 * Hereda de la clase Teoremas y proporciona una implementación del método aplicar()
 * que verifica si la matriz contiene filas idénticas y calcula el determinante en caso contrario.
 * 
 * Métodos principales:
 * - aplicar(): Interactúa con el usuario, explica el teorema y verifica si la matriz cumple la condición.
 * - verificarFilas(int[][] matriz): Método estático que determina si existen dos filas idénticas en la matriz.
 * 
 * Uso:
 * Crear una instancia de Teorema33 pasando una matriz cuadrada de enteros y llamar al método aplicar().
 */

public class Teorema33 extends Teoremas{

    public Teorema33(int[][] matriz) {
        super(matriz);
    }
    Scanner sc = new Scanner(System.in);

    /**
    * El método aplicar() interactúa con el usuario, explica el teorema y verifica si la matriz contiene filas idénticas.
    * Si existen dos filas iguales, muestra que el determinante es 0 según el Teorema 3.3.
    * En caso contrario, calcula y muestra el determinante real de la matriz.
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


    /**
     * Verifica si la matriz tiene dos filas idénticas.
     *
     * @param matriz la matriz a verificar
     * @return true si hay dos filas idénticas, false en caso contrario
     */
    public static boolean verificarFilas(int[][] matriz) {
        int n = matriz.length;

        // Comparar cada fila i con cada fila j (donde j > i)
        // Nos permite hacer una interaccion directa al recorrerlo y asi determinar si hay alguna igual
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                boolean igual = true;

                // Compara cada uno
                for (int k = 0; k < n; k++) {
                    if (matriz[i][k] != matriz[j][k]) {
                        igual = false; // Si uno es distinto, ya no son iguales y tendra determinante != 0
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


/**
 * La clase Teorema33 implementa el Teorema 3.3 de álgebra lineal, que establece que
 * si una matriz cuadrada tiene dos filas idénticas, entonces su determinante es cero.
 * 
 * Hereda de la clase Teoremas y proporciona la implementación del método aplicar(),
 * que verifica si la matriz contiene dos filas idénticas y, en caso afirmativo,
 * informa que el determinante es cero. Si no hay filas idénticas, calcula y muestra
 * el determinante de la matriz.
 * 
 * Métodos principales:
 * - aplicar(): Aplica el teorema verificando filas idénticas y mostrando el resultado.
 * - verificarFilas(int[][] matriz): Método estático que determina si existen dos filas idénticas en la matriz.
 * 
 * Uso típico:
 * Crear una instancia de Teorema33 pasando una matriz cuadrada y llamar al método aplicar().
 */
public class Teorema33 extends Teoremas{

    public Teorema33(int[][] matriz) {
        super(matriz);
    }

    @Override
    public void aplicar() {
        System.out.println("Se ha generado correctamente la matriz:)");
        Tools.mostrarMatriz(matriz);

        System.out.println("Ahora verificaremos si tiene dos filas identicas");
        if (verificarFilas(matriz)) {
            System.out.println("Determinante = 0 (Teorema 3.3 si se cumple. La matriz tiene dos filas iguales)");
        } else {
            System.out.println("No tiene dos filas identicas... El teorema 3.3 no se cumple.");
            int det = Tools.determinante(matriz);
            System.out.println("Su determinante es = " + det);
        }
    }
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


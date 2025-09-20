import java.util.Scanner;

/**
 * Clase que demuestra el Teorema 3.7.
 * Teorema 3.7: El determinante de una matriz triangular (superior o inferior)
 * es igual al producto de los elementos de su diagonal principal.
 */
public class Teorema37 extends Teoremas {

    /**
     * Constructor que recibe la matriz a evaluar.
     *
     * @param matriz matriz cuadrada que se va a evaluar
     */
    public Teorema37(int[][] matriz) {
        super(matriz);
    }

    /**
     * Aplica la comprobación del Teorema 3.7 sobre la matriz proporcionada
     * en la clase padre (this.matriz). Imprime la matriz, el producto diagonal,
     * el determinante (calculado por Tools.determinante) y verifica la igualdad.
     */
    @Override
    public void aplicar() {
        int n = matriz.length;

        // Imprimir matriz
        System.out.println("Matriz:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%6d", matriz[i][j]);
            }
            System.out.println();
        }

        // Comprobar si es triangular superior o inferior
        boolean triangularSuperior = true;
        boolean triangularInferior = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) { // entrada por encima de la diagonal
                    if (matriz[i][j] != 0) {
                        // Para ser triangular inferior, todo arriba de la diagonal debe ser 0
                        triangularInferior = false;
                    }
                } else if (i > j) { // entrada por debajo de la diagonal
                    if (matriz[i][j] != 0) {
                        // Para ser triangular superior, todo abajo de la diagonal debe ser 0
                        triangularSuperior = false;
                    }
                }
            }
        }

        // Calcular producto de la diagonal principal
        long productoDiagonal = 1;
        for (int i = 0; i < n; i++) {
            productoDiagonal *= matriz[i][i];
        }

        // Calcular determinante con Tools (devuelve int en tu Tools; lo convertimos a long para comparar)
        int detInt = Tools.determinante(matriz);
        long det = detInt;

        System.out.println();
        if (triangularSuperior) {
            System.out.println("La matriz es triangular superior.");
        } else if (triangularInferior) {
            System.out.println("La matriz es triangular inferior.");
        } else {
            System.out.println("La matriz NO es triangular (ni superior ni inferior).");
        }

        System.out.println("Producto de la diagonal principal: " + productoDiagonal);
        System.out.println("Determinante (calculado por Tools.determinante): " + det);

        // Verificación del teorema (solo tiene sentido comprobar igualdad si es triangular)
        if (triangularSuperior || triangularInferior) {
            if (productoDiagonal == det) {
                System.out.println("✅ Se cumple el Teorema 3.7: el determinante es igual al producto de la diagonal principal.");
            } else {
                System.out.println("❌ No coincide el producto diagonal con el determinante. Revisa el cálculo o la matriz.");
            }
        } else {
            System.out.println("Nota: El Teorema 3.7 se aplica a matrices triangulares. Aquí solo mostramos el producto diagonal y el determinante para comparación.");
        }
    }

    /**
     * Método main para pruebas rápidas.
     * Permite crear una matriz triangular de ejemplo o introducir una matriz manualmente.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Teorema 3.7 - Determinante de matriz triangular = producto de la diagonal");
        System.out.print("Ingresa el tamaño n de la matriz cuadrada (ej: 3): ");
        int n = sc.nextInt();

        int[][] matriz = new int[n][n];

        System.out.println("¿Deseas usar una matriz triangular de ejemplo? (s/n)");
        String opcion = sc.next().trim().toLowerCase();
        sc.nextLine(); // limpiar buffer

        if (opcion.equals("s") || opcion.equals("si")) {
            // Pedir si triangular superior o inferior
            System.out.print("Triangular superior o inferior? (s/i): ");
            String tipo = sc.next().trim().toLowerCase();
            if (tipo.equals("s") || tipo.equals("sup") || tipo.equals("superior")) {
                // Ejemplo: triangular superior
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i <= j) {
                            matriz[i][j] = (i + 1) * (j + 2); // ejemplo no nulo en/por encima diagonal
                        } else {
                            matriz[i][j] = 0;
                        }
                    }
                }
            } else {
                // Ejemplo: triangular inferior
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (i >= j) {
                            matriz[i][j] = (i + 1) * (j + 2);
                        } else {
                            matriz[i][j] = 0;
                        }
                    }
                }
            }
        } else {
            // Entrada manual de la matriz
            System.out.println("Introduce los elementos fila por fila (enter para separar):");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print("Elemento [" + i + "][" + j + "]: ");
                    matriz[i][j] = sc.nextInt();
                }
            }
        }

        sc.close();

        // Crear objeto Teorema37 y aplicar la verificación
        Teorema37 t37 = new Teorema37(matriz);
        t37.aplicar();
    }
}

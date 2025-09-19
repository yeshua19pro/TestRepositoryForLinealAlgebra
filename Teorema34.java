/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nancy
 */
/**
 * Clase que demuestra el Teorema 3.4. 
 * Teorema 3.4: Si una matriz tiene o una fila o una columna de ceros, 
 * su determinante es = 0.
 */
import java.util.Scanner;

public class Teorema34 extends Teoremas {   
    public Teorema34(int[][] matriz) {
        super(matriz);
        //TODO Auto-generated constructor stub
    }

    /**
     * Metodo principal que crea una matriz cuadrada del tamaño que desea el usuario 
     * dejando la segunda columna llena de ceros para cumplir con las condiciones que 
     * requiere el teorema, verifica que las condiciones para el teorema, y calcula la 
     * determinante de la matriz.
     * @param args 
     */
    
    public static void main(String[] args) {
       
        //crea matriz n x n en base al input del usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el tamaño de la matriz cuadrada");
        int n = scanner.nextInt();
        int [][] matriz = new int[n][n];
        
        //llena matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(j == 1) {
                    matriz[i][j] = 0;
                } else {
                    matriz[i][j] = (i + 1) * (j + 2);
                }
            }
        }

        // Crear objeto y aplicar el teorema
        Teorema34 t34 = new Teorema34(matriz);
        t34.aplicar();
    }

    @Override
    public void aplicar() {
        int n = matriz.length;

        //imprime matriz
        System.out.println("Matriz:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println(" ");
        }

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
            
        //Evalua el Teorema 3.4
        if ((tieneFilaCeros || tieneColumnaCeros) && det == 0) {
            System.out.println("Se cumple el Teorema 3.4: Determinante = 0 al presentarse una fila o columna de ceros");
        } else if ((tieneFilaCeros || tieneColumnaCeros) && det != 0) {
            System.out.println("El Teorema 3.4 no se cumple");
        } else {
            System.out.println("El determinante es distante de cero y no hay fila o columna de ceros");
        }
    }
}

import java.util.Scanner;
import java.util.InputMismatchException;
public class Main {

    public static int[][] ingresarMatriz(int[][] matriz) {
        Scanner sc = new Scanner(System.in);
        int n = matriz.length;
        do {
            System.out.println("Por favor, ingresa el tamaño de la matriz cuadrada nxn (Max 4, min 1):");
            n = sc.nextInt();
        }while (n < 1 || n > 4);
        matriz = new int[n][n];
        sc.nextLine();
        System.out.println("Ingresa los elementos de la matriz fila por fila");
        System.out.println("Porfavor ten en cuenta que las matrices inician en 0 y no en 1");
        System.out.println("[x][y], donde x es la fila y y es la columna. Por ejemplo, [0][0] es el primer elemento de la matriz.");
        System.out.println("Teniendo esto en cuenta ya podemos empezar ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                while (true) {
                    try {
                        System.out.print("Elemento [" + i + "][" + j + "]: ");
                        matriz[i][j] = sc.nextInt();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Debes ingresar un número entero. Intenta de nuevo.");
                        sc.nextLine();
                    }
                }
            }
        }
        return matriz;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String op = "0";
        System.out.println("Bienvenido al programa de Teoremas de Determinantes!");
        int matriz[][] = new int[0][0];
        matriz = ingresarMatriz(matriz);
        System.out.println("Perfecto! ahora visualicemos tu matriz:");
        Tools.mostrarMatriz(matriz);
        System.out.println("Perfecto! ahora me gustaria mostratrarte: \n- El determinante de tu matriz\n- La matriz transpuesta\n- La matriz adjunta \n(Presiona Enter para continuar)");
        sc.nextLine();
        int det = Tools.determinante(matriz);
        System.out.println("El determinante de tu matriz es: " + det);
        System.out.println("(Presiona Enter para continuar)");
        sc.nextLine();
        int [][] At = Tools.transpuesta(matriz);
        System.out.println("La transpuesta de tu matriz es:");
        Tools.mostrarMatriz(At);
        System.out.println("(Presiona Enter para continuar)");
        sc.nextLine();
        System.out.println("La matriz adjunta es:");
        int [][] adj = Tools.adjunta(matriz);
        Tools.mostrarMatriz(adj);
        System.out.println("(Presiona Enter para continuar)");
        sc.nextLine();
        Teoremas t;
        do {
            op = "0";
            System.out.println("Que teorema te gustaria aplicar? \n1. Teorema 3.1 \n2. Teorema 3.2 \n3. Teorema 3.3 \n4. Teorema 3.4 \n5. Teorema 3.5 \n6. Teorema 3.7\n7. Cambiar Matriz \n0. Salir" );
            op = sc.nextLine();
            switch (op) {
                case "1":
                    t = new Teorema31(matriz);
                    t.aplicar();
                    System.out.println("(Presiona Enter para continuar)");
                    sc.nextLine();
                    break;
                case "2":
                    t = new Teorema32(matriz);
                    t.aplicar();
                    System.out.println("(Presiona Enter para continuar)");
                    sc.nextLine();
                    break;
                case "3":
                    t = new Teorema33(matriz);
                    t.aplicar();
                    System.out.println("(Presiona Enter para continuar)");
                    sc.nextLine();
                    break;
                case "4":
                    t = new Teorema34(matriz);
                    t.aplicar();
                    System.out.println("(Presiona Enter para continuar)");
                    sc.nextLine();
                    break;
                case "5":
                    t = new Teorema35(matriz);
                    t.aplicar();
                    System.out.println("(Presiona Enter para continuar)");
                    sc.nextLine();
                    break;
                case "6":
                    t = new Teorema37(matriz);
                    t.aplicar();
                    System.out.println("(Presiona Enter para continuar)");
                    sc.nextLine();
                    break;
                case "7":
                    matriz = ingresarMatriz(matriz);
                    break;
                case "0":
                    System.out.println("Gracias por usar el programa, hasta luego!");
                    break;
                default:
                    System.out.println("Opcion no valida, por favor intenta de nuevo");
            }
            if (!op.equals("0") && !op.equals("7")) {
                System.out.println("Te gustaria aplicar otro teorema? (1 para si, 0 para no)");
                op = sc.nextLine();
            }
        }while(op.equals("1") || op.equals("7"));
    }
    
}

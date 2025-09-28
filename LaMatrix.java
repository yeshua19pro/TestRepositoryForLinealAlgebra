package clases.lamatrix;

/**
 *
 * @author user
 */
public class LaMatrix {

    public static void main(String[] args) {
        String[][] matrizEstudiantes = new String[4][6];

        String[] estudiantes = {"sunny", "nancy", "sara", "miguel"};
        String[] id = {"01", "02", "03","04"};

        int formula = matrizEstudiantes[0].length/2; // si es columna de medio
        int contEstudiantes = 0;
        
        for(int i = 0; i < matrizEstudiantes.length; i++){
            for (int j = 0; j < matrizEstudiantes[i].length; j++) {
                if(j==formula){
                    matrizEstudiantes [i][j] = estudiantes[contEstudiantes];
                    contEstudiantes++;
                }else{
                     matrizEstudiantes [i][j] = "X";
                }
            }
        }
        for (int i = 0; i < matrizEstudiantes.length; i++) {
            matrizEstudiantes[i][0] = id[i];
        }
        
        for (int i = 0; i < matrizEstudiantes.length; i++) {
            for (int j = 0; j < matrizEstudiantes[i].length; j++) {
                System.out.print(matrizEstudiantes[i][j]+" ");
            }
            System.out.println();
        }
    }
}

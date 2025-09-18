/**
 * Clase abstracta que representa la base para implementar diferentes teoremas
 * que operan sobre una matriz cuadrada de enteros.
 * <p>
 * Las subclases deben proporcionar la implementación del método {@link #aplicar()},
 * que define la lógica específica del teorema.
 * </p>
 */
public abstract class Teoremas {

    protected int[][] matriz;

    /**
     * Constructor para inicializar la matriz.
     *
     * @param matriz matriz cuadrada
     */
    public Teoremas(int[][] matriz) {
        this.matriz = matriz;
    }

    /**
     * Método abstracto que cada teorema debe implementar.
     */
    public abstract void aplicar();
}

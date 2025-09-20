/**
 * <p>Clase abstracta que representa la base para implementar diferentes teoremas relacionados con matrices
 * cuadradas de enteros. Esta clase establece la estructura común a todos los teoremas, almacenando una
 * matriz y definiendo un método abstracto que cada subclase debe implementar.</p>
 *
 * Las subclases deben proporcionar la implementación del método {@link #aplicar()},
 * que define la lógica específica del teorema.
 * </p>
 *
 * @author Sophia
 */
public abstract class Teoremas {
    // Es protegida para permitir acceso desde las subclases.
    protected static int[][] matriz;

    /**
     * <p>Constructor de la clase base Teoremas.</p>
     * Inicializa la matriz que será utilizada por el teorema.
     *
     * @param matriz matriz cuadrada (nxn) que se evaluará en la implementación del teorema.
     */
    public Teoremas(int[][] matriz) {
        this.matriz = matriz;
    }

    /**
     * Método abstracto que cada teorema debe implementar.
     */
    public abstract void aplicar();
}

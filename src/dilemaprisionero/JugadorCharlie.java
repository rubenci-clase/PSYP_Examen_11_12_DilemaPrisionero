package dilemaprisionero;

/**
 *
 * @author Berto-bakar
 */
public class JugadorCharlie extends Jugador {

    private Accion ultimaJugadaRival; // Guarda la última jugada del rival
    private boolean esPrimeraJugada; // Indica si es la primera jugada del jugador

    public JugadorCharlie(int id) {
        super(id);
        this.ultimaJugadaRival = Accion.COLABORAR; // En la primera jugada, su rival no ha jugado aún
        this.esPrimeraJugada = true; // Charlie está en su primera jugada
    }

    @Override
    public Accion decidirAccion() {
        Accion accion;

        if (esPrimeraJugada) {
            // En la primera jugada, Charlie siempre colabora
            accion = Accion.COLABORAR;
            esPrimeraJugada = false; // Ya no es la primera jugada
        } else {
            // Después de la primera jugada, imita la jugada previa del rival
            accion = ultimaJugadaRival;
        }

        // Actualizar la última jugada del rival para la siguiente ronda
        return accion;
    }

    // Método para actualizar la jugada del rival
    public void setJugadaRival(Accion accion) {
        this.ultimaJugadaRival = accion;
    }
}

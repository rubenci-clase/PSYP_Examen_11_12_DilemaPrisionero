package dilemaprisionero;

/**
 *
 * @author Berto-bakar
 */
public class JugadorCharlie extends Jugador {

    private Accion ultimaJugadaRival; // Guarda la última jugada del rival

    public JugadorCharlie(int id) {
        super(id);
        this.ultimaJugadaRival = Accion.COLABORAR; // En la primera jugada, su rival no ha jugado aún
    }

    @Override
    public Accion decidirAccion() {
        //En la primera jugada, Charlie siempre colabora
        Accion accion = ultimaJugadaRival;
        //Después de la primera jugada, imita la jugada previa del rival
        ultimaJugadaRival = accion; //Actualiza la jugada anterior del rival
        return accion;
    }

    // Método para actualizar la jugada del rival
    public void setJugadaRival(Accion accion) {
        this.ultimaJugadaRival = accion;
    }
}

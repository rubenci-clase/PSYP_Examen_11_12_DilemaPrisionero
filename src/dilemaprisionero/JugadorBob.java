package dilemaprisionero;

/**
 *
 * @author Berto-bakar
 */
public class JugadorBob extends Jugador {

    private int numeroDePartida;

    public JugadorBob(int id) {
        super(id);
        this.numeroDePartida = 1; //Inicializamos la cuenta de partidas
    }

    @Override
    public Accion decidirAccion() {
        // Determina la acción según si el número de partida es par o impar
        Accion accion = (numeroDePartida % 2 == 0) ? Accion.COLABORAR : Accion.ROBAR;
        numeroDePartida++; //Se ha jugado una partida más
        return accion;
    }
}

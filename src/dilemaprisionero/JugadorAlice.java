package dilemaprisionero;

import java.util.Random;

/**
 *
 * @author Berto-bakar
 */
public class JugadorAlice extends Jugador {

    private Random aleatory; // Generador de números aleatorios

    public JugadorAlice(int id) {
        super(id);
        this.aleatory = new Random();
    }

    @Override
    public Accion decidirAccion() {
        // Generar un valor aleatorio para decidir la acción
        return aleatory.nextBoolean() ? Accion.COLABORAR : Accion.ROBAR;

    }


}

package dilemaprisionero;

// Clase JugadorRatero que siempre roba
class JugadorRatero extends Jugador {
    public JugadorRatero(int id) {
        super(id);
    }

    @Override
    public Accion decidirAccion() {
        return Accion.ROBAR; // Siempre roba
    }
}

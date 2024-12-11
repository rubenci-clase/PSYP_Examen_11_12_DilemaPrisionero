package dilemaprisionero;

// Clase JugadorColaborador que siempre colabora
class JugadorColaborador extends Jugador {
    public JugadorColaborador(int id) {
        super(id);
    }

    @Override
    public Accion decidirAccion() {
        return Accion.COLABORAR; // Siempre colabora
    }
}

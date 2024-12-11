package dilemaprisionero;

// Superclase Jugador
abstract class Jugador implements Runnable {
    protected int id;
    protected Accion accion;

    // Constructor para asignar un ID al jugador
    public Jugador(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    // Método que debe ser implementado por las subclases
    public abstract Accion decidirAccion();

    @Override
    public void run() {
        // Se obtiene la acción decidida por el jugador
        accion = decidirAccion();
        // Mostrar la acción tomada por el jugador
        System.out.println("Jugador " + id + " eligió: " + accion);
    }
}



package dilemaprisionero;

/**
 *
 * @author Alumno
 */
public class Juego {

    private Jugador[] jugadores; // Los jugadores del juego
    private int rondas; // Número de rondas a jugar
    private Accion[] jugadas; // Array para almacenar las jugadas de cada ronda

    public Juego(Jugador[] jugadores, int rondas) {
        this.jugadores = jugadores;
        this.rondas = rondas;
        this.jugadas = new Accion[jugadores.length]; // Guarda las jugadas de todos los jugadores
    }

    public void jugar() {
        // Ciclo para jugar las rondas
        for (int ronda = 0; ronda < rondas; ronda++) {
            System.out.println("Ronda " + (ronda + 1));

            // Todos los jugadores toman su decisión para esta ronda
            for (int i = 0; i < jugadores.length; i++) {
                // Cada jugador decide su acción
                Accion accion = jugadores[i].decidirAccion();

                // Mostrar la acción del jugador
                System.out.println("Jugador " + jugadores[i].getId() + " juega: " + accion);

                // Almacenar la jugada
                jugadas[i] = accion;
            }

            // Actualizar la jugada de cada jugador para la próxima ronda
            for (int i = 0; i < jugadores.length; i++) {
                // El jugador debe conocer la jugada del rival
                if (i > 0) {
                    // Pasar la jugada del rival anterior
                    ((JugadorCharlie) jugadores[i]).setJugadaRival(jugadas[i - 1]);
                }
            }
            System.out.println();
        }
    }
}

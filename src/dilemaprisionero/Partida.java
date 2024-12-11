package dilemaprisionero;

// Clase para manejar una partida entre dos jugadores
class Partida {
    private Thread jugador1;
    private Thread jugador2;

    public Partida(Thread jugador1, Thread jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public void jugar() throws InterruptedException {
        // Arrancar ambos jugadores en hilos diferentes
        jugador1.start();
        jugador2.start();

        // Esperar que ambos terminen
        jugador1.join();
        jugador2.join();
    }
}

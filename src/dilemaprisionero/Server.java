
package dilemaprisionero;

import java.io.*;
import java.net.*;
import java.util.*;

public class Server {

    private static final int PORT = 12345;
    private static Map<Integer, PrintWriter> jugadores = new HashMap<>();
    private static int jugadoresConectados = 0;

    public static void main(String[] args) {
        System.out.println("Servidor iniciado...");
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (jugadoresConectados < 2) {
                Socket socket = serverSocket.accept();
                jugadoresConectados++;
                new PlayerHandler(socket, jugadoresConectados).start(); // Manejar cada jugador en un hilo
            }
            System.out.println("Ambos jugadores conectados. Iniciando el juego...");
            // Aquí podrías iniciar el juego entre los jugadores, pero por ahora solo los conectamos.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Clase interna para manejar cada cliente/jugador
    static class PlayerHandler extends Thread {
        private Socket socket;
        private int jugadorId;
        private PrintWriter out;
        private BufferedReader in;

        public PlayerHandler(Socket socket, int jugadorId) {
            this.socket = socket;
            this.jugadorId = jugadorId;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                jugadores.put(jugadorId, out);
                out.println("Jugador " + jugadorId + " conectado. Esperando el inicio del juego...");

                String input;
                while ((input = in.readLine()) != null) {
                    System.out.println("Jugador " + jugadorId + " eligió: " + input);
                    // Aquí procesamos las jugadas y enviamos las respuestas a los jugadores
                    // Este es solo un ejemplo de cómo manejar las jugadas.
                    // Luego, podemos pasar el turno al siguiente jugador
                    if (jugadorId == 1) {
                        jugadores.get(2).println("Jugador 1 eligió: " + input); // Enviar al otro jugador
                    } else {
                        jugadores.get(1).println("Jugador 2 eligió: " + input);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package dilemaprisionero;

import java.io.*;
import java.net.*;

public class Client {

    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.println("Conectado al servidor.");

            // Leer mensaje inicial del servidor
            String serverMessage = in.readLine();
            System.out.println(serverMessage);

            // Bucle para que el jugador ingrese sus decisiones
            while (true) {
                System.out.println("Elige una acción: (COLABORAR / ROBAR)");
                String decision = userInput.readLine();
                if ("COLABORAR".equalsIgnoreCase(decision) || "ROBAR".equalsIgnoreCase(decision)) {
                    out.println(decision.toUpperCase()); // Enviar la acción al servidor
                } else {
                    System.out.println("Acción inválida. Elige entre COLABORAR o ROBAR.");
                    continue;
                }

                // Recibir la jugada del otro jugador
                String opponentMove = in.readLine();
                System.out.println(opponentMove);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

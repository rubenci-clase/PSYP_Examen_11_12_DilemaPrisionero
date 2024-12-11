
package dilemaprisionero;

import java.util.Scanner;

/**
 *
 * @author Berto-bakar
 */
public class JuegoInteractivo {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Preguntar cuántas rondas se jugarán
        System.out.println("¿Cuántas rondas se jugarán?");
        int rondas = scanner.nextInt();

        // Seleccionar los jugadores
        System.out.println("Seleccione el jugador 1 (1: Colaborador, 2: Ratero, 3: Alice, 4: Bob, 5: Charlie): ");
        int jugador1Tipo = scanner.nextInt();
        System.out.println("Seleccione el jugador 2 (1: Colaborador, 2: Ratero, 3: Alice, 4: Bob, 5: Charlie): ");
        int jugador2Tipo = scanner.nextInt();

        // Crear los jugadores seleccionados
        Jugador jugador1 = crearJugador(jugador1Tipo, 1);
        Jugador jugador2 = crearJugador(jugador2Tipo, 2);

        // Iniciar el juego
        Juego juego = new Juego(new Jugador[]{jugador1, jugador2}, rondas);
        juego.jugar();
    }

    // Método para crear un jugador basado en la selección
    private static Jugador crearJugador(int tipo, int id) {
        switch (tipo) {
            case 1:
                return new JugadorColaborador(id);
            case 2:
                return new JugadorRatero(id);
            case 3:
                return new JugadorAlice(id);
            case 4:
                return new JugadorBob(id);
            case 5:
                return new JugadorCharlie(id);
            default:
                throw new IllegalArgumentException("Tipo de jugador inválido");
        }
    }
}
    


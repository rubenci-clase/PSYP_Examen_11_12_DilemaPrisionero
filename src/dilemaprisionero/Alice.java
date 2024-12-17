package dilemaprisionero;
import java.util.Random;

public class Alice extends Jugador{

	public Alice(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Accion decidirAccion() {
		// TODO Auto-generated method stub
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        Random rand = new Random();
        int seleccion = rand.nextInt(2);
        
        if (seleccion == 0) return Accion.COLABORAR;
        else return Accion.ROBAR;
	}

}

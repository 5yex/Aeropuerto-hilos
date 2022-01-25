package Modelo;

/**
 * 
 * Hilo del avi�n
 * 
 * @author Jos� Miguel Calder�n de la Barca y Jos� Miguel Garc�a Orejudo
 * 
 */
public class Avion extends Thread {
	private int id;
	private TorreDeControl torre;
	private Pista pistaActual;
	private boolean bucle;

	public Avion(int id, TorreDeControl torre, boolean bucle) {
		super();
		this.id = id;
		this.torre = torre;
		this.bucle = bucle;
	}

	/**
	 * 
	 * Acciones que realiza el hilo
	 * 
	 * Si la condicion bucle es verdadera, actual en bucle infinito Si es falsa,
	 * hace sus accines y se para el hilo
	 * 
	 * @author Jos� Miguel Calder�n de la Barca y Jos� Miguel Garc�a Orejudo
	 * 
	 */
	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("El avi�n " + this.id + " est� volando");
				sleep((long) Math.floor(Math.random() * 600));
				pistaActual = torre.asignarPista(id);
				pistaActual.aterrizar(id);
				pistaActual.despegar(id);
				if(!bucle) break;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

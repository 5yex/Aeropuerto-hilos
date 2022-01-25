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

	public boolean isBucle() {
		return bucle;
	}

	public void setBucle(boolean bucle) {
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
				boolean aterrizado = false;
				while (!aterrizado) {
					System.out.println("El avi�n " + this.id + " est� volando");
					sleep((long) Math.floor(Math.random() * 600));
					pistaActual = torre.asignarPista(id);
					//Si la pista asignada no estaba ocupada aterriza y sale del bucle aterrizado					
					if (pistaActual.getPistaOcupada().tryAcquire()) {
						pistaActual.aterrizar(id);
						aterrizado = true;
						pistaActual.despegar(id);
					//Si la pista asignada estaba ocupada, no realiza las acciones de aterrizar
					//Y como no sale del bucle vuelve a pedir pista, hasta que la consiga
					} else {
						System.out.println(
								"El avi�n " + id + " no obtenido pista " + pistaActual.getId() + ", estaba ocupada");
					}
				}
				if (!bucle)
					break;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

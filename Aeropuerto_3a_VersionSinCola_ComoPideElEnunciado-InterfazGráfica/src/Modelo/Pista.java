package Modelo;

import java.util.concurrent.Semaphore;

/**
 * 
 * Clase pista
 * 
 * Cuenta con un sem�foro, que marca si est� ocupada
 * 
 * @author Jos� Miguel Calder�n de la Barca y Jos� Miguel Garc�a Orejudo
 * 
 */
public class Pista {
	int id;
	Semaphore pistaOcupada = new Semaphore(1);

	public Pista(int id) {
		super();
		this.id = id;
	}

	public Semaphore getPistaOcupada() {
		return pistaOcupada;
	}

	public void setPistaOcupada(Semaphore pistaOcupada) {
		this.pistaOcupada = pistaOcupada;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Este m�todo controla el aterrizaje del avi�n en la pista libre que un avi�n haya obtenido
	 * 
	 * 
	 * @author Jos� Miguel Calder�n de la Barca y Jos� Miguel Garc�a Orejudo
	 * 
	 */
	public void aterrizar(int idAvion) {
		try {
			System.out.println("El avi�n " + idAvion + " procede a su aterrizaje en pista " + this.id);
			Thread.sleep((long) Math.floor(Math.random() * 600));
			System.out.println("El avi�n " + idAvion + " ha aterrizado en pista " + this.id);
			Thread.sleep((long) Math.floor(Math.random() * 600));
			System.out.println("El avi�n " + idAvion + " ha dejado a sus pasajeros en pista " + this.id);
		} catch (InterruptedException e) {

		}
	}
	/**
	 * Este m�todo controla el despegue del avi�n en la pista
	 * 
	 * Marcar que est� libre al finalizar
	 * 
	 * @author Jos� Miguel Calder�n de la Barca y Jos� Miguel Garc�a Orejudo
	 * 
	 */
	public void despegar(int idAvion) {
			try {Thread.sleep((long) Math.floor(Math.random() * 600));
			System.out.println("El avi�n " + idAvion + " ha recogido a sus pasajeros nuevos en pista " + this.id);
			Thread.sleep((long) Math.floor(Math.random() * 600));
			System.out.println("El avi�n " + idAvion + " procede a su despegue de pista " + this.id);
			Thread.sleep((long) Math.floor(Math.random() * 600));
			System.out.println("El avi�n " + idAvion + " ha salido la de pista " + this.id);
			pistaOcupada.release();
		} catch (InterruptedException e) {

		}
	}

}

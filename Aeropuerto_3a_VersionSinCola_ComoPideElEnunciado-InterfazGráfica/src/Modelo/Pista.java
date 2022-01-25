package Modelo;

import java.util.concurrent.Semaphore;

/**
 * 
 * Clase pista
 * 
 * Cuenta con un semáforo, que marca si está ocupada
 * 
 * @author José Miguel Calderón de la Barca y José Miguel García Orejudo
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
	 * Este método controla el aterrizaje del avión en la pista libre que un avión haya obtenido
	 * 
	 * 
	 * @author José Miguel Calderón de la Barca y José Miguel García Orejudo
	 * 
	 */
	public void aterrizar(int idAvion) {
		try {
			System.out.println("El avión " + idAvion + " procede a su aterrizaje en pista " + this.id);
			Thread.sleep((long) Math.floor(Math.random() * 600));
			System.out.println("El avión " + idAvion + " ha aterrizado en pista " + this.id);
			Thread.sleep((long) Math.floor(Math.random() * 600));
			System.out.println("El avión " + idAvion + " ha dejado a sus pasajeros en pista " + this.id);
		} catch (InterruptedException e) {

		}
	}
	/**
	 * Este método controla el despegue del avión en la pista
	 * 
	 * Marcar que esté libre al finalizar
	 * 
	 * @author José Miguel Calderón de la Barca y José Miguel García Orejudo
	 * 
	 */
	public void despegar(int idAvion) {
			try {Thread.sleep((long) Math.floor(Math.random() * 600));
			System.out.println("El avión " + idAvion + " ha recogido a sus pasajeros nuevos en pista " + this.id);
			Thread.sleep((long) Math.floor(Math.random() * 600));
			System.out.println("El avión " + idAvion + " procede a su despegue de pista " + this.id);
			Thread.sleep((long) Math.floor(Math.random() * 600));
			System.out.println("El avión " + idAvion + " ha salido la de pista " + this.id);
			pistaOcupada.release();
		} catch (InterruptedException e) {

		}
	}

}

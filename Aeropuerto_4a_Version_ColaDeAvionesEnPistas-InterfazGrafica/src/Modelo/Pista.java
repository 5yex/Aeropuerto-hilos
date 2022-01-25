package Modelo;

import java.util.concurrent.Semaphore;

/**
 * 
 * Clase pista
 * 
 * Cuenta con un semáforo y un numeroCola, donde guarda la cola que va teniendo
 * 
 * @author José Miguel Calderón de la Barca y José Miguel García Orejudo
 * 
 */
public class Pista {
	int id;
	int numeroCola;
	Semaphore pistaOcupada = new Semaphore(1);

	public Pista(int id) {
		super();
		this.id = id;
	}

	public int getNumeroCola() {
		return numeroCola;
	}

	public void setNumeroCola(int numeroCola) {
		this.numeroCola = numeroCola;
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
	 * Este método controla el aterrizaje del avión en la pista
	 * 
	 * Marcar que esté ocupada
	 * 
	 * Aumentar el numero de la cola de aviones
	 * 
	 * 
	 * @author José Miguel Calderón de la Barca y José Miguel García Orejudo
	 * 
	 */
	public void aterrizar(int idAvion) {
		try {
			System.out.println("El avión " + idAvion + " ha obtenido plaza en pista " + this.id);
			numeroCola++;
			System.out.println("------Cola en pista " + id + " es de " + numeroCola);
			pistaOcupada.acquire();
			System.out.println("El avión " + idAvion + " procede a su aterrizaje en pista " + this.id);
			Thread.sleep((long) Math.floor(Math.random() * 800));
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
	 * disminuir el numero de cola
	 * 
	 * @author José Miguel Calderón de la Barca y José Miguel García Orejudo
	 * 
	 */
	public void despegar(int idAvion) {
			try {Thread.sleep((long) Math.floor(Math.random() * 600));
			System.out.println("El avión " + idAvion + " ha recogido a sus pasajeros nuevos en pista " + this.id);
			Thread.sleep((long) Math.floor(Math.random() * 600));
			System.out.println("El avión " + idAvion + " procede a su despegue de pista " + this.id);
			Thread.sleep((long) Math.floor(Math.random() * 800));
			System.out.println("El avión " + idAvion + " ha salido la de pista " + this.id);
			numeroCola--;
			System.out.println("------Cola en pista " + id + " es de " + numeroCola);
			pistaOcupada.release();
		} catch (InterruptedException e) {

		}
	}

}

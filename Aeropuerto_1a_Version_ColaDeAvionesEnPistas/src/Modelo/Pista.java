package Modelo;

import java.util.concurrent.Semaphore;

/**
 * 
 * Clase pista
 * 
 * Cuenta con un sem�foro y un numeroCola, donde guarda la cola que va teniendo
 * 
 * @author Jos� Miguel Calder�n de la Barca y Jos� Miguel Garc�a Orejudo
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
	 * Este m�todo controla el aterrizaje del avi�n en la pista
	 * 
	 * Marcar que est� ocupada
	 * 
	 * Aumentar el numero de la cola de aviones
	 * 
	 * 
	 * @author Jos� Miguel Calder�n de la Barca y Jos� Miguel Garc�a Orejudo
	 * 
	 */
	public void aterrizar(int idAvion) {
		try {
			System.out.println("El avi�n " + idAvion + " ha obtenido plaza en pista " + this.id);
			numeroCola++;
			System.out.println("------Cola en pista " + id + " es de " + numeroCola);
			pistaOcupada.acquire();
			System.out.println("El avi�n " + idAvion + " procede a su aterrizaje en pista " + this.id);
			Thread.sleep((long) Math.floor(Math.random() * 800));
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
	 * disminuir el numero de cola
	 * 
	 * @author Jos� Miguel Calder�n de la Barca y Jos� Miguel Garc�a Orejudo
	 * 
	 */
	public void despegar(int idAvion) {
			try {Thread.sleep((long) Math.floor(Math.random() * 600));
			System.out.println("El avi�n " + idAvion + " ha recogido a sus pasajeros nuevos en pista " + this.id);
			Thread.sleep((long) Math.floor(Math.random() * 600));
			System.out.println("El avi�n " + idAvion + " procede a su despegue de pista " + this.id);
			Thread.sleep((long) Math.floor(Math.random() * 800));
			System.out.println("El avi�n " + idAvion + " ha salido la de pista " + this.id);
			numeroCola--;
			System.out.println("------Cola en pista " + id + " es de " + numeroCola);
			pistaOcupada.release();
		} catch (InterruptedException e) {

		}
	}

}

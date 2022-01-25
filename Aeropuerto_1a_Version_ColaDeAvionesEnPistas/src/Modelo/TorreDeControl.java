package Modelo;

import java.util.ArrayList;

/**
 * 
 * Clase TORRE DE CONTROL
 * 
 * Es la que contiene el ArrayList con las pistas del aeropuerto, que rellena en
 * el constructor
 * 
 * @author Jos� Miguel Calder�n de la Barca y Jos� Miguel Garc�a Orejudo
 * 
 */
public class TorreDeControl {

	ArrayList<Pista> pistasAeropuerto;
	private int numeroPistas;
	
	public TorreDeControl(int numeroPistas) {
		this.numeroPistas = numeroPistas;
		pistasAeropuerto = new ArrayList<Pista>();
		for (int i = 0; i < this.numeroPistas; i++) {
			pistasAeropuerto.add(new Pista(i));
		}
	}
	/**
	 * 
	 * Asigna la pista con menos cola, a un avi�n
	 * 
	 * @author Jos� Miguel Calder�n de la Barca y Jos� Miguel Garc�a Orejudo
	 * 
	 */
	public Pista asignarPista(int idAvion) {
		Pista pista = PistaMenosCola();
		System.out.println("El avi�n " + idAvion + " ha contactado con torre para obtener pista");
		return pista;
	}

	/**
	 * 
	 * Devuelve la pista con menos cola
	 * 
	 * @author Jos� Miguel Calder�n de la Barca 
	 * 
	 */
	public Pista PistaMenosCola() {
		int n = 999;
		Pista pistaMenosCola = null;
		for (Pista pista : pistasAeropuerto) {
			if (pista.getNumeroCola() < n) {
				n = pista.getNumeroCola();
				pistaMenosCola = pista;
			}
		}
		return pistaMenosCola;
	}
}

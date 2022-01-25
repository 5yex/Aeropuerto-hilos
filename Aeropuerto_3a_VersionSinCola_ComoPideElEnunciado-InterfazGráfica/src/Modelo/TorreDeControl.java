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
	 * Asigna una pista ALEATORIA a un avi�n
	 * 
	 * @author Jos� Miguel Calder�n de la Barca y Jos� Miguel Garc�a Orejudo
	 * 
	 */
	public Pista asignarPista(int idAvion) {
		Pista pista = pistasAeropuerto.get((int) (Math.random() * numeroPistas));
		System.out.println("El avi�n " + idAvion + " ha contactado con torre para obtener pista");
		return pista;
	}
}

package Modelo;

import java.util.ArrayList;
/**
 * 
 * Clase TORRE DE CONTROL
 * 
 * Es la que contiene el ArrayList con las pistas del aeropuerto, que rellena en
 * el constructor
 * 
 * @author José Miguel Calderón de la Barca y José Miguel García Orejudo
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
	 * Asigna una pista ALEATORIA a un avión
	 * 
	 * @author José Miguel Calderón de la Barca y José Miguel García Orejudo
	 * 
	 */
	public Pista asignarPista(int idAvion) {
		Pista pista = pistasAeropuerto.get((int) (Math.random() * numeroPistas));
		System.out.println("El avión " + idAvion + " ha contactado con torre para obtener pista");
		return pista;
	}
}

package Operaciones;

import java.util.ArrayList;
import java.util.Iterator;

import Modelo.Avion;
import Modelo.TorreDeControl;


public class OperacionesAeropuerto {
	/**
	 * Método que inicia el aerpuerto
	 * 
	 * @author José Miguel Calderón de la Barca
	 * @param nAviones       Numero de aviones que volaran sobre el aeropuerto
	 * @param nPistas        Numero de pistas de las que dispondrá el aeropuerto
	 * @param funcionEnBucle Alterna en que los aviones funcionen en bucle, o tengan
	 *                       fin al terminar sus acciones
	 */
	private ArrayList<Avion> hilosAvion;
	private int nAviones;
	private int nPistas;
	private boolean funcionEnBucle;

	public OperacionesAeropuerto(int nAviones, int nPistas, boolean funcionEnBucle) {
		super();
		this.nAviones = nAviones;
		this.nPistas = nPistas;
		this.funcionEnBucle = funcionEnBucle;
		this.hilosAvion = new ArrayList<Avion>();
	}

	public boolean iniciarAeropuerto() {
		//Comprueba que se cumpla la condicion del enunciado
		if(nAviones<=nPistas|nAviones<0|nPistas<0){
			System.err.println("No puede haber mas aviones que pistas");
			return false;
		}else {
			TorreDeControl Torre = new TorreDeControl(nPistas);
			for (int i = 0; i < nAviones; i++) {
				Avion tmp = new Avion(i, Torre, funcionEnBucle);
				tmp.start();
				hilosAvion.add(tmp);
			}
			return true;
		}
	}

	public void pararAviones() {
		for (Avion avion : hilosAvion) {
			avion.setBucle(false);
		}
	}

}

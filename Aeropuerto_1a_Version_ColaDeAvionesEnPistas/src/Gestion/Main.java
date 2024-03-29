package Gestion;

import Modelo.Avion;
import Modelo.TorreDeControl;

/**
 * Proyecto TORRE DE CONTROL AEROPUERTO
 * 
 * Versi�n 1:
 * 
 * - En esta versi�n los aviones guardan cola en cada pista. - La pista asignada
 * es la que menos cola tiene-
 * 
 * 
 * @author Jos� Miguel Calder�n de la Barca y Jos� Miguel Garc�a Orejudo
 * 
 */
public class Main {
	public static void main(String[] args) {
		//NOTA: INTERFAZ GR�FICA PENDIENTE Y MANUAL DE USUARIO PENDIENTES
		iniciarAeropuerto(8, 3, false);
	}

	/**
	 * M�todo que inicia el aerpuerto
	 * 
	 * @author Jos� Miguel Calder�n de la Barca
	 * @param nAviones       Numero de aviones que volaran sobre el aeropuerto
	 * @param nPistas        Numero de pistas de las que dispondr� el aeropuerto
	 * @param funcionEnBucle Alterna en que los aviones funcionen en bucle, o tengan
	 *                       fin al terminar sus acciones
	 * 
	 * 
	 */
	public static boolean iniciarAeropuerto(int nAviones, int nPistas, boolean funcionEnBucle) {
		//Comprueba que se cumpla la condicion del enunciado
		if(nAviones<=nPistas){
			System.err.println("No puede haber mas aviones que pistas");
			return false;
		}else {
			TorreDeControl Torre = new TorreDeControl(nPistas);
			for (int i = 0; i < nAviones; i++) {
				new Avion(i, Torre, funcionEnBucle).start();
			}
			return true;
		}
	}
}


package Gestion;

import Modelo.Avion;
import Modelo.TorreDeControl;

/**
 * Proyecto TORRE DE CONTROL AEROPUERTO
 * 
 * Versión 1:
 * 
 * - En esta versión los aviones guardan cola en cada pista. - La pista asignada
 * es la que menos cola tiene-
 * 
 * 
 * @author José Miguel Calderón de la Barca y José Miguel García Orejudo
 * 
 */
public class Main {
	public static void main(String[] args) {
		//NOTA: INTERFAZ GRÁFICA PENDIENTE Y MANUAL DE USUARIO PENDIENTES
		iniciarAeropuerto(8, 3, false);
	}

	/**
	 * Método que inicia el aerpuerto
	 * 
	 * @author José Miguel Calderón de la Barca
	 * @param nAviones       Numero de aviones que volaran sobre el aeropuerto
	 * @param nPistas        Numero de pistas de las que dispondrá el aeropuerto
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


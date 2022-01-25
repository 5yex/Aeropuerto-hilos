package Gestion;

import Modelo.Avion;
import Modelo.TorreDeControl;

/**
 * Proyecto TORRE DE CONTROL AEROPUERTO
 * 
 * Versión 2: (LA ACORDE CON EL ENUNCIADO)
 * 
 * - En esta versión los aviones piden una pista a la torre de control: · Si la
 * pista está ocupada, repite su bucle hasta que vuelve a pedir pista. · Si la
 * pista está LIBRE, aterriza en ella y realiza todas sus acciones.
 *
 * - La pista asignada es aleatoria-
 * 
 * 
 * @author José Miguel Calderón de la Barca y José Miguel García Orejudo
 * 
 */
public class Main {
	public static void main(String[] args) {
		//NOTA: INTERFAZ GRÁFICA PENDIENTE Y MANUAL DE USUARIO PENDIENTES
		iniciarAeropuerto(6, 2, false);
	}

	/**
	 * Método que inicia el aerpuerto
	 * 
	 * @author José Miguel Calderón de la Barca
	 * @param nAviones       Numero de aviones que volaran sobre el aeropuerto
	 * @param nPistas        Numero de pistas de las que dispondrá el aeropuerto
	 * @param funcionEnBucle Alterna en que los aviones funcionen en bucle, o tengan
	 *                       fin al terminar sus acciones
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

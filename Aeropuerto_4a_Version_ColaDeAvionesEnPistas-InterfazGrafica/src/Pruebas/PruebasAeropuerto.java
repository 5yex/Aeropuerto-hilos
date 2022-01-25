package Pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import Operaciones.OperacionesAeropuerto;

public class PruebasAeropuerto {

	@Test
	public void iniciacionCorrecta() {
		OperacionesAeropuerto aeropuerto = new OperacionesAeropuerto(5, 3, false);
		assertEquals(true, aeropuerto.iniciarAeropuerto());
	}
	
	@Test
	public void iniciacionIncorrecta() {
		OperacionesAeropuerto aeropuerto = new OperacionesAeropuerto(2, 99, false);
		assertEquals(false, aeropuerto.iniciarAeropuerto());
	}

}

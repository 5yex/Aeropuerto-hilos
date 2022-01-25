package Pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

public class PruebasAeropuerto {

	@Test
	public void iniciacionCorrecta() {
		assertEquals(true, Gestion.Main.iniciarAeropuerto(5, 3, false));
	}
	
	@Test
	public void iniciacionIncorrecta() {
		assertEquals(false, Gestion.Main.iniciarAeropuerto(1, 30, false));
	}

}

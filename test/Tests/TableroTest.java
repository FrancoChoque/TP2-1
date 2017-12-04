package modelo;


import org.junit.Assert;
import org.junit.Test;

import modelo.Tablero;

public class TableroTest {
	@Test
	public void test00CrearDosInstanciasDeTableroDevuelveLaMisma() {
		Tablero tablerouno = Tablero.getInstance();
		Tablero tablerodos = Tablero.getInstance();
		
		Assert.assertEquals(tablerodos, tablerouno);
		
	}
	
}

package Entrega1;

import modelo.*;
import modelo.Jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class Prueba102Test {

	@Test
	public void test(){
		Tablero tablero = Tablero.resetInstance();
		Jugador jugador = new Jugador("jugador1");
		tablero.agregarJugador(jugador);
		tablero.moverJugador(jugador, 1);
		tablero.moverJugador(jugador, 20);
		
		Assert.assertEquals(180000,jugador.getDinero());
	}
}

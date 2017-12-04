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
		Tablero.getInstance().obtenerCasillero(jugador).getestado().hacerEfectoDelCasillero(jugador);
		
		tablero.moverJugador(jugador, 20);
		Tablero.getInstance().obtenerCasillero(jugador).getestado().hacerEfectoDelCasillero(jugador);
		
		
		Assert.assertEquals(180000,jugador.getDinero());
	}
}

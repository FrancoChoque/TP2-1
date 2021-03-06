package Entrega1;

import modelo.*;
import modelo.Jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class Prueba108Test {

	@Test
	public void jugadorCaeEnAvanceDinamicoYConDados5PosicionJugador10Test(){
		Tablero tablero = Tablero.resetInstance();
		Jugador jugador = new Jugador("jugador1");
		tablero.agregarJugador(jugador);
		
		jugador.setValorDados(5);
		tablero.moverJugador(jugador, 7);
		Tablero.getInstance().obtenerCasillero(jugador).getestado().hacerEfectoDelCasillero(jugador);
		
		
		Assert.assertEquals(10,tablero.obtenerPosicion(jugador));
	}
}

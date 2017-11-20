package Entrega1;

import modelo.*;
import modelo.Jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class Prueba110Test {

	@Test
	public void jugadorCaeEnAvanceDinamicoConDados11yCon5PropiedadPosicionJugador13Test(){
		Tablero tablero = Tablero.resetInstance();
		Jugador jugador = new Jugador("jugador1");

        jugador.setEstado(jugador.getJugadorEmpezandoTurno());

		jugador.aumentarNumeroDePropiedades(5);
		tablero.agregarJugador(jugador);
		
		jugador.setValorDados(11);
		tablero.moverJugador(jugador, 7);
		
		Assert.assertEquals(13,tablero.obtenerPosicion(jugador));
	}
}

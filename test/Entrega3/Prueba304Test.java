package Entrega3;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import excepciones.JugadorYaTiroDados;
import excepciones.NoEsTurnoJugador;
import excepciones.FinDelJuego;
import modelo.AlgoPoly;
import modelo.Jugador.Jugador;

public class Prueba304Test {

	@Test
	public void test() {
		AlgoPoly algopoly = new AlgoPoly();
		Jugador jugador = algopoly.nuevoJugador("jugador1");
	
		try {
			algopoly.usarTurno(jugador);
		} catch (NoEsTurnoJugador | JugadorYaTiroDados e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FinDelJuego e) {
			
		}
		
		Assert.assertEquals(jugador.getValorDados(), algopoly.obtenerPosicion(jugador));
	}

}

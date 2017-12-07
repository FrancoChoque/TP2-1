package Entrega3;

import org.junit.Assert;
import org.junit.Test;

import excepciones.JugadorYaTiroDados;
import excepciones.NoEsTurnoJugador;
import modelo.AlgoPoly;
import modelo.Jugador.Jugador;

public class Prueba304Test {

	@Test
	public void test() {
		AlgoPoly algopoly = new AlgoPoly();
		Jugador jugador = algopoly.nuevoJugador("jugador1");
		jugador.setDinero(7);
		jugador.setEstado(jugador.getJugadorEmpezandoTurno() );
			
		try {
			algopoly.arrojarDados(jugador);
		} catch (NoEsTurnoJugador | JugadorYaTiroDados e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals(jugador.getValorDados(), algopoly.obtenerPosicion(jugador));
	}

}

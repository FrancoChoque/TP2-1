package Entrega3;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import excepciones.JugadorYaTiroDados;
import excepciones.NoEsTurnoJugador;
import modelo.Jugador.Jugador;
import modelo.*;

public class Prueba302Test {

	@Test
	public void test(){
    	AlgoPoly algopoly = new AlgoPoly();
		Jugador jugador = algopoly.nuevoJugador("jugador1");
		jugador.ponerDadosIguales();
		
		
		try {
			algopoly.usarTurno(jugador);
			algopoly.usarTurno(jugador);
		} catch (NoEsTurnoJugador | JugadorYaTiroDados e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals(jugador.getJugadorTiroDados() , jugador.getEstadoDeJugador() );
    }

}

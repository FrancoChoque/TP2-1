package Entrega3;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import excepciones.FinDelJuego;
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
		jugador.setEstado(jugador.getJugadorEmpezandoTurno() );
		
		
		try {
			algopoly.arrojarDados(jugador);
			algopoly.tiraDeVuelta(jugador);
		} catch (NoEsTurnoJugador | JugadorYaTiroDados e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(FinDelJuego e) {
			System.out.println("Fin del juego");
		}
		
		try {
			algopoly.arrojarDados(jugador);
			algopoly.tiraDeVuelta(jugador);
		} catch (NoEsTurnoJugador | JugadorYaTiroDados e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FinDelJuego e) {
			// TODO Auto-generated catch block
			System.out.println("Fin del juego");
		}
		
		Assert.assertEquals(jugador.getJugadorTiroDados() , jugador.getEstadoDeJugador() );
    }

}

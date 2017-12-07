package Entrega3;

import org.junit.Assert;
import org.junit.Test;

import estados.EstadoCasillero;
import estados.Comprable.Comprable;
import excepciones.DineroInsuficiente;
import excepciones.NoEsTurnoJugador;
import modelo.AlgoPoly;
import modelo.Casillero;
import modelo.Tablero;
import modelo.Jugador.Jugador;

public class Prueba306Test {

	@Test
	public void test() {
		
		AlgoPoly algopoly = new AlgoPoly();
		Jugador jugador1 = algopoly.nuevoJugador("jugador1");
		Jugador jugador2 = algopoly.nuevoJugador("jugador2");
		jugador2.setDinero(1);
		
		Tablero tablero = Tablero.getInstance();
		
		jugador1.setEstado(jugador1.getJugadorTiroDados() );
		tablero.moverJugador(jugador1, 2);
		Casillero unacasilla = tablero.obtenerCasillero(jugador1);
		EstadoCasillero estado = unacasilla.getestado();
		try {
			jugador1.comprar((Comprable) estado);
		} catch (NoEsTurnoJugador e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jugador2.setEstado(jugador2.getJugadorTiroDados() );
		
		try {
			tablero.moverJugador(jugador2, 2);
	        Tablero.getInstance().obtenerCasillero(jugador2).getestado().hacerEfectoDelCasillero(jugador2);
		}
		catch (DineroInsuficiente e) {
			algopoly.quitarJugador(jugador2);
		}
		
		Assert.assertEquals(1, algopoly.getCantidadJugadores() );;
	}

}

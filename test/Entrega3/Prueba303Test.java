package Entrega3;


import org.junit.Assert;
import org.junit.Test;

import estados.EstadoCasillero;
import estados.Comprable.Comprable;
import excepciones.DineroInsuficiente;
import excepciones.NoEsTurnoJugador;
import modelo.Jugador.Jugador;
import modelo.AlgoPoly;
import modelo.Tablero;
import modelo.Casillero;

public class Prueba303Test {

	@Test
	public void test() {
		
		AlgoPoly algopoly = new AlgoPoly();
		Jugador jugador1 = algopoly.nuevoJugador("jugador1");
		Jugador jugador2 = algopoly.nuevoJugador("jugador2");
		
		Tablero tablero = Tablero.getInstance();
		
		//Jugador1 compra buenos aires norte
		jugador1.setEstado(jugador1.getJugadorTiroDados() );
		tablero.moverJugador(jugador1, 4);
		Casillero unacasilla = tablero.obtenerCasillero(jugador1);
		EstadoCasillero estado = unacasilla.getestado();
		try {
			jugador1.comprar((Comprable) estado);
		} catch (NoEsTurnoJugador e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Jugador 2 compra buenos aires sur
		jugador2.setEstado(jugador2.getJugadorTiroDados() );
		tablero.moverJugador(jugador2, 2);
		unacasilla = tablero.obtenerCasillero(jugador2);
		estado = unacasilla.getestado();
		try {
			jugador2.comprar((Comprable) estado);
		} catch (NoEsTurnoJugador e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Jugador 2 cae en buenos aires norte sin dinero suficiente
		jugador2.setDinero(0);
		jugador2.setEstado(jugador2.getJugadorTiroDados() );
		try {
			tablero.moverJugador(jugador2, 2);
			algopoly.efectoCasillero(jugador2);
		}
		catch (DineroInsuficiente e) {
			algopoly.vender(jugador2, tablero.getBuenosAiresSur() );
			jugador1.sumarDinero(2500);
		}
		
		
		
		
		Assert.assertEquals(75000 + 2500, jugador1.getDinero() );;
	}

}

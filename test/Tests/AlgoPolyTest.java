package Tests;


import org.junit.Assert;
import org.junit.Test;

import modelo.AlgoPoly;
import modelo.Tablero;
import modelo.Jugador.Jugador;

public class AlgoPolyTest {

	@Test
	public void test00JugadorCompraQuini6YNoPuede() {
		AlgoPoly unalgopoly = new AlgoPoly();
		Jugador unjugador = unalgopoly.nuevoJugador("player");
		Tablero untablero = Tablero.getInstance();
		unjugador.setEstado(unjugador.getJugadorEmpezandoTurno());
		untablero.moverJugador(unjugador, 1);
        Tablero.getInstance().obtenerCasillero(unjugador).getestado().hacerEfectoDelCasillero(unjugador);
		
		
		unalgopoly.comprar(unjugador);
		
		Assert.assertEquals(150000, unjugador.getDinero() );
		
	}

	
	@Test
	public void test01JugadorCompraBuenosAiresSurYGasta20000() {
		AlgoPoly unalgopoly = new AlgoPoly();
		Jugador unjugador = unalgopoly.nuevoJugador("player");
		Tablero untablero = Tablero.getInstance();
		unjugador.setEstado(unjugador.getJugadorEmpezandoTurno());
		untablero.moverJugador(unjugador, 2);
		
		unalgopoly.comprar(unjugador);
		
		Assert.assertEquals(80000, unjugador.getDinero() );
		
	}
	
}

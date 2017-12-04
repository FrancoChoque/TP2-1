package Entrega1;

import controlador.AlertBox;
import modelo.Jugador.Jugador;
import org.junit.Test;
import org.junit.Assert;
import modelo.*;

public class Prueba112Test {

	@Test
	public void test00JugadorCaeEnPoliciaSeEnviaALaCarcelYNoPuedeMoverse() throws Exception {

		AlgoPoly algoPoly = new AlgoPoly();
		Tablero untablero = Tablero.resetInstance();
		Jugador unjugador = new Jugador("Player");

		unjugador.setEstado(unjugador.getJugadorEmpezandoTurno());
		untablero.agregarJugador(unjugador);
		
		untablero.moverJugador(unjugador, 15);

		algoPoly.efectoCasillero(unjugador);

		algoPoly.efectoCasillero(unjugador);

		Assert.assertFalse(unjugador.puedeMoverse() );
	}

}

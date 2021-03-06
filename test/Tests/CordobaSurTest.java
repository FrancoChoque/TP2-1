package Tests;

import estados.Comprable.Comprable;
import org.junit.Assert;
import org.junit.Test;

import modelo.Casillero;
import modelo.Jugador.Jugador;
import modelo.Tablero;

public class CordobaSurTest {

	@Test
	public void test00ComprarCordobaSurReduceElDineroDelJugadorEn18000() throws Exception {
		Tablero untablero = Tablero.getInstance();

		untablero.resetearTablero();
		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 6);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprar(unterreno);
		
		Assert.assertEquals(82000, player.getDinero() );
	}

}

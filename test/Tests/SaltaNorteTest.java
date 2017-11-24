package Tests;

import estados.Comprable.Comprable;
import org.junit.Assert;
import org.junit.Test;

import modelo.Casillero;
import modelo.Jugador.Jugador;
import modelo.Tablero;

public class SaltaNorteTest {

	@Test
	public void test00ComprarSaltaNorteReduceElDineroDelJugadorEn23000() throws Exception {
		Tablero untablero = Tablero.getInstance();
		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 13);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprar(unterreno);
		
		Assert.assertEquals(77000, player.getDinero() );
	}

}

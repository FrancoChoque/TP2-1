package Tests;

import estados.Comprable.Comprable;
import org.junit.Assert;
import org.junit.Test;

import modelo.Casillero;
import modelo.Jugador.Jugador;
import modelo.Tablero;

public class SantaFeTest {

	@Test
	public void test00ComprarSantaFeReduceElDineroDelJugadorEn15000() {
		Tablero untablero = Tablero.getInstance();

		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 11);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprarTerreno(unterreno);
		
		Assert.assertEquals(85000, player.getDinero() );
	}

}

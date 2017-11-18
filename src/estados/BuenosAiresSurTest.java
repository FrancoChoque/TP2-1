package estados;



import modelo.Jugador.Jugador;
import org.junit.Assert;

import org.junit.Test;

import modelo.*;


public class BuenosAiresSurTest {

	@Test
	public void test00ComprarBuenosAiresSurReduceElDineroDelJugadorEn20000() {
		Tablero untablero = Tablero.resetInstance();
		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 2);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprarTerreno(unterreno);
		
		Assert.assertEquals(80000, player.getDinero() );
	}

}

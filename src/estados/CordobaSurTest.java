package estados;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import modelo.Casillero;
import modelo.Jugador;
import modelo.Tablero;

public class CordobaSurTest {

	@Test
	public void test00ComprarCordobaSurReduceElDineroDelJugadorEn18000() {
		Tablero untablero = Tablero.getInstance();
		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 6);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprarTerreno(unterreno);
		
		Assert.assertEquals(82000, player.getDinero() );
	}

}

package estados;

import org.junit.Assert;
import org.junit.Test;

import modelo.Casillero;
import modelo.Jugador.Jugador;
import modelo.Tablero;

public class CordobaNorteTest {

	@Test
	public void test00ComprarCordobaNorteReduceElDineroDelJugadorEn20000() {
		Tablero untablero = Tablero.getInstance();
		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 9);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprarTerreno(unterreno);
		
		Assert.assertEquals(80000, player.getDinero() );
	}

}

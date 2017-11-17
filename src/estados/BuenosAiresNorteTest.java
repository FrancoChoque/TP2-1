package estados;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import modelo.Casillero;
import modelo.Jugador;
import modelo.Tablero;

public class BuenosAiresNorteTest {

	@Test
	public void test00ComprarBuenosAiresNorteReduceElDineroDelJugadorEn25000() {
		Tablero untablero = Tablero.getInstance();
		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 4);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprarTerreno(unterreno);
		
		Assert.assertEquals(75000, player.getDinero() );
	}

}

import org.junit.Assert;

import org.junit.Test;


public class BuenosAiresSurTest {

	@Test
	public void test00ComprarTerrenoReduceElDineroDelJugadorEn20000() {
		Tablero untablero = Tablero.getInstance();
		Jugador player = new Jugador("plauer");
		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 2);
		
		Assert.assertEquals(80000, player.getDinero() );
	}

}

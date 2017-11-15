import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Prueba03Test {

	@Test
	public void test() {
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new Jugador("jugador1");
		tablero.agregarJugador(jugador);
		
		tablero.moverJugador(jugador, 1);
		
		tablero.moverJugador(jugador, 20);
		
		tablero.moverJugador(jugador, 20);
		
		Assert.assertEquals(180000,jugador.getDinero());
	}

}

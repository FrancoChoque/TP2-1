import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Prueba01Test {

	@Test
	public void test(){
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador("jugador1");
		tablero.agregarJugador(jugador);
		tablero.moverJugador(jugador, 1);
		
		Assert.assertEquals(150000,jugador.getDinero());
	}

}

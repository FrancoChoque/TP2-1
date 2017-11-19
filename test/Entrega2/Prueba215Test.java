import org.junit.Assert;
import org.junit.Test;

import modelo.Tablero;
import modelo.Jugador.Jugador;

public class Prueba215Test {

	@Test
	public void jugadorCaeImpuestoConDinero100000TieneQueRestar10000Test(){
		Tablero tablero = Tablero.resetInstance();
		Jugador jugador = new Jugador("jugador1");
		tablero.agregarJugador(jugador);
		tablero.moverJugador(jugador, 10);
		
		Assert.assertEquals(90000,jugador.getDinero());
	}
}

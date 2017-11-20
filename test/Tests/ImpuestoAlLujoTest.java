package Tests;

import modelo.Tablero;
import modelo.Jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class ImpuestoAlLujoTest {

	@Test
	public void jugadorCaeImpuestoConDinero0NoDescontarNadaTest(){
		Tablero tablero = Tablero.resetInstance();
		Jugador jugador = new Jugador("jugador1");
		jugador.setDinero(0);
		tablero.agregarJugador(jugador);
		tablero.moverJugador(jugador, 10);
		
		Assert.assertEquals(0,jugador.getDinero());
	}
	
	@Test
	public void jugadorCaeImpuestoConDinero100000TieneQueRestar10000Test(){
		Tablero tablero = Tablero.resetInstance();
		Jugador jugador = new Jugador("jugador1");
		tablero.agregarJugador(jugador);
		tablero.moverJugador(jugador, 10);
		
		Assert.assertEquals(90000,jugador.getDinero());
	}
}

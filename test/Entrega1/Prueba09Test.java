import modelo.*;
import excepciones.*;

import org.junit.Assert;
import org.junit.Test;

public class Prueba09Test {

	@Test
	public void jugadorCaeEnAvanceDinamicoYDados7DineroDe10PosicionJugador10Test(){
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new Jugador("jugador1");
		jugador.setDinero(10);
		tablero.agregarJugador(jugador);
		jugador.setValorDados(7);
		tablero.moverJugador(jugador, 7);
		
		Assert.assertEquals(10,tablero.obtenerPosicion(jugador));
	}
}

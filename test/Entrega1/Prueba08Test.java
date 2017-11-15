import org.junit.Assert;
import org.junit.Test;

public class Prueba08Test {

	@Test
	public void jugadorCaeEnAvanceDinamicoYConDados5PosicionJugador10Test(){
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new Jugador("jugador1");
		tablero.agregarJugador(jugador);
		
		jugador.setValorDados(5);
		tablero.moverJugador(jugador, 7);
		
		Assert.assertEquals(10,tablero.obtenerPosicion(jugador));
	}
}

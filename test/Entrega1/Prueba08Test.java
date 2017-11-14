import org.junit.Assert;
import org.junit.Test;

public class Prueba08Test {

	@Test
	public void jugadorCaeEnAvanceDinamicoYConDados5PosicionJugador10Test(){
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador("jugador1");
		tablero.agregarJugador(jugador);
		
		tablero.moverJugador(jugador, 2);
		
		//cae en AvanceDinamico
		tablero.moverJugador(jugador, 5);
		
		Assert.assertEquals(10,tablero.obtenerPosicion(jugador));
	}
}

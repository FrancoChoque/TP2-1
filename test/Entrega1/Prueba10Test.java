import org.junit.Assert;
import org.junit.Test;

public class Prueba10Test {

	@Test
	public void jugadorCaeEnAvanceDinamicoConDados11yCon5PropiedadPosicionJugador13Test(){
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new Jugador("jugador1");
		jugador.setDinero(10);
		jugador.aumentarNumeroDePropiedades(5);
		tablero.agregarJugador(jugador);
		
		//doy una vuelta para caer en avance dinamico con numero de dados 11

		tablero.moverJugador(jugador, 16);
		
		tablero.moverJugador(jugador, 11);
		
		Assert.assertEquals(13,tablero.obtenerPosicion(jugador));
	}
}

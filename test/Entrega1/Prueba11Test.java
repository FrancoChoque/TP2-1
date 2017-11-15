import org.junit.Assert;
import org.junit.Test;

public class Prueba11Test {

	@Test
	public void jugadorCaeEnRetrocesoDinamicoYConDados5SinProdiedadesPosicionJugador13Test(){
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new Jugador("jugador1");
		tablero.agregarJugador(jugador);
		
		jugador.setValorDados(5);
		tablero.moverJugador(jugador, 18);
		
		Assert.assertEquals(13,tablero.obtenerPosicion(jugador));
	}
	
	@Test
	public void jugadorCaeEnRetrocesoDinamicoYConDados5conProdiedades3PosicionJugador16Test(){
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new Jugador("jugador1");
		tablero.agregarJugador(jugador);
		
		jugador.aumentarNumeroDePropiedades(3);
		jugador.setValorDados(5);
		tablero.moverJugador(jugador, 18);
		
		Assert.assertEquals(16,tablero.obtenerPosicion(jugador));
	}
	
	@Test
	public void jugadorCaeEnRetrocesoDinamicoYConDados7Dinero10PosicionJugador16Test(){
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new Jugador("jugador1");
		tablero.agregarJugador(jugador);
		jugador.setDinero(10);
		jugador.setValorDados(8);
		tablero.moverJugador(jugador, 18);
		
		Assert.assertEquals(16,tablero.obtenerPosicion(jugador));
	}
	
	@Test
	public void jugadorCaeEnRetrocesoDinamicoYConDados12PosicionJugador8Test(){
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new Jugador("jugador1");
		tablero.agregarJugador(jugador);
		
		jugador.setValorDados(12);
		tablero.moverJugador(jugador, 18);
		
		Assert.assertEquals(8,tablero.obtenerPosicion(jugador));
	}
}

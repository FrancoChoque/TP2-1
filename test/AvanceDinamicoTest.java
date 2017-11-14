import org.junit.Assert;
import org.junit.Test;

public class AvanceDinamicoTest {

	@Test
	public void jugadorCaeEnAvanceDinamicoYConDados5PosicionJugador10(){
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador("jugador1");
		tablero.agregarJugador(jugador);
		jugador.comenzarTurno();
		tablero.moverJugador(jugador, 2);
		jugador.comenzarTurno();
		tablero.moverJugador(jugador, 5);
		
		Assert.assertEquals(10,tablero.obtenerPosicion(jugador));
	}
	
	@Test
	public void jugadorCaeEnAvanceDinamicoYConUnaPropiedadDados5PosicionJugador10(){
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador("jugador1");
		jugador.aumentarNumeroDePropiedades(1);
		tablero.agregarJugador(jugador);
		jugador.comenzarTurno();
		tablero.moverJugador(jugador, 2);
		jugador.comenzarTurno();
		tablero.moverJugador(jugador, 5);
		
		Assert.assertEquals(10,tablero.obtenerPosicion(jugador));
	}
	
	@Test
	public void jugadorCaeEnAvanceDinamicoYDados7DineroDe10PosicionJugador10(){
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador("jugador1");
		jugador.setDinero(10);
		tablero.agregarJugador(jugador);
		jugador.comenzarTurno();
		tablero.moverJugador(jugador, 7);
		
		Assert.assertEquals(10,tablero.obtenerPosicion(jugador));
	}
	
	@Test
	public void jugadorCaeEnAvanceDinamicoYDados7yConUnaPropiedadDineroDe10PosicionJugador10(){
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador("jugador1");
		jugador.setDinero(10);
		jugador.aumentarNumeroDePropiedades(1);
		tablero.agregarJugador(jugador);
		jugador.comenzarTurno();
		tablero.moverJugador(jugador, 7);
		
		Assert.assertEquals(10,tablero.obtenerPosicion(jugador));
	}
	
	@Test
	public void jugadorCaeEnAvanceDinamicoConDados11yCon5PropiedadPosicionJugador13(){
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador("jugador1");
		jugador.setDinero(10);
		jugador.aumentarNumeroDePropiedades(5);
		tablero.agregarJugador(jugador);
		
		//una vuelta para caer en avance dinamico con numero de dados 11
		jugador.comenzarTurno();
		tablero.moverJugador(jugador, 16);
		jugador.comenzarTurno();
		tablero.moverJugador(jugador, 11);
		
		Assert.assertEquals(13,tablero.obtenerPosicion(jugador));
	}
	
}

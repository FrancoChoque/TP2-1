package estados;
import modelo.*;
import modelo.Jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class AvanceDinamicoTest {

	@Test
	public void jugadorCaeEnAvanceDinamicoYConDados5PosicionJugador10Test(){
		Tablero tablero = Tablero.resetInstance();
		Jugador jugador = new Jugador("jugador1");
		tablero.agregarJugador(jugador);
		jugador.setEstado(jugador.getJugadorEmpezandoTurno());
		
		jugador.setValorDados(5);
		tablero.moverJugador(jugador, 7);
		
		Assert.assertEquals(10,tablero.obtenerPosicion(jugador));
	}
	
	@Test
	public void jugadorCaeEnAvanceDinamicoYConUnaPropiedadDados5PosicionJugador10Test(){
		Tablero tablero = Tablero.resetInstance();
		Jugador jugador = new Jugador("jugador1");
		jugador.setEstado(jugador.getJugadorEmpezandoTurno());
		jugador.aumentarNumeroDePropiedades(1);
		tablero.agregarJugador(jugador);
		
		jugador.setValorDados(5);
		tablero.moverJugador(jugador, 7);
		
		Assert.assertEquals(10,tablero.obtenerPosicion(jugador));
	}
	
	@Test
	public void jugadorCaeEnAvanceDinamicoYDados7DineroDe10PosicionJugador10Test(){
		Tablero tablero = Tablero.resetInstance();
		Jugador jugador = new Jugador("jugador1");
		jugador.setDinero(10);
		tablero.agregarJugador(jugador);
		
		jugador.setValorDados(7);
		tablero.moverJugador(jugador, 7);
		
		Assert.assertEquals(10,tablero.obtenerPosicion(jugador));
	}
	
	@Test
	public void jugadorCaeEnAvanceDinamicoYDados7yConUnaPropiedadDineroDe10PosicionJugador10Test(){
		Tablero tablero = Tablero.resetInstance();
		Jugador jugador = new Jugador("jugador1");
		jugador.setDinero(10);
		jugador.aumentarNumeroDePropiedades(1);
		tablero.agregarJugador(jugador);
		
		jugador.setValorDados(7);
		tablero.moverJugador(jugador, 7);
		
		Assert.assertEquals(10,tablero.obtenerPosicion(jugador));
	}
	
	@Test
	public void jugadorCaeEnAvanceDinamicoConDados11yCon5PropiedadPosicionJugador13Test(){
		Tablero tablero = Tablero.resetInstance();
		Jugador jugador = new Jugador("jugador1");
        jugador.setEstado(jugador.getJugadorEmpezandoTurno());
		jugador.setDinero(10);
		jugador.aumentarNumeroDePropiedades(5);
		tablero.agregarJugador(jugador);
	
		jugador.setValorDados(11);
		tablero.moverJugador(jugador, 7);
		
		Assert.assertEquals(13,tablero.obtenerPosicion(jugador));
	}
	
}

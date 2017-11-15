import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Prueba11Test {

	@Test
	public void test00JugadorCaeEnRetrocesoConDadosEn6YUnaPropiedadRetrocede5Casillas() {
		Tablero untablero = Tablero.getInstance();
		Jugador player = new Jugador("playuer");
		player.setNumeroPropiedades(1);		
		untablero.agregarJugador(player);
		untablero.moverJugador(player, 12);
		
		untablero.moverJugador(player, 6);
		
		Assert.assertEquals(13, untablero.obtenerPosicion(player) );
	}
	
	@Test
	public void test01JugadorCaeEnRetrocesoConDadosEn9YRetrocede1Casillero() {
		Tablero untablero = Tablero.getInstance();
		Jugador player = new Jugador("playuer");
		player.setNumeroPropiedades(1);		
		untablero.agregarJugador(player);
		untablero.moverJugador(player, 9);
		
		untablero.moverJugador(player, 9);
		
		Assert.assertEquals(17, untablero.obtenerPosicion(player));
	}
	
	@Test
	public void test02JugadorCaeEnRetrocesoConDadosEn12YRetrocede10Casilleros() {
		Tablero untablero = Tablero.getInstance();
		Jugador player = new Jugador("playuer");
		untablero.agregarJugador(player);
		untablero.moverJugador(player, 6);
		
		untablero.moverJugador(player, 12);
		
		Assert.assertEquals(8, untablero.obtenerPosicion(player));
	}
	
}

package Tests;



import modelo.Jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

import modelo.*;


public class RetrocesoDinamicoTest {

	@Test
	public void test00JugadorCaeEnRetrocesoConDadosEn6YUnaPropiedadRetrocede5Casillas() {
		Tablero untablero = Tablero.getInstance();
		Jugador player = new Jugador("playuer");
		player.setNumeroPropiedades(1);
		player.setEstado(player.getJugadorEmpezandoTurno());
		untablero.agregarJugador(player);
		
		player.setValorDados(6);
		untablero.moverJugador(player, 18);
        Tablero.getInstance().obtenerCasillero(player).getestado().hacerEfectoDelCasillero(player);
		
		Assert.assertEquals(13, untablero.obtenerPosicion(player) );
	}
	
	@Test
	public void test01JugadorCaeEnRetrocesoConDadosEn9YRetrocede1Casillero() {
		Tablero untablero = Tablero.getInstance();
		Jugador player = new Jugador("playuer");
		player.setNumeroPropiedades(1);
        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		player.setValorDados(9);
		untablero.moverJugador(player, 18);
        Tablero.getInstance().obtenerCasillero(player).getestado().hacerEfectoDelCasillero(player);
		
		Assert.assertEquals(17, untablero.obtenerPosicion(player));
	}
	
	@Test
	public void test02JugadorCaeEnRetrocesoConDadosEn12YRetrocede10Casilleros() {
		Tablero untablero = Tablero.getInstance();
		Jugador player = new Jugador("playuer");
		untablero.agregarJugador(player);
		
		player.setValorDados(12);
		untablero.moverJugador(player, 18);
        Tablero.getInstance().obtenerCasillero(player).getestado().hacerEfectoDelCasillero(player);
		
		Assert.assertEquals(8, untablero.obtenerPosicion(player));
	}
	
}

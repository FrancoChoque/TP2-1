package Entrega1;

import modelo.*;
import modelo.Jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class Prueba111Test {

	@Test
	public void test00JugadorCaeEnRetrocesoConDadosEn6YUnaPropiedadRetrocede5Casillas() {
		Tablero untablero = Tablero.resetInstance();
		Jugador player = new Jugador("playuer");
        player.setEstado(player.getJugadorEmpezandoTurno());
		player.setNumeroPropiedades(1);
		untablero.agregarJugador(player);
		
		player.setValorDados(6);
		untablero.moverJugador(player, 18);
		Tablero.getInstance().obtenerCasillero(player).getestado().hacerEfectoDelCasillero(player);
		
		Assert.assertEquals(13, untablero.obtenerPosicion(player) );
	}
	
	@Test
	public void test01JugadorCaeEnRetrocesoConDadosEn9YRetrocede1Casillero() {
		Tablero untablero = Tablero.resetInstance();
		Jugador player = new Jugador("playuer");
		player.setEstado(player.getJugadorEmpezandoTurno());
		player.setNumeroPropiedades(1);		
		untablero.agregarJugador(player);
		
		player.setValorDados(9);
		untablero.moverJugador(player, 18);
		Tablero.getInstance().obtenerCasillero(player).getestado().hacerEfectoDelCasillero(player);
		
		
		Assert.assertEquals(17, untablero.obtenerPosicion(player));
	}
	
	@Test
	public void test02JugadorCaeEnRetrocesoConDadosEn12YRetrocede10Casilleros() {
		Tablero untablero = Tablero.resetInstance();
		Jugador player = new Jugador("playuer");
		untablero.agregarJugador(player);
		
		player.setValorDados(12);
		untablero.moverJugador(player, 18);
		Tablero.getInstance().obtenerCasillero(player).getestado().hacerEfectoDelCasillero(player);
		
		
		Assert.assertEquals(8, untablero.obtenerPosicion(player));
	}
}

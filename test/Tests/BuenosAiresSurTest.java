package Tests;

import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import modelo.Jugador.Jugador;
import org.junit.Assert;

import org.junit.Test;

import modelo.*;


public class BuenosAiresSurTest {

	@Test
	public void test00ComprarBuenosAiresSurReduceElDineroDelJugadorEn20000() throws Exception {
		Tablero untablero = Tablero.getInstance();
		untablero.resetearTablero();

		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 2);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprar(unterreno);
		
		Assert.assertEquals(80000, player.getDinero() );
	}

	
	@Test
	public void test01JugadorCaeEnBuenosairesSurConUnaCasaYPaga3000() throws Exception {

	        Tablero untablero = Tablero.getInstance();
	        untablero.resetearTablero();

	        Jugador player = new Jugador("plauer");
	        player.setEstado(player.getJugadorEmpezandoTurno());
	        untablero.agregarJugador(player);

	        untablero.moverJugador(player, 2);
	        Casillero unacasilla = untablero.obtenerCasillero(player);
	        Comprable unterreno = (Comprable) unacasilla.getestado();
	        player.comprar(unterreno);


	        untablero.moverJugador(player, 2);
	        Casillero otraCasilla = untablero.obtenerCasillero(player);
	        Comprable otroTerreno = (Comprable) otraCasilla.getestado();
	        player.comprar(otroTerreno);

	        Assert.assertEquals(55000, player.getDinero() );

			player.construir(untablero.getBuenosAiresSur(), new Casa());

			Jugador jugador = new Jugador("Wilson");
	        jugador.setEstado(jugador.getJugadorEmpezandoTurno() );
	        untablero.agregarJugador(jugador);
	        untablero.moverJugador(jugador, 2);
	        
	        Tablero.getInstance().obtenerCasillero(jugador).getestado().hacerEfectoDelCasillero(jugador);
	        
	        Assert.assertEquals(97000, jugador.getDinero());

	    }
	
}
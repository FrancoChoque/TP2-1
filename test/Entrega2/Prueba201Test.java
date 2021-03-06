package Entrega2;

import estados.Comprable.Comprable;
import org.junit.Assert;
import org.junit.Test;


import modelo.Casillero;
import modelo.Jugador.Jugador;
import modelo.Tablero;

public class Prueba201Test {

	@Test
	public void test00ComprarBuenosAiresSurReduceElDineroDelJugadorEn20000() throws Exception {

		Tablero untablero = Tablero.getInstance();
		untablero.resetearTablero();

		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);

		player.comprar(untablero.getBuenosAiresSur());
		
		Assert.assertEquals(80000, player.getDinero() );
	}
	
	@Test
	public void test01ComprarBuenosAiresNorteReduceElDineroDelJugadorEn25000() throws Exception {

		Tablero untablero = Tablero.getInstance();
		untablero.resetearTablero();

		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);

		player.comprar(untablero.getBuenosAiresNorte());
		
		Assert.assertEquals(75000, player.getDinero() );
	}

	@Test
	public void test02ComprarCordobaSurReduceElDineroDelJugadorEn18000() throws Exception {

		Tablero untablero = Tablero.getInstance();
		untablero.resetearTablero();

		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 6);

		player.comprar(untablero.getCordobaSur());
		
		Assert.assertEquals(82000, player.getDinero() );
	}
	
	@Test
	public void test03ComprarCordobaNorteReduceElDineroDelJugadorEn20000() throws Exception {

		Tablero untablero = Tablero.getInstance();
		untablero.resetearTablero();

		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 9);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprar(unterreno);
		
		Assert.assertEquals(80000, player.getDinero() );
	}

	@Test
	public void test04ComprarSantaFeReduceElDineroDelJugadorEn15000() throws Exception {

		Tablero untablero = Tablero.getInstance();
		untablero.resetearTablero();

		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 11);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprar(unterreno);
		
		Assert.assertEquals(85000, player.getDinero() );
	}

	@Test
	public void test05ComprarSaltaNorteReduceElDineroDelJugadorEn23000() throws Exception {

		Tablero untablero = Tablero.getInstance();
		untablero.resetearTablero();

		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 13);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprar(unterreno);
		
		Assert.assertEquals(77000, player.getDinero() );
	}
	
	@Test
	public void test06ComprarSaltaSurReduceElDineroDelJugadorEn23000() throws Exception {

		Tablero untablero = Tablero.getInstance();
		untablero.resetearTablero();

		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 14);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprar(unterreno);
		
		Assert.assertEquals(77000, player.getDinero() );
	}

	@Test
	public void test07ComprarNeuquenReduceElDineroDelJugadorEn17000() throws Exception {

		Tablero untablero = Tablero.getInstance();
		untablero.resetearTablero();

		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 17);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprar(unterreno);
		
		Assert.assertEquals(83000, player.getDinero() );
	}
	
	@Test
	public void test08ComprarTucumanReduceElDineroDelJugadorEn25000() throws Exception {

		Tablero untablero = Tablero.getInstance();
		untablero.resetearTablero();

		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 19);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprar(unterreno);
		
		Assert.assertEquals(75000, player.getDinero() );
	}
	
	
}

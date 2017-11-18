import org.junit.Assert;
import org.junit.Test;

import estados.Comprable;
import modelo.Casillero;
import modelo.Jugador.Jugador;
import modelo.Tablero;

public class Prueba201Test {

	@Test
	public void test00ComprarBuenosAiresSurReduceElDineroDelJugadorEn20000() {
		Tablero untablero = Tablero.resetInstance();
		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 2);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprarTerreno(unterreno);


		
		Assert.assertEquals(80000, player.getDinero() );
	}
	
	@Test
	public void test01ComprarBuenosAiresNorteReduceElDineroDelJugadorEn25000() {
		Tablero untablero = Tablero.resetInstance();
		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 4);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprarTerreno(unterreno);
		
		Assert.assertEquals(75000, player.getDinero() );
	}

	@Test
	public void test02ComprarCordobaSurReduceElDineroDelJugadorEn18000() {
		Tablero untablero = Tablero.resetInstance();
		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 6);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprarTerreno(unterreno);
		
		Assert.assertEquals(82000, player.getDinero() );
	}
	
	@Test
	public void test03ComprarCordobaNorteReduceElDineroDelJugadorEn20000() {
		Tablero untablero = Tablero.resetInstance();
		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 9);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprarTerreno(unterreno);
		
		Assert.assertEquals(80000, player.getDinero() );
	}

	@Test
	public void test04ComprarSantaFeReduceElDineroDelJugadorEn15000() {
		Tablero untablero = Tablero.resetInstance();
		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 11);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprarTerreno(unterreno);
		
		Assert.assertEquals(85000, player.getDinero() );
	}

	@Test
	public void test05ComprarSaltaNorteReduceElDineroDelJugadorEn23000() {
		Tablero untablero = Tablero.resetInstance();
		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 13);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprarTerreno(unterreno);
		
		Assert.assertEquals(77000, player.getDinero() );
	}
	
	@Test
	public void test06ComprarSaltaSurReduceElDineroDelJugadorEn23000() {
		Tablero untablero = Tablero.resetInstance();
		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 14);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprarTerreno(unterreno);
		
		Assert.assertEquals(77000, player.getDinero() );
	}

	@Test
	public void test07ComprarNeuquenReduceElDineroDelJugadorEn17000() {
		Tablero untablero = Tablero.resetInstance();
		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 17);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprarTerreno(unterreno);
		
		Assert.assertEquals(83000, player.getDinero() );
	}
	
	@Test
	public void test08ComprarTucumanReduceElDineroDelJugadorEn25000() {
		Tablero untablero = Tablero.resetInstance();
		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 19);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprarTerreno(unterreno);
		
		Assert.assertEquals(75000, player.getDinero() );
	}
	
	
}

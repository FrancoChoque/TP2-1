package modelo;


import org.junit.Assert;
import org.junit.Test;

import estados.Comprable;

public class TableroTest {
	@Test
	public void test00CrearDosInstanciasDeTableroDevuelveLaMisma() {
		Tablero tablerouno = Tablero.getInstance();
		Tablero tablerodos = Tablero.getInstance();
		
		Assert.assertEquals(tablerodos, tablerouno);
		
	}
	
	@Test
	public void test01asd() {
		Tablero untablero = Tablero.getInstance();
        Jugador player = new Jugador("plauer");


        untablero.agregarJugador(player);

        player.setEstado(player.getJugadorEmpezandoTurno());

        player.setValorDados(6);

        untablero.moverJugador(player,player.getValorDados());

        player.setEstado(player.getJugadorTiroDados());

		Casillero unacasilla = untablero.obtenerCasillero(player);

        Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprarTerreno(unterreno);

        Assert.assertEquals(player, unterreno.preguntarDuenio() );
	}
}

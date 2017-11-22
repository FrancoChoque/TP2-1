package Tests;



import estados.Comprable.Propiedad.Propiedad;
import estados.Comprable.Propiedad.Barrios.*;
import modelo.Jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

import modelo.*;

public class PropiedadTest {

	@Test
	public void test00TerrenoRecienCreadoNoTieneDuenio() {
		Propiedad unterreno = new BuenosAiresNorte();
		
		Assert.assertFalse( unterreno.tieneDuenio() );
	}

	@Test
	public void test01TerrenoSinDuenioSeCompraYCambiaElDuenio() {
		Propiedad unterreno = new BuenosAiresSur();
		Jugador player = new Jugador("player");

		player.setEstado(player.getJugadorEmpezandoTurno());

		player.comprarTerreno(unterreno);
		
		Assert.assertEquals(player, unterreno.getDuenio() );
	}
	
	@Test
	public void test02JugadorCaeEnUnTerrenoSinDuenioYLoCompra() {
		Tablero untablero = Tablero.getInstance();
		Jugador player = new Jugador("plauer");
        player.setEstado(player.getJugadorEmpezandoTurno());
		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 2);

		
		Casillero unacasilla = untablero.obtenerCasillero(player);
		Propiedad unterreno = (Propiedad) unacasilla.getestado();
		
		player.comprarTerreno(unterreno);

		Assert.assertEquals(player, unterreno.getDuenio() );
		
	}
}

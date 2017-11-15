package estados;



import org.junit.Assert;
import org.junit.Test;

import modelo.*;

public class TerrenoTest {

	@Test
	public void test00TerrenoRecienCreadoNoTieneDuenio() {
		Terreno unterreno = new Terreno();
		
		Assert.assertFalse( unterreno.tieneDuenio() );
	}

	@Test
	public void test01TerrenoSinDuenioSeCompraYCambiaElDuenio() {
		Terreno unterreno = new Terreno();
		Jugador player = new Jugador("player");

		player.setEstado(player.getJugadorEmpezandoTurno());

		player.comprarTerreno(unterreno);
		
		Assert.assertEquals(player, unterreno.preguntarDuenio() );
	}
	
	@Test
	public void test02JugadorCaeEnUnTerrenoSinDuenioYLoCompra() {
		Tablero untablero = Tablero.getInstance();
		Jugador player = new Jugador("plauer");
        player.setEstado(player.getJugadorEmpezandoTurno());
		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 2);
		
		Casillero unacasilla = untablero.obtenerCasillero(player);
		Terreno unterreno = (Terreno) unacasilla.getestado();
		
		Assert.assertEquals(player, unterreno.preguntarDuenio() );
		
	}
}

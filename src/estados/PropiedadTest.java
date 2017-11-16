package estados;



import org.junit.Assert;
import org.junit.Test;

import modelo.*;

public class PropiedadTest {

	@Test
	public void test00TerrenoRecienCreadoNoTieneDuenio() {
		Propiedad unterreno = new Propiedad();
		
		Assert.assertFalse( unterreno.tieneDuenio() );
	}

	@Test
	public void test01TerrenoSinDuenioSeCompraYCambiaElDuenio() {
		Propiedad unterreno = new Propiedad();
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
		Propiedad unterreno = (Propiedad) unacasilla.getestado();
		
		Assert.assertEquals(player, unterreno.preguntarDuenio() );
		
	}
}

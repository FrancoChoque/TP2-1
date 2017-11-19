package estados.Comprable.Propiedad;



import estados.Comprable.Propiedad.Barrios.BuenosAiresNorte;
import estados.Comprable.Propiedad.Barrios.BuenosAiresSur;
import modelo.Jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

import modelo.*;

public class PropiedadTest {

	@Test
	public void test00TerrenoRecienCreadoNoTieneDuenio() {

		Tablero untablero = Tablero.resetInstance();

		Propiedad unterreno = new BuenosAiresNorte();
		
		Assert.assertFalse( unterreno.tieneDuenio() );
	}

	@Test
	public void test01TerrenoSinDuenioSeCompraYCambiaElDuenio() {

		Tablero untablero = Tablero.resetInstance();

		Propiedad unterreno = new BuenosAiresSur();
		Jugador player = new Jugador("player");

		player.setEstado(player.getJugadorEmpezandoTurno());

		player.comprarTerreno(unterreno);
		
		Assert.assertEquals(player, unterreno.preguntarDuenio() );
	}
	
	@Test
	public void test02JugadorCaeEnUnTerrenoSinDuenioYLoCompra() {

		Tablero untablero = Tablero.resetInstance();
		Jugador player = new Jugador("plauer");
        player.setEstado(player.getJugadorEmpezandoTurno());
		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 2);


		Casillero unacasilla = untablero.obtenerCasillero(player);
		Propiedad unterreno = (Propiedad) unacasilla.getestado();
		
		player.comprarTerreno(unterreno);

		System.out.println(unterreno.preguntarDuenio().nombre);

		Assert.assertEquals(player, unterreno.preguntarDuenio() );
		
	}
}

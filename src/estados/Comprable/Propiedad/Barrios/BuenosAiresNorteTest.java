package estados.Comprable.Propiedad.Barrios;

import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import org.junit.Assert;
import org.junit.Test;

import excepciones.JugadorNoTieneTerreno;
import excepciones.NoEsTurnoJugador;
import modelo.Casa;
import modelo.Casillero;
import modelo.Edificio;
import modelo.Jugador.Jugador;
import modelo.Tablero;

public class BuenosAiresNorteTest {

	@Test
	public void test00ComprarBuenosAiresNorteReduceElDineroDelJugadorEn25000() {
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


}

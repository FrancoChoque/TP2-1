import modelo.*;
import excepciones.*;
import estados.*;
import org.junit.Assert;
import org.junit.Test;

public class Prueba04Test {

	@Test
	public void test() {
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

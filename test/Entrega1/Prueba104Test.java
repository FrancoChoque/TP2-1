import excepciones.JugadorYaTiroDados;
import excepciones.NoEsTurnoJugador;
import modelo.*;
import estados.*;
import org.junit.Assert;
import org.junit.Test;


public class Prueba104Test {

	@Test
	public void test() {
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

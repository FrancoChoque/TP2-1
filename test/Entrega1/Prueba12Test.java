import org.junit.Test;
import org.junit.Assert;

public class Prueba12Test {

	@Test
	public void test00JugadorCaeEnPoliciaSeEnviaALaCarcelYNoPuedeMoverse() {
		Tablero untablero = new Tablero();
		Jugador unjugador = new Jugador("Player");
		untablero.agregarJugador(unjugador);
		
		untablero.moverJugador(unjugador, 15);		
		
		Assert.assertFalse(unjugador.puedeMoverse() );
	}

}

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Prueba05Test {

	@Test
	public void test() {
		Tablero untablero = new Tablero();
		Jugador unjugador = new Jugador("Player");
		untablero.agregarJugador(unjugador);
		
		untablero.moverJugador(unjugador, 5);
		
		Assert.assertFalse(unjugador.puedeMoverse() );
	}

}

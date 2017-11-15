import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class Prueba05Test {

	@Test
	public void test() {
		Tablero untablero = Tablero.getInstance();
		Jugador unjugador = new Jugador("Player");
		untablero.agregarJugador(unjugador);
		
		untablero.moverJugador(unjugador, 5);
		
		Assert.assertFalse(unjugador.puedeMoverse() );
	}

}

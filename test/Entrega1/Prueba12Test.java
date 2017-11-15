
import org.junit.Test;
import org.junit.Assert;
import modelo.*;
import excepciones.*;

public class Prueba12Test {

	@Test
	public void test00JugadorCaeEnPoliciaSeEnviaALaCarcelYNoPuedeMoverse() {
		Tablero untablero = Tablero.getInstance();
		Jugador unjugador = new Jugador("Player");

		unjugador.setEstado(unjugador.getJugadorEmpezandoTurno());
		untablero.agregarJugador(unjugador);
		
		untablero.moverJugador(unjugador, 15);		
		
		Assert.assertFalse(unjugador.puedeMoverse() );
	}

}

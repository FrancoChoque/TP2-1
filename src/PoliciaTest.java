import org.junit.Assert;
import org.junit.Test;

public class PoliciaTest {

	@Test
	public void test00JugadorCaeEnPoliciaYSeEnviaHastaCarcel() {
		Tablero untablero = new Tablero();
		Jugador unjugador = new Jugador("Player");
		untablero.agregarJugador(unjugador);
		
		untablero.moverJugador(unjugador, 15);		
		
		
		Assert.assertEquals(5 , untablero.obtenerPosicion(unjugador));
	}
	
	@Test
	public void test01JugadorCaeEnPoliciaSeEnviaALaCarcelYNoPuedeMoverse() {
		Tablero untablero = new Tablero();
		Jugador unjugador = new Jugador("Player");
		untablero.agregarJugador(unjugador);
		
		untablero.moverJugador(unjugador, 15);		
		
		Assert.assertFalse(unjugador.puedeMoverse() );
	}

}

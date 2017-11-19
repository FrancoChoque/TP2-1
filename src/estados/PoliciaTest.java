package estados;


import modelo.Jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

import modelo.*;

public class PoliciaTest {

	@Test
	public void test00JugadorCaeEnPoliciaYSeEnviaHastaCarcel() {
		Tablero untablero = Tablero.resetInstance();
		Jugador unjugador = new Jugador("Player");
		untablero.agregarJugador(unjugador);
		
		untablero.moverJugador(unjugador, 15);		
		
		
		Assert.assertEquals(5 , untablero.obtenerPosicion(unjugador));
	}
	
	@Test
	public void test01JugadorCaeEnPoliciaSeEnviaALaCarcelYNoPuedeMoverse() {
		Tablero untablero = Tablero.resetInstance();
		Jugador unjugador = new Jugador("Player");
		untablero.agregarJugador(unjugador);
		
		untablero.moverJugador(unjugador, 15);		
		
		Assert.assertFalse(unjugador.puedeMoverse() );
	}

}

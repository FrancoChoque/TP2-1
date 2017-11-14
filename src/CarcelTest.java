import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CarcelTest {

	@Test
	public void test00JugadorCaeEnCarcelYNoPuedeMoverse() {
		Tablero untablero = new Tablero();
		Jugador unjugador = new Jugador("Player");
		untablero.agregarJugador(unjugador);
		
		untablero.moverJugador(unjugador, 5);
		
		Assert.assertFalse(unjugador.puedeMoverse() );
	}
	
	@Test
	public void test01JugadorEnCarcelGanaUnTurnoEnCalabozo() {
		Tablero untablero = new Tablero();
		Jugador unjugador = new Jugador("Player");
		untablero.agregarJugador(unjugador);
		
		untablero.moverJugador(unjugador, 5);
		
		untablero.moverJugador(unjugador, 1);
		
		Assert.assertEquals(2, untablero.preguntarTurnosEnCalabozo(unjugador) );
	}

	
	@Test
	public void test02JugadorEnCarcelGanaDosTurnoEnCalabozo() {
		Tablero untablero = new Tablero();
		Jugador unjugador = new Jugador("Player");
		untablero.agregarJugador(unjugador);
		
		untablero.moverJugador(unjugador, 5);
		
		untablero.moverJugador(unjugador, 1);
		untablero.moverJugador(unjugador, 1);
		
		Assert.assertEquals(3, untablero.preguntarTurnosEnCalabozo(unjugador) );
	}
}

package Entrega1;


import modelo.Jugador.Jugador;
import modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;


public class Prueba105Test {

	@Test
	public void test() {
		Tablero untablero = Tablero.resetInstance();
		Jugador unjugador = new Jugador("Player");
		untablero.agregarJugador(unjugador);
		
		untablero.moverJugador(unjugador, 5);
		
		Assert.assertFalse(unjugador.puedeMoverse() );
	}

}

import org.junit.Assert;

import org.junit.Test;

import excepciones.TurnosEnCalabozoInvalidoException;

public class Prueba06Test {

	@Test
	public void test00JugadorConUnTurnoEnCalabozoNoPuedePagarFianza() {
		Tablero untablero = Tablero.getInstance();
		Jugador unjugador = new Jugador("Player");
		untablero.agregarJugador(unjugador);
		untablero.moverJugador(unjugador, 5);
		
		Carcel unacarcel = (Carcel) untablero.obtenerCasillero(unjugador).getestado();
		
		try {
			unacarcel.pagarFianza(unjugador);
			Assert.assertTrue(false);
		}
		catch(TurnosEnCalabozoInvalidoException error){
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void test01JugadorConDosTurnosEnCalabozoPagaFianzaYPuedeMoverse() {
		Tablero untablero = Tablero.getInstance();
		Jugador unjugador = new Jugador("Player");
		untablero.agregarJugador(unjugador);
		untablero.moverJugador(unjugador, 5);
		untablero.moverJugador(unjugador, 1);
		
		Carcel unacarcel = (Carcel) untablero.obtenerCasillero(unjugador).getestado();
		unacarcel.pagarFianza(unjugador);
		
		Assert.assertTrue(unjugador.puedeMoverse() );
		
	}
	
	@Test
	public void test02JugadorConTresTurnosEnCalabozoPagaFianzaYPuedeMoverse() {
		Tablero untablero = Tablero.getInstance();
		Jugador unjugador = new Jugador("Player");
		untablero.agregarJugador(unjugador);
		untablero.moverJugador(unjugador, 5);
		untablero.moverJugador(unjugador, 1);
		untablero.moverJugador(unjugador, 1);
		
		Carcel unacarcel = (Carcel) untablero.obtenerCasillero(unjugador).getestado();
		unacarcel.pagarFianza(unjugador);
		
		Assert.assertTrue(unjugador.puedeMoverse() );
		
	}

	@Test
	public void test03JugadorConCuatroTurnosEnCalabozoNoPuedePagarFianza() {
		Tablero untablero = Tablero.getInstance();
		Jugador unjugador = new Jugador("Player");
		untablero.agregarJugador(unjugador);
		untablero.moverJugador(unjugador, 5);
		untablero.moverJugador(unjugador, 1);
		untablero.moverJugador(unjugador, 1);
		untablero.moverJugador(unjugador, 1);
		
		Carcel unacarcel = (Carcel) untablero.obtenerCasillero(unjugador).getestado();
		
		try {
			unacarcel.pagarFianza(unjugador);
			Assert.assertEquals(55000, null );
		}
		catch(TurnosEnCalabozoInvalidoException error){
			Assert.assertTrue(true);
		}
	}
}

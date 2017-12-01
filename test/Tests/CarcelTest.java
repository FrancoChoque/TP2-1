package Tests;

import modelo.Jugador.Jugador;


import org.junit.Assert;
import org.junit.Test;

import excepciones.DineroInsuficiente;
import excepciones.TurnosEnCalabozoInvalidoException;
import modelo.Tablero;

import estados.Carcel;


public class CarcelTest {

	@Test
	public void test00JugadorCaeEnCarcelYNoPuedeMoverse() {
		Tablero untablero = Tablero.getInstance();
		Jugador unjugador = new Jugador("Player");
		untablero.agregarJugador(unjugador);

		untablero.moverJugador(unjugador, 5);



		Assert.assertFalse(unjugador.puedeMoverse() );
	}
	
	@Test
	public void test01JugadorEnCarcelGanaUnTurnoEnCalabozo() {
		Tablero untablero = Tablero.getInstance();
		Jugador unjugador = new Jugador("Player");
		untablero.agregarJugador(unjugador);
		
		untablero.moverJugador(unjugador, 5);
		
		untablero.moverJugador(unjugador, 1);
		
		Assert.assertEquals(2, untablero.preguntarTurnosEnCalabozo(unjugador) );
	}

	
	@Test
	public void test02JugadorEnCarcelGanaDosTurnoEnCalabozo() {
		Tablero untablero = Tablero.getInstance();
		Jugador unjugador = new Jugador("Player");
		untablero.agregarJugador(unjugador);
		
		untablero.moverJugador(unjugador, 5);
		
		untablero.moverJugador(unjugador, 1);
		untablero.moverJugador(unjugador, 1);
		
		Assert.assertEquals(3, untablero.preguntarTurnosEnCalabozo(unjugador) );
	}
	
	@Test
	public void test03JugadorConUnTurnoEnCalabozoNoPuedePagarFianza() {
		Tablero untablero = Tablero.getInstance();
		Jugador unjugador = new Jugador("Player");
		untablero.agregarJugador(unjugador);
		untablero.moverJugador(unjugador, 5);
		
		Carcel unacarcel = untablero.getCarcel();
		
		try {
			unacarcel.cobrarFianza(unjugador);
			Assert.assertTrue(false);
		}
		catch(TurnosEnCalabozoInvalidoException error){
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void test04JugadorConDosTurnosEnCalabozoPuedePagarFianza() {
		Tablero untablero = Tablero.getInstance();
		Jugador unjugador = new Jugador("Player");
		untablero.agregarJugador(unjugador);
		untablero.moverJugador(unjugador, 5);
		untablero.moverJugador(unjugador, 1);
		
		Carcel unacarcel = (Carcel) untablero.obtenerCasillero(unjugador).getestado();
		
		try {
			unacarcel.cobrarFianza(unjugador);
			Assert.assertEquals(55000, unjugador.getDinero() );
		}
		catch(TurnosEnCalabozoInvalidoException error){
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void test05JugadorConTresTurnosEnCalabozoPuedePagarFianza() {
		Tablero untablero = Tablero.getInstance();
		Jugador unjugador = new Jugador("Player");
		untablero.agregarJugador(unjugador);
		untablero.moverJugador(unjugador, 5);
		untablero.moverJugador(unjugador, 1);
		untablero.moverJugador(unjugador, 1);
		
		Carcel unacarcel = (Carcel) untablero.obtenerCasillero(unjugador).getestado();
		
		try {
			unacarcel.cobrarFianza(unjugador);
			Assert.assertEquals(55000, unjugador.getDinero() );
		}
		catch(TurnosEnCalabozoInvalidoException error){
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void test06JugadorConCuatroTurnosEnCalabozoNoPuedePagarFianza() {
		Tablero untablero = Tablero.getInstance();
		Jugador unjugador = new Jugador("Player");
		untablero.agregarJugador(unjugador);
		untablero.moverJugador(unjugador, 5);
		untablero.moverJugador(unjugador, 1);
		untablero.moverJugador(unjugador, 1);
		untablero.moverJugador(unjugador, 1);
		
		Carcel unacarcel = (Carcel) untablero.obtenerCasillero(unjugador).getestado();
		
		try {
			unacarcel.cobrarFianza(unjugador);

		}
		catch(TurnosEnCalabozoInvalidoException error){
			Assert.assertTrue(true);
		}
	}
	
	@Test
	public void test07JugadorConTresTurnosEnCalabozoNoTieneDineroSuficienteParaFianza() {
		Tablero untablero = Tablero.getInstance();
		Jugador unjugador = new Jugador("Player");
		unjugador.sumarDinero(-55001);
		
		untablero.agregarJugador(unjugador);
		untablero.moverJugador(unjugador, 5);
		untablero.moverJugador(unjugador, 1);
		untablero.moverJugador(unjugador, 1);
		
		Carcel unacarcel = (Carcel) untablero.obtenerCasillero(unjugador).getestado();
		
		try {
			unacarcel.cobrarFianza(unjugador);
			Assert.assertEquals(null, unjugador.getDinero() );
		}
		catch(DineroInsuficiente error){
			Assert.assertTrue(true);
		}
	}


	@Test
	public void test00JugadorConCuatroTurnosEnCalabozoPuedeMoverse() {
		Tablero untablero = Tablero.getInstance();
		Jugador unjugador = new Jugador("Player");
		untablero.agregarJugador(unjugador);

		untablero.moverJugador(unjugador, 5);
		untablero.moverJugador(unjugador, 1);
		untablero.moverJugador(unjugador, 1);
		untablero.moverJugador(unjugador, 1);


		Assert.assertTrue(unjugador.puedeMoverse());
	}
	
}

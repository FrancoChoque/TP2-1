package Entrega1;

import estados.Carcel;
import modelo.*;

import modelo.Jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

import excepciones.DineroInsuficiente;

public class Prueba107Test {

	@Test
	public void test00JugadorNoTieneDineroSuficienteYNoPuedeMoverse() {
		Tablero untablero = Tablero.resetInstance();
		Jugador unjugador = new Jugador("Player");
		unjugador.sumarDinero(-55001);
		
		untablero.agregarJugador(unjugador);
		untablero.moverJugador(unjugador, 5);
		Tablero.getInstance().obtenerCasillero(unjugador).getestado().hacerEfectoDelCasillero(unjugador);
		

		Tablero.getInstance().obtenerCasillero(unjugador).getestado().hacerEfectoDelCasillero(unjugador);
		

		Tablero.getInstance().obtenerCasillero(unjugador).getestado().hacerEfectoDelCasillero(unjugador);
		
		
		Carcel unacarcel = untablero.getCarcel();
		
		try {
			unacarcel.cobrarFianza(unjugador);
			Assert.assertEquals(null, unjugador.getDinero() );
		}
		catch(DineroInsuficiente error){
			Assert.assertFalse(unjugador.puedeMoverse() );
		}
	}

	@Test
	public void test01JugadorNoTieneDineroSuficienteParaFianzaYNoPuedeMoverse() {
		Tablero untablero = Tablero.resetInstance();
		Jugador unjugador = new Jugador("Player");
		unjugador.sumarDinero(-55001);
		
		unjugador.setEstado(unjugador.getJugadorEmpezandoTurno());

		untablero.agregarJugador(unjugador);
		untablero.moverJugador(unjugador, 5);


		Tablero.getInstance().obtenerCasillero(unjugador).getestado().hacerEfectoDelCasillero(unjugador);
		
		Tablero.getInstance().obtenerCasillero(unjugador).getestado().hacerEfectoDelCasillero(unjugador);

		Tablero.getInstance().obtenerCasillero(unjugador).getestado().hacerEfectoDelCasillero(unjugador);
		Carcel unacarcel = untablero.getCarcel();
		
		try {
			unacarcel.cobrarFianza(unjugador);
			Assert.assertEquals(null, unjugador.getDinero() );
		}
		catch(DineroInsuficiente error){
			Assert.assertFalse(unjugador.puedeMoverse() );
		}
	}
}

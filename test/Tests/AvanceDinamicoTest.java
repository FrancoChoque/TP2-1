package Tests;

import org.junit.Assert;
import org.junit.Test;
import modelo.Tablero;
import modelo.Jugador.Jugador;

public class AvanceDinamicoTest {

	@Test
	public void jugadorCaeEnAvanceDinamicoYConDados5PosicionJugador10Test(){
		Tablero tablero = Tablero.getInstance();
		tablero.resetearTablero();
		Jugador jugador = new Jugador("jugador1");
		tablero.agregarJugador(jugador);
		jugador.setEstado(jugador.getJugadorEmpezandoTurno());
		
		jugador.setValorDados(5);
		tablero.moverJugador(jugador, 7);
		
		tablero.obtenerCasillero(jugador).getestado().hacerEfectoDelCasillero(jugador);
		
		Assert.assertEquals(10,tablero.obtenerPosicion(jugador));
	}
	
	@Test
	public void jugadorCaeEnAvanceDinamicoYConUnaPropiedadDados5PosicionJugador10Test() throws Exception{
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new Jugador("jugador1");
		jugador.setEstado(jugador.getJugadorEmpezandoTurno());
		jugador.comprar(tablero.getSaltaNorte());
		tablero.agregarJugador(jugador);
		
		jugador.setValorDados(5);
		tablero.moverJugador(jugador, 7);
		
		tablero.obtenerCasillero(jugador).getestado().hacerEfectoDelCasillero(jugador);
		
		Assert.assertEquals(10,tablero.obtenerPosicion(jugador));
	}
	
	@Test
	public void jugadorCaeEnAvanceDinamicoYDados7DineroDe10PosicionJugador10Test(){
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new Jugador("jugador1");
		jugador.setDinero(10);
		tablero.agregarJugador(jugador);
		
		jugador.setValorDados(7);
		tablero.moverJugador(jugador, 7);
		
		tablero.obtenerCasillero(jugador).getestado().hacerEfectoDelCasillero(jugador);
		
		Assert.assertEquals(10,tablero.obtenerPosicion(jugador));
	}
	
	@Test
	public void jugadorCaeEnAvanceDinamicoYDados7yConUnaPropiedadDineroDe10PosicionJugador10Test()throws Exception {
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new Jugador("jugador1");
		jugador.setDinero(10);

		jugador.setEstado(jugador.getJugadorEmpezandoTurno());
		jugador.comprar(tablero.getSaltaNorte());
		tablero.agregarJugador(jugador);
		
		jugador.setValorDados(7);
		tablero.moverJugador(jugador, 7);
		
		tablero.obtenerCasillero(jugador).getestado().hacerEfectoDelCasillero(jugador);
		
		Assert.assertEquals(10,tablero.obtenerPosicion(jugador));
	}
	
	@Test
	public void jugadorCaeEnAvanceDinamicoConDados11yCon5PropiedadPosicionJugador13Test() throws Exception{
		Tablero tablero = Tablero.getInstance();
		Jugador jugador = new Jugador("jugador1");
        jugador.setEstado(jugador.getJugadorEmpezandoTurno());

		tablero.agregarJugador(jugador);

		tablero.agregarJugador(jugador);

		jugador.setEstado(jugador.getJugadorEmpezandoTurno());

		jugador.comprar(tablero.getBuenosAiresSur());
		jugador.comprar(tablero.getBuenosAiresNorte());

		jugador.setDinero(100000);

		jugador.comprar(tablero.getSaltaSur());
		jugador.comprar(tablero.getSaltaNorte());
		jugador.comprar(tablero.getNeuquen());

		jugador.setValorDados(11);
		tablero.moverJugador(jugador, 7);
		
		tablero.obtenerCasillero(jugador).getestado().hacerEfectoDelCasillero(jugador);
		
		Assert.assertEquals(13,tablero.obtenerPosicion(jugador));
	}
	
}
package Entrega1;

import modelo.*;
import modelo.Jugador.Jugador;
import org.junit.Assert;
import org.junit.Test;

public class Prueba110Test {

	@Test
	public void jugadorCaeEnAvanceDinamicoConDados11yCon5PropiedadPosicionJugador13Test() throws Exception{
		Tablero tablero = Tablero.resetInstance();
		Jugador jugador = new Jugador("jugador1");

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
		Tablero.getInstance().obtenerCasillero(jugador).getestado().hacerEfectoDelCasillero(jugador);
		
		
		Assert.assertEquals(13,tablero.obtenerPosicion(jugador));
	}
}

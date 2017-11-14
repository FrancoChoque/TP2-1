import org.junit.Assert;
import org.junit.Test;

public class PruebasPedidasTest {

	//prueba 1
	@Test
	public void jugadorCaeEnQuiniPorPrimeraVezCapitalIncrementarEn50000Test(){
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador("jugador1");
		tablero.agregarJugador(jugador);
		jugador.comenzarTurno();
		tablero.moverJugador(jugador, 1);
		
		Assert.assertEquals(150000,jugador.getDinero());
	}
	
	//prueba 2
	@Test
	public void jugadorCaeEnQuiniPorSegundaVezSumarIncrementarSuCapitalTest(){
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador("jugador1");
		tablero.agregarJugador(jugador);
		jugador.comenzarTurno();
		tablero.moverJugador(jugador, 1);
		jugador.comenzarTurno();
		tablero.moverJugador(jugador, 20);
		
		Assert.assertEquals(180000,jugador.getDinero());
	}
	
	//prueba 3
	@Test
	public void jugadorCaeEnQuiniPorTerceraVezNoIncrementarSuCapitalTest(){
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador("jugador1");
		tablero.agregarJugador(jugador);
		jugador.comenzarTurno();
		tablero.moverJugador(jugador, 1);
		jugador.comenzarTurno();
		tablero.moverJugador(jugador, 20);
		jugador.comenzarTurno();
		tablero.moverJugador(jugador, 20);
		
		Assert.assertEquals(180000,jugador.getDinero());
	}
}

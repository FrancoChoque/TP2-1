import org.junit.Assert;
import org.junit.Test;

public class Quini6Test {

	@Test
	public void QuiniNoNuloTest(){
		Quini6 quini6 = new Quini6();
	    Assert.assertNotNull(quini6);
	}
	
	
	@Test
	public void jugadorCalloCeroVecesEnQuiniTest(){
		Quini6 quini6 = new Quini6();
		Jugador jugador = new Jugador("jugador1");
		quini6.agregarJugador(jugador);
		Assert.assertEquals(0,quini6.cantidadDevecesQueCalloJugador(jugador));
	}
	
	@Test
	public void jugadorCalloEnQuiniPorPrimeraVezSumar50000AlInicialTotalDe150000Test(){
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador("jugador1");
		tablero.agregarJugador(jugador);
		tablero.moverJugador(jugador, 1);
		
		Assert.assertEquals(150000,jugador.getDinero());
	}
	
	@Test
	public void jugadorCalloEnQuiniPorSegundaVezSumarAlInicialTotalDe180000Test(){
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador("jugador1");
		tablero.agregarJugador(jugador);
		
		tablero.moverJugador(jugador, 1);
		
		tablero.moverJugador(jugador, 20);
		
		Assert.assertEquals(180000,jugador.getDinero());
	}
	
	@Test
	public void jugadorCalloEnQuiniPorTerceraVezNoSumarMasDe180000Test(){
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador("jugador1");
		tablero.agregarJugador(jugador);
		
		tablero.moverJugador(jugador, 1);
		
		tablero.moverJugador(jugador, 20);
		
		tablero.moverJugador(jugador, 20);
		
		Assert.assertEquals(180000,jugador.getDinero());
	}
}

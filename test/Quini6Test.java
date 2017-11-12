import org.junit.Assert;
import org.junit.Test;

public class Quini6Test {

	@Test
	public void QuiniNoNuloTest(){
		Quini6 quini6 = new Quini6();
	    Assert.assertNotNull(quini6);
	}
	
	
	@Test
	public void jugadorCalloCeroVecesEnQuini(){
		Quini6 quini6 = new Quini6();
		Jugador jugador = new Jugador("jugador1");
		quini6.agregarJugador(jugador);
		Assert.assertEquals(0,quini6.cantidadDevecesQueCalloJugador(jugador));
	}
	
	@Test
	public void jugadorCalloEnQuiniPorPrimeraVezSumar50000AlInicialTotalDe150000(){
		Tablero tablero = new Tablero();
		Jugador jugador = new Jugador("jugador1");
		tablero.agregarJugador(jugador);
		tablero.moverJugador(jugador, 1);
		
		Assert.assertEquals(150000,jugador.getDinero());
	}
}

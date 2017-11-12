import org.junit.Assert;
import org.junit.Test;


public class JugadorTest {

	@Test
	public void jugadorDistintoDeNuloTest(){
	     Jugador jugador = new Jugador("jugador1");
	     Assert.assertNotNull(jugador);
	}
	
	@Test
	public void jugadorDineroInicial100000Test(){
	     Jugador jugador = new Jugador("jugador1");
	     Assert.assertEquals(100000, jugador.getDinero());
	}
	
	@Test
	public void jugadorSumar20000ADineroInicial(){
	     Jugador jugador = new Jugador("jugador1");
	     jugador.sumarDinero(20000);
	     Assert.assertEquals(120000, jugador.getDinero());
	}
}

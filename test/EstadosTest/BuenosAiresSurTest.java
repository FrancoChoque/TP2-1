import modelo.Jugador.Jugador;
import org.junit.Assert;

import org.junit.Test;

import excepciones.JugadorNoTieneTerreno;
import excepciones.NoEsTurnoJugador;
import modelo.*;
import estados.*;


public class BuenosAiresSurTest {

	@Test
	public void test00ComprarBuenosAiresSurReduceElDineroDelJugadorEn20000() {
		Tablero untablero = Tablero.resetInstance();
		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 2);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprarTerreno(unterreno);
		
		Assert.assertEquals(80000, player.getDinero() );
	}

	
	@Test
	public void test01JugadorCaeEnBuenosairesSurConUnaCasaYPaga3000(){

	        Tablero untablero = Tablero.resetInstance();
	        Jugador player = new Jugador("plauer");
	        player.setEstado(player.getJugadorEmpezandoTurno());
	        untablero.agregarJugador(player);

	        untablero.moverJugador(player, 2);
	        Casillero unacasilla = untablero.obtenerCasillero(player);
	        Comprable unterreno = (Comprable) unacasilla.getestado();
	        player.comprarTerreno(unterreno);


	        untablero.moverJugador(player, 2);
	        Casillero otraCasilla = untablero.obtenerCasillero(player);
	        Comprable otroTerreno = (Comprable) otraCasilla.getestado();
	        player.comprarTerreno(otroTerreno);

	        Assert.assertEquals(55000, player.getDinero() );

	        try {
	            player.edificar((Propiedad) unterreno, (Edificio) new Casa());
	        }catch (NoEsTurnoJugador noEsTurnoJugador){

	        }catch (JugadorNoTieneTerreno jugadorNoTieneTerreno){

	        }

	        Assert.assertEquals(50000, player.getDinero() );
	        
	        Jugador jugador = new Jugador("Wilson");
	        jugador.setEstado(jugador.getJugadorEmpezandoTurno() );
	        untablero.agregarJugador(jugador);
	        untablero.moverJugador(jugador, 2);
	        
	        Assert.assertEquals(97000, jugador.getDinero());

	    }
	
}
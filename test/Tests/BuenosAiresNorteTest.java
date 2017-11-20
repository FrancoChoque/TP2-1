package Tests;

import estados.Comprable.Comprable;
import estados.Comprable.Propiedad.Propiedad;
import org.junit.Assert;
import org.junit.Test;

import modelo.Casillero;
import modelo.Tablero;
import modelo.Jugador.Jugador;

public class BuenosAiresNorteTest {

	@Test
	public void test00ComprarBuenosAiresNorteReduceElDineroDelJugadorEn25000() {

		Tablero untablero = Tablero.getInstance();
		untablero.resetearTablero();

		Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

		untablero.agregarJugador(player);
		
		untablero.moverJugador(player, 4);

		Casillero unacasilla = untablero.obtenerCasillero(player);
		Comprable unterreno = (Comprable) unacasilla.getestado();

		player.comprarTerreno(unterreno);
		
		Assert.assertEquals(75000, player.getDinero() );
	}

	@Test
	public void test01JugadorCaeEnBuenosairesNorteConUnaCasaYPaga3500(){

	        Tablero untablero = Tablero.getInstance();
	        untablero.resetearTablero();

	        Jugador player = new Jugador("plauer");
	        player.setEstado(player.getJugadorEmpezandoTurno());
	        untablero.agregarJugador(player);

	        untablero.moverJugador(player, 2);
	        Casillero unacasilla = untablero.obtenerCasillero(player);
	        Comprable unterreno = (Comprable) unacasilla.getestado();
	        player.comprarTerreno(unterreno);


	        untablero.moverJugador(player, 2);
	        Casillero otraCasilla = untablero.obtenerCasillero(player);
	        Propiedad otroTerreno = (Propiedad) otraCasilla.getestado();
	        player.comprarTerreno(otroTerreno);

	        Assert.assertEquals(55000, player.getDinero() );

			player.construirCasa(otroTerreno);

	        Assert.assertEquals(49500, player.getDinero() );

	        Jugador jugador = new Jugador("Wilson");
	        jugador.setEstado(jugador.getJugadorEmpezandoTurno() );
	        untablero.agregarJugador(jugador);
	        untablero.moverJugador(jugador, 4);
	        
	        Assert.assertEquals(96500, jugador.getDinero());

	    }
	
	@Test

    public void test02ConstruirDosCasasEnBuenosAiresNorteReduceDineroEn11000(){

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");
		untablero.resetearTablero();
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

        player.construirCasa((Propiedad) otroTerreno);

		player.construirCasa((Propiedad) otroTerreno);

        Assert.assertEquals(44000, player.getDinero() );

    }
}

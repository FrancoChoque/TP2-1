package estados;

import org.junit.Assert;
import org.junit.Test;

import excepciones.JugadorNoTieneTerreno;
import excepciones.NoEsTurnoJugador;
import modelo.Casa;
import modelo.Casillero;
import modelo.Edificio;
import modelo.Jugador.Jugador;
import modelo.Tablero;

public class BuenosAiresNorteTest {

	@Test
	public void test00ComprarBuenosAiresNorteReduceElDineroDelJugadorEn25000() {
		Tablero untablero = Tablero.resetInstance();
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
	            player.edificar((Propiedad) otroTerreno, (Edificio) new Casa());
	        }catch (NoEsTurnoJugador noEsTurnoJugador){

	        }catch (JugadorNoTieneTerreno jugadorNoTieneTerreno){

	        }

	        Assert.assertEquals(49500, player.getDinero() );
	        
	        Jugador jugador = new Jugador("Wilson");
	        jugador.setEstado(jugador.getJugadorEmpezandoTurno() );
	        untablero.agregarJugador(jugador);
	        untablero.moverJugador(jugador, 4);
	        
	        Assert.assertEquals(96500, jugador.getDinero());

	    }
	
	@Test

    public void test02ConstruirDosCasasEnBuenosAiresNorteReduceDineroEn11000(){

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
            player.edificar((Propiedad) otroTerreno, (Edificio) new Casa());
            player.edificar((Propiedad) otroTerreno, (Edificio) new Casa());
        }catch (NoEsTurnoJugador noEsTurnoJugador){

        }catch (JugadorNoTieneTerreno jugadorNoTieneTerreno){

        }

        Assert.assertEquals(44000, player.getDinero() );

    }





}

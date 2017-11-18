package Entrega2;

import estados.Comprable;
import estados.Propiedad;
import excepciones.JugadorNoTieneTerreno;
import excepciones.NoEsTurnoJugador;
import modelo.Casillero;
import modelo.Casa;
import modelo.Edificio;
import modelo.Jugador.Jugador;
import modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class Prueba202Test {

    @Test

    public void construirCasaEnBuenosAiresNorteReduceDineroEn5500(){

        Tablero untablero = Tablero.getInstance();
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

    }

}
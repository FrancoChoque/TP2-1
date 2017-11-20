package Entrega2;

import modelo.Jugador.Jugador;
import modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class Prueba208Test {

    @Test
    public void test01JugadorCaeEnCordobaConHotel(){

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("Player");
        player.setEstado(player.getJugadorEmpezandoTurno());
        untablero.agregarJugador(player);

        player.comprarTerreno(untablero.getCordobaNorte());

        player.comprarTerreno(untablero.getCordobaSur());

        player.construirCasa(untablero.getCordobaSur());
        player.construirCasa(untablero.getCordobaSur());
        player.construirCasa(untablero.getCordobaNorte());
        player.construirCasa(untablero.getCordobaNorte());

        player.construirHotel(untablero.getCordobaSur());
        player.construirHotel(untablero.getCordobaNorte());

        Jugador player2 = new Jugador("Player2");
        player.setEstado(player.getJugadorEmpezandoTurno());
        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,6);

        Assert.assertEquals(97000, player2.getDinero());

        untablero.moverJugador(player2,3);

        Assert.assertEquals(93500, player2.getDinero());

    }


    @Test
    public void test02JugadorCaeEnSaltaConHotel(){

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("Player");
        player.setEstado(player.getJugadorEmpezandoTurno());
        untablero.agregarJugador(player);

        player.comprarTerreno(untablero.getSaltaNorte());

        player.comprarTerreno(untablero.getSaltaSur());

        player.construirCasa(untablero.getSaltaSur());
        player.construirCasa(untablero.getSaltaSur());
        player.construirCasa(untablero.getSaltaNorte());
        player.construirCasa(untablero.getSaltaNorte());

        player.construirHotel(untablero.getSaltaSur());
        player.construirHotel(untablero.getSaltaNorte());

        Jugador player2 = new Jugador("Player2");
        player.setEstado(player.getJugadorEmpezandoTurno());
        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,13);

        Assert.assertEquals(94500, player2.getDinero());

        untablero.moverJugador(player2,1);

        Assert.assertEquals(89000, player2.getDinero());

    }

}

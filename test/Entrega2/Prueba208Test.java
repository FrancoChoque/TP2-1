package Entrega2;

import modelo.Jugador.Jugador;
import modelo.Casa;
import modelo.Hotel;
import modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class Prueba208Test {

    @Test
    public void test01JugadorCaeEnCordobaConHotel() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("Player");
        player.setEstado(player.getJugadorEmpezandoTurno());
        untablero.agregarJugador(player);

        player.comprar(untablero.getCordobaNorte());

        player.comprar(untablero.getCordobaSur());

        player.construir(untablero.getCordobaSur(), new Casa());
        player.construir(untablero.getCordobaSur(), new Casa());
        player.construir(untablero.getCordobaNorte(), new Casa());
        player.construir(untablero.getCordobaNorte(), new Casa());

        player.construir(untablero.getCordobaSur(), new Hotel());
        player.construir(untablero.getCordobaNorte(), new Hotel());

        Jugador player2 = new Jugador("Player2");
        player.setEstado(player.getJugadorEmpezandoTurno());
        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,6);

        Assert.assertEquals(97000, player2.getDinero());

        untablero.moverJugador(player2,3);

        Assert.assertEquals(93500, player2.getDinero());

    }


    @Test
    public void test02JugadorCaeEnSaltaConHotel() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("Player");
        player.setEstado(player.getJugadorEmpezandoTurno());
        untablero.agregarJugador(player);

        player.comprar(untablero.getSaltaNorte());

        player.comprar(untablero.getSaltaSur());

        player.construir(untablero.getSaltaSur(), new Casa());
        player.construir(untablero.getSaltaSur(), new Casa());
        player.construir(untablero.getSaltaNorte(), new Casa());
        player.construir(untablero.getSaltaNorte(), new Casa());

        player.construir(untablero.getSaltaSur(), new Hotel());
        player.construir(untablero.getSaltaNorte(), new Hotel());

        Jugador player2 = new Jugador("Player2");
        player.setEstado(player.getJugadorEmpezandoTurno());
        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,13);

        Assert.assertEquals(94500, player2.getDinero());

        untablero.moverJugador(player2,1);

        Assert.assertEquals(89000, player2.getDinero());

    }

}

package Entrega2;

import modelo.Jugador.Jugador;
import modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class Prueba208 {

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

        Jugador player2 = new Jugador("Player2");
        player.setEstado(player.getJugadorEmpezandoTurno());
        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,6);

        Assert.assertEquals(97000, player2.getDinero());


    }

}

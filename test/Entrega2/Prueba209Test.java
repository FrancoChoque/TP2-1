package Entrega2;

import modelo.Jugador.Jugador;
import modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class Prueba209Test {


    @Test
    public void test01JugadorCompraCasaEnSantaFe(){
        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("Player");
        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprarTerreno(untablero.getSantaFe());

        Assert.assertEquals(85000, player.getDinero());

        player.construirCasa(untablero.getSantaFe());

        Assert.assertEquals(81000, player.getDinero());
    }
}

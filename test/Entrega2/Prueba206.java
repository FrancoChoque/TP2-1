package Entrega2;


import org.junit.Assert;
import org.junit.Test;

import modelo.Tablero;
import modelo.Jugador.Jugador;


public class Prueba206 {

    @Test
    public void test01JugadorConstruyeHotelYPagaElValor() {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("Player");
        player.setEstado(player.getJugadorEmpezandoTurno());
        untablero.agregarJugador(player);

        player.comprarTerreno(untablero.getBuenosAiresNorte());

        player.comprarTerreno(untablero.getBuenosAiresSur());

        player.construirCasa(untablero.getBuenosAiresSur());

        player.construirCasa(untablero.getBuenosAiresSur());

        player.construirCasa(untablero.getBuenosAiresNorte());

        player.construirCasa(untablero.getBuenosAiresNorte());

        Assert.assertEquals(34000, player.getDinero());

        player.construirHotel(untablero.getBuenosAiresSur());

        Assert.assertEquals(26000, player.getDinero());

        player.construirHotel(untablero.getBuenosAiresNorte());

        Assert.assertEquals(17000, player.getDinero());


    }
}
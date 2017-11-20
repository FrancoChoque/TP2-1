package Entrega2;


import org.junit.Assert;
import org.junit.Test;

import modelo.Tablero;
import modelo.Jugador.Jugador;


public class Prueba205 {

    @Test
    public void test01JugadorConstruyeHotelSinTenerCasas(){

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("Player");
        player.setEstado(player.getJugadorEmpezandoTurno());
        untablero.agregarJugador(player);

        player.comprarTerreno(untablero.getBuenosAiresNorte());

        player.comprarTerreno(untablero.getBuenosAiresSur());

        Assert.assertEquals(55000, player.getDinero());

        player.construirHotel(untablero.getBuenosAiresSur());

        Assert.assertEquals(55000, player.getDinero());


    }

    @Test
    public void test02JugadorConstruyeHotelConTresCasas(){

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

        Assert.assertEquals(39500, player.getDinero());

        player.construirHotel(untablero.getBuenosAiresSur());

        Assert.assertEquals(39500, player.getDinero());


    }
}

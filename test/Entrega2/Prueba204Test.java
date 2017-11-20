package Entrega2;


import org.junit.Assert;
import org.junit.Test;

import modelo.Tablero;
import modelo.Jugador.Jugador;

public class Prueba204Test {

    @Test
    public void test01JugadorCaeEnBuenosAiresSurConDosCasasYPaga3500(){

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");
        player.setEstado(player.getJugadorEmpezandoTurno());
        untablero.agregarJugador(player);

        player.comprarTerreno(untablero.getBuenosAiresNorte());

        player.comprarTerreno(untablero.getBuenosAiresSur());

        player.construirCasa(untablero.getBuenosAiresSur());

        player.construirCasa(untablero.getBuenosAiresSur());

        Jugador jugador = new Jugador("Wilson");
        jugador.setEstado(jugador.getJugadorEmpezandoTurno() );
        untablero.agregarJugador(jugador);
        untablero.moverJugador(jugador, 2);

        Assert.assertEquals(96500, jugador.getDinero());


    }

    @Test
    public void test02JugadorCaeEnBuenosAiresNorteConCasaYPaga3500(){

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");
        player.setEstado(player.getJugadorEmpezandoTurno());
        untablero.agregarJugador(player);

        player.comprarTerreno(untablero.getBuenosAiresNorte());

        player.comprarTerreno(untablero.getBuenosAiresSur());

        player.construirCasa(untablero.getBuenosAiresNorte());

        Jugador jugador = new Jugador("Wilson");
        jugador.setEstado(jugador.getJugadorEmpezandoTurno() );
        untablero.agregarJugador(jugador);
        untablero.moverJugador(jugador, 4);

        Assert.assertEquals(96500, jugador.getDinero());


    }
}
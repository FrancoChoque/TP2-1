package Entrega2;


import org.junit.Assert;
import org.junit.Test;

import modelo.Tablero;
import modelo.Jugador.Jugador;




public class Prueba207 {


    @Test
    public void test01JugadorCaeEnBuenosAiresSurConHotelYPaga5000(){

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

        player.construirHotel(untablero.getBuenosAiresSur());

        Jugador player2 = new Jugador("Player2");
        player.setEstado(player.getJugadorEmpezandoTurno());
        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,2);

        Assert.assertEquals(95000, player2.getDinero());
    }

    @Test
    public void test01JugadorCaeEnBuenosAiresNorteConHotelYPaga6000(){

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

        player.construirHotel(untablero.getBuenosAiresNorte());

        Jugador player2 = new Jugador("Player2");
        player.setEstado(player.getJugadorEmpezandoTurno());
        untablero.agregarJugador(player2);

        untablero.moverJugador(player2,4);

        Assert.assertEquals(94000, player2.getDinero());
    }

}

package Entrega2;


import org.junit.Assert;
import org.junit.Test;

import modelo.Casa;
import modelo.Hotel;
import modelo.Tablero;
import modelo.Jugador.Jugador;


public class Prueba206Test {

    @Test
    public void test01JugadorConstruyeHotelYPagaElValor() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("Player");
        player.setEstado(player.getJugadorEmpezandoTurno());
        untablero.agregarJugador(player);

        player.comprar(untablero.getBuenosAiresNorte());

        player.comprar(untablero.getBuenosAiresSur());

        player.construir(untablero.getBuenosAiresSur(), new Casa());

        player.construir(untablero.getBuenosAiresSur(), new Casa());

        player.construir(untablero.getBuenosAiresNorte(), new Casa());

        player.construir(untablero.getBuenosAiresNorte(), new Casa());

        Assert.assertEquals(34000, player.getDinero());

        player.construir(untablero.getBuenosAiresSur(), new Hotel());

        Assert.assertEquals(26000, player.getDinero());

        player.construir(untablero.getBuenosAiresNorte(), new Hotel());

        Assert.assertEquals(17000, player.getDinero());


    }
}
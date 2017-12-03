package Entrega2;


import excepciones.CasasInsuficientes;
import org.junit.Assert;
import org.junit.Test;

import modelo.Casa;
import modelo.Hotel;
import modelo.Tablero;
import modelo.Jugador.Jugador;


public class Prueba205Test {

    @Test (expected = CasasInsuficientes.class)
    public void test01JugadorConstruyeHotelSinTenerCasas() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("Player");
        player.setEstado(player.getJugadorEmpezandoTurno());
        untablero.agregarJugador(player);

        player.comprar(untablero.getBuenosAiresNorte());

        player.comprar(untablero.getBuenosAiresSur());

        Assert.assertEquals(55000, player.getDinero());

        player.construir(untablero.getBuenosAiresSur(), new Hotel());

        Assert.assertEquals(55000, player.getDinero());


    }

    @Test (expected = CasasInsuficientes.class)
    public void test02JugadorConstruyeHotelConTresCasas() throws Exception {

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

        Assert.assertEquals(39500, player.getDinero());

        player.construir(untablero.getBuenosAiresSur(), new Hotel());

        Assert.assertEquals(39500, player.getDinero());


    }
}

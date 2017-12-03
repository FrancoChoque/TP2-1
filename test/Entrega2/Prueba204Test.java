package Entrega2;


import org.junit.Assert;
import org.junit.Test;

import modelo.Casa;
import modelo.Tablero;
import modelo.Jugador.Jugador;

public class Prueba204Test {

    @Test
    public void test01JugadorCaeEnBuenosAiresSurConDosCasasYPaga3500() throws Exception{

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");
        player.setEstado(player.getJugadorEmpezandoTurno());
        untablero.agregarJugador(player);

        player.comprar(untablero.getBuenosAiresNorte());

        player.comprar(untablero.getBuenosAiresSur());

        player.construir(untablero.getBuenosAiresSur(), new Casa());

        player.construir(untablero.getBuenosAiresSur(), new Casa());

        Jugador jugador = new Jugador("Wilson");
        jugador.setEstado(jugador.getJugadorEmpezandoTurno() );
        untablero.agregarJugador(jugador);
        untablero.moverJugador(jugador, 2);

        Assert.assertEquals(96500, jugador.getDinero());


    }

    @Test
    public void test02JugadorCaeEnBuenosAiresNorteConCasaYPaga3500() throws Exception{

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();

        Jugador player = new Jugador("plauer");
        player.setEstado(player.getJugadorEmpezandoTurno());
        untablero.agregarJugador(player);

        player.comprar(untablero.getBuenosAiresNorte());

        player.comprar(untablero.getBuenosAiresSur());

        player.construir(untablero.getBuenosAiresNorte(), new Casa());

        Jugador jugador = new Jugador("Wilson");
        jugador.setEstado(jugador.getJugadorEmpezandoTurno() );
        untablero.agregarJugador(jugador);
        untablero.moverJugador(jugador, 4);

        Assert.assertEquals(96500, jugador.getDinero());


    }
}

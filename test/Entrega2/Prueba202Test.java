package Entrega2;

import modelo.Jugador.Jugador;
import modelo.Casa;
import modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class Prueba202Test {

    @Test

    public void construirCasaEnBuenosAiresNorteReduceDineroEn5500() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();


        Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprar(untablero.getBuenosAiresSur());

        player.comprar(untablero.getBuenosAiresNorte());

        player.construir(untablero.getBuenosAiresNorte(), new Casa());

        Assert.assertEquals(49500, player.getDinero() );

    }

    @Test

    public void construirCasaEnBuenosAiresSurReduceDineroEn5000() throws Exception {

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();


        Jugador player = new Jugador("player");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprar(untablero.getBuenosAiresSur());

        player.comprar(untablero.getBuenosAiresNorte());

        player.construir(untablero.getBuenosAiresSur(), new Casa());

        Assert.assertEquals(50000, player.getDinero() );

    }


}

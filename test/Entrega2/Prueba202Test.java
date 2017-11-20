package Entrega2;

import modelo.Jugador.Jugador;
import modelo.Tablero;
import org.junit.Assert;
import org.junit.Test;

public class Prueba202Test {

    @Test

    public void construirCasaEnBuenosAiresNorteReduceDineroEn5500(){

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();


        Jugador player = new Jugador("plauer");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprarTerreno(untablero.getBuenosAiresSur());

        player.comprarTerreno(untablero.getBuenosAiresNorte());

        player.construirCasa(untablero.getBuenosAiresNorte());

        Assert.assertEquals(49500, player.getDinero() );

    }

    @Test

    public void construirCasaEnBuenosAiresSurReduceDineroEn5000(){

        Tablero untablero = Tablero.getInstance();
        untablero.resetearTablero();


        Jugador player = new Jugador("player");

        player.setEstado(player.getJugadorEmpezandoTurno());

        untablero.agregarJugador(player);

        player.comprarTerreno(untablero.getBuenosAiresSur());

        player.comprarTerreno(untablero.getBuenosAiresNorte());

        player.construirCasa(untablero.getBuenosAiresSur());

        Assert.assertEquals(50000, player.getDinero() );

    }


}
